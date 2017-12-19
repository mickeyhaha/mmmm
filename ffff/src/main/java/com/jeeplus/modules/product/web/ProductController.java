/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.product.web;

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

import com.jeeplus.modules.batch.entity.Batch;
import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.product.entity.Product;
import com.jeeplus.modules.product.service.ProductService;

/**
 * 产品列表Controller
 * @author Jason Dong
 * @version 2017-12-19
 */
@Controller
@RequestMapping(value = "${adminPath}/product/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute
	public Product get(@RequestParam(required=false) String id) {
		Product entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productService.get(id);
		}
		if (entity == null){
			entity = new Product();
		}
		return entity;
	}
	
	/**
	 * 产品列表列表页面
	 */
	@RequiresPermissions("product:product:list")
	@RequestMapping(value = {"list", ""})
	public String list(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Product> page = productService.findPage(new Page<Product>(request, response), product); 
		model.addAttribute("page", page);
		return "modules/product/productList";
	}

	/**
	 * 查看，增加，编辑产品列表表单页面
	 */
	@RequiresPermissions(value={"product:product:view","product:product:add","product:product:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Product product, Model model) {
		model.addAttribute("product", product);
		return "modules/product/productForm";
	}

	/**
	 * 保存产品列表
	 */
	@RequiresPermissions(value={"product:product:add","product:product:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Product product, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, product)){
			return form(product, model);
		}
		if(!product.getIsNewRecord()){//编辑表单保存
			Product t = productService.get(product.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(product, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			productService.save(t);//保存
		}else{//新增表单保存
			productService.save(product);//保存
		}
		addMessage(redirectAttributes, "保存产品列表成功");
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
	}
	
	/**
	 * 删除产品列表
	 */
	@RequiresPermissions("product:product:del")
	@RequestMapping(value = "delete")
	public String delete(Product product, RedirectAttributes redirectAttributes) {
		productService.delete(product);
		addMessage(redirectAttributes, "删除产品列表成功");
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
	}
	
	/**
	 * 批量删除产品列表
	 */
	@RequiresPermissions("product:product:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			productService.delete(productService.get(id));
		}
		addMessage(redirectAttributes, "删除产品列表成功");
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("product:product:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Product product, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "产品列表"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Product> page = productService.findPage(new Page<Product>(request, response, -1), product);
    		new ExportExcel("产品列表", Product.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出产品列表记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("product:product:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Product> list = ei.getDataList(Product.class);
			for (Product product : list){
				try{
					productService.save(product);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条产品列表记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条产品列表记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入产品列表失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
    }
	
	/**
	 * 下载导入产品列表数据模板
	 */
	@RequiresPermissions("product:product:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "产品列表数据导入模板.xlsx";
    		List<Product> list = Lists.newArrayList(); 
    		new ExportExcel("产品列表数据", Product.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/product/product/?repage";
    }
	
	
	/**
	 * 选择批次号
	 */
	@RequestMapping(value = "selectbatch")
	public String selectbatch(Batch batch, String url, String fieldLabels, String fieldKeys, String searchLabel, String searchKey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Batch> page = productService.findPageBybatch(new Page<Batch>(request, response),  batch);
		try {
			fieldLabels = URLDecoder.decode(fieldLabels, "UTF-8");
			fieldKeys = URLDecoder.decode(fieldKeys, "UTF-8");
			searchLabel = URLDecoder.decode(searchLabel, "UTF-8");
			searchKey = URLDecoder.decode(searchKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("labelNames", fieldLabels.split("-"));
		model.addAttribute("labelValues", fieldKeys.split("-"));
		model.addAttribute("fieldLabels", fieldLabels);
		model.addAttribute("fieldKeys", fieldKeys);
		model.addAttribute("url", url);
		model.addAttribute("searchLabel", searchLabel);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("obj", batch);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}
	

}