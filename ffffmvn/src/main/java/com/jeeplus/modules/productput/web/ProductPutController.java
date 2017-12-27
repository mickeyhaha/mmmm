/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.productput.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeeplus.modules.product.entity.Product;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;
import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.productput.entity.ProductPut;
import com.jeeplus.modules.productput.service.ProductPutService;

/**
 * 补货单管理Controller
 * @author Jason Dong
 * @version 2017-12-20
 */
@Controller
@RequestMapping(value = "${adminPath}/productput/productPut")
public class ProductPutController extends BaseController {

	@Autowired
	private ProductPutService productPutService;
	
	@ModelAttribute
	public ProductPut get(@RequestParam(required=false) String id) {
		ProductPut entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productPutService.get(id);
		}
		if (entity == null){
			entity = new ProductPut();
		}
		return entity;
	}
	
	/**
	 * 补货单管理列表页面
	 */
	@RequiresPermissions("productput:productPut:list")
	@RequestMapping(value = {"list", ""})
	public String list(ProductPut productPut, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductPut> page = productPutService.findPage(new Page<ProductPut>(request, response), productPut); 
		model.addAttribute("page", page);
		return "modules/productput/productPutList";
	}

	/**
	 * 查看，增加，编辑补货单管理表单页面
	 */
	@RequiresPermissions(value={"productput:productPut:view","productput:productPut:add","productput:productPut:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(ProductPut productPut, Model model) {
		model.addAttribute("productPut", productPut);
		return "modules/productput/productPutForm";
	}

	/**
	 * 保存补货单管理
	 */
	@RequiresPermissions(value={"productput:productPut:add","productput:productPut:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(ProductPut productPut, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, productPut)){
			return form(productPut, model);
		}
		if(!productPut.getIsNewRecord()){//编辑表单保存
			ProductPut t = productPutService.get(productPut.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(productPut, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			productPutService.save(t);//保存
		}else{//新增表单保存
			productPutService.save(productPut);//保存
		}
		addMessage(redirectAttributes, "保存补货单管理成功");
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
	}
	
	/**
	 * 删除补货单管理
	 */
	@RequiresPermissions("productput:productPut:del")
	@RequestMapping(value = "delete")
	public String delete(ProductPut productPut, RedirectAttributes redirectAttributes) {
		productPutService.delete(productPut);
		addMessage(redirectAttributes, "删除补货单管理成功");
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
	}
	
	/**
	 * 批量删除补货单管理
	 */
	@RequiresPermissions("productput:productPut:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			productPutService.delete(productPutService.get(id));
		}
		addMessage(redirectAttributes, "删除补货单管理成功");
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("productput:productPut:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(ProductPut productPut, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "补货单管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<ProductPut> page = productPutService.findPage(new Page<ProductPut>(request, response, -1), productPut);
    		new ExportExcel("补货单管理", ProductPut.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出补货单管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("productput:productPut:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<ProductPut> list = ei.getDataList(ProductPut.class);
			for (ProductPut productPut : list){
				try{
					productPutService.save(productPut);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条补货单管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条补货单管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入补货单管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
    }
	
	/**
	 * 下载导入补货单管理数据模板
	 */
	@RequiresPermissions("productput:productPut:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "补货单管理数据导入模板.xlsx";
    		List<ProductPut> list = Lists.newArrayList(); 
    		new ExportExcel("补货单管理数据", ProductPut.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/productput/productPut/?repage";
    }
	
	
	/**
	 * 选择货物ID
	 */
	@RequestMapping(value = "selectproduct")
	public String selectproduct(Product product, String url, String fieldLabels, String fieldKeys, String searchLabel, String searchKey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Product> page = productPutService.findPageByproduct(new Page<Product>(request, response),  product);
		try {
			fieldLabels = URLDecoder.decode(fieldLabels, "UTF-8");
			fieldKeys = URLDecoder.decode(fieldKeys, "UTF-8");
			searchLabel = URLDecoder.decode(searchLabel, "UTF-8");
			searchKey = URLDecoder.decode(searchKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("labelNames", fieldLabels.split("-"));		//\\|
		model.addAttribute("labelValues", fieldKeys.split("-"));		//\\|
		model.addAttribute("fieldLabels", fieldLabels);
		model.addAttribute("fieldKeys", fieldKeys);
		model.addAttribute("url", url);
		model.addAttribute("searchLabel", searchLabel);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("obj", product);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}
	/**
	 * 选择售货机ID
	 */
	@RequestMapping(value = "selectvendingMachine")
	public String selectvendingMachine(VendingMachine vendingMachine, String url, String fieldLabels, String fieldKeys, String searchLabel, String searchKey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VendingMachine> page = productPutService.findPageByvendingMachine(new Page<VendingMachine>(request, response),  vendingMachine);
		try {
			fieldLabels = URLDecoder.decode(fieldLabels, "UTF-8");
			fieldKeys = URLDecoder.decode(fieldKeys, "UTF-8");
			searchLabel = URLDecoder.decode(searchLabel, "UTF-8");
			searchKey = URLDecoder.decode(searchKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("labelNames", fieldLabels.split("-"));		//\\|
		model.addAttribute("labelValues", fieldKeys.split("-"));		//\\|
		model.addAttribute("fieldLabels", fieldLabels);
		model.addAttribute("fieldKeys", fieldKeys);
		model.addAttribute("url", url);
		model.addAttribute("searchLabel", searchLabel);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("obj", vendingMachine);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}
	/**
	 * 选择补货员ID
	 */
	@RequestMapping(value = "selectuser")
	public String selectuser(User user, String url, String fieldLabels, String fieldKeys, String searchLabel, String searchKey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = productPutService.findPageByuser(new Page<User>(request, response),  user);
		try {
			fieldLabels = URLDecoder.decode(fieldLabels, "UTF-8");
			fieldKeys = URLDecoder.decode(fieldKeys, "UTF-8");
			searchLabel = URLDecoder.decode(searchLabel, "UTF-8");
			searchKey = URLDecoder.decode(searchKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("labelNames", fieldLabels.split("-"));		//\\|
		model.addAttribute("labelValues", fieldKeys.split("-"));		//\\|
		model.addAttribute("fieldLabels", fieldLabels);
		model.addAttribute("fieldKeys", fieldKeys);
		model.addAttribute("url", url);
		model.addAttribute("searchLabel", searchLabel);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("obj", user);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}
	

}