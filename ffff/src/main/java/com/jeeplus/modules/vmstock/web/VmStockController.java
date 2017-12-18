/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmstock.web;

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

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.vmstock.entity.VmStock;
import com.jeeplus.modules.vmstock.service.VmStockService;

/**
 * 售货机库存Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/vmstock/vmStock")
public class VmStockController extends BaseController {

	@Autowired
	private VmStockService vmStockService;
	
	@ModelAttribute
	public VmStock get(@RequestParam(required=false) String id) {
		VmStock entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vmStockService.get(id);
		}
		if (entity == null){
			entity = new VmStock();
		}
		return entity;
	}
	
	/**
	 * 售货机库存列表页面
	 */
	@RequiresPermissions("vmstock:vmStock:list")
	@RequestMapping(value = {"list", ""})
	public String list(VmStock vmStock, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VmStock> page = vmStockService.findPage(new Page<VmStock>(request, response), vmStock); 
		model.addAttribute("page", page);
		return "modules/vmstock/vmStockList";
	}

	/**
	 * 查看，增加，编辑售货机库存表单页面
	 */
	@RequiresPermissions(value={"vmstock:vmStock:view","vmstock:vmStock:add","vmstock:vmStock:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(VmStock vmStock, Model model) {
		model.addAttribute("vmStock", vmStock);
		return "modules/vmstock/vmStockForm";
	}

	/**
	 * 保存售货机库存
	 */
	@RequiresPermissions(value={"vmstock:vmStock:add","vmstock:vmStock:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(VmStock vmStock, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, vmStock)){
			return form(vmStock, model);
		}
		if(!vmStock.getIsNewRecord()){//编辑表单保存
			VmStock t = vmStockService.get(vmStock.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(vmStock, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			vmStockService.save(t);//保存
		}else{//新增表单保存
			vmStockService.save(vmStock);//保存
		}
		addMessage(redirectAttributes, "保存售货机库存成功");
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
	}
	
	/**
	 * 删除售货机库存
	 */
	@RequiresPermissions("vmstock:vmStock:del")
	@RequestMapping(value = "delete")
	public String delete(VmStock vmStock, RedirectAttributes redirectAttributes) {
		vmStockService.delete(vmStock);
		addMessage(redirectAttributes, "删除售货机库存成功");
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
	}
	
	/**
	 * 批量删除售货机库存
	 */
	@RequiresPermissions("vmstock:vmStock:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			vmStockService.delete(vmStockService.get(id));
		}
		addMessage(redirectAttributes, "删除售货机库存成功");
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("vmstock:vmStock:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(VmStock vmStock, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机库存"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<VmStock> page = vmStockService.findPage(new Page<VmStock>(request, response, -1), vmStock);
    		new ExportExcel("售货机库存", VmStock.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出售货机库存记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("vmstock:vmStock:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<VmStock> list = ei.getDataList(VmStock.class);
			for (VmStock vmStock : list){
				try{
					vmStockService.save(vmStock);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条售货机库存记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条售货机库存记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入售货机库存失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
    }
	
	/**
	 * 下载导入售货机库存数据模板
	 */
	@RequiresPermissions("vmstock:vmStock:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机库存数据导入模板.xlsx";
    		List<VmStock> list = Lists.newArrayList(); 
    		new ExportExcel("售货机库存数据", VmStock.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmstock/vmStock/?repage";
    }
	
	
	

}