/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.refund.web;

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
import com.jeeplus.modules.refund.entity.Refund;
import com.jeeplus.modules.refund.service.RefundService;

/**
 * 退款Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/refund/refund")
public class RefundController extends BaseController {

	@Autowired
	private RefundService refundService;
	
	@ModelAttribute
	public Refund get(@RequestParam(required=false) String id) {
		Refund entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = refundService.get(id);
		}
		if (entity == null){
			entity = new Refund();
		}
		return entity;
	}
	
	/**
	 * 退款列表页面
	 */
	@RequiresPermissions("refund:refund:list")
	@RequestMapping(value = {"list", ""})
	public String list(Refund refund, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Refund> page = refundService.findPage(new Page<Refund>(request, response), refund); 
		model.addAttribute("page", page);
		return "modules/refund/refundList";
	}

	/**
	 * 查看，增加，编辑退款表单页面
	 */
	@RequiresPermissions(value={"refund:refund:view","refund:refund:add","refund:refund:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Refund refund, Model model) {
		model.addAttribute("refund", refund);
		return "modules/refund/refundForm";
	}

	/**
	 * 保存退款
	 */
	@RequiresPermissions(value={"refund:refund:add","refund:refund:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Refund refund, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, refund)){
			return form(refund, model);
		}
		if(!refund.getIsNewRecord()){//编辑表单保存
			Refund t = refundService.get(refund.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(refund, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			refundService.save(t);//保存
		}else{//新增表单保存
			refundService.save(refund);//保存
		}
		addMessage(redirectAttributes, "保存退款成功");
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
	}
	
	/**
	 * 删除退款
	 */
	@RequiresPermissions("refund:refund:del")
	@RequestMapping(value = "delete")
	public String delete(Refund refund, RedirectAttributes redirectAttributes) {
		refundService.delete(refund);
		addMessage(redirectAttributes, "删除退款成功");
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
	}
	
	/**
	 * 批量删除退款
	 */
	@RequiresPermissions("refund:refund:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			refundService.delete(refundService.get(id));
		}
		addMessage(redirectAttributes, "删除退款成功");
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("refund:refund:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Refund refund, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "退款"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Refund> page = refundService.findPage(new Page<Refund>(request, response, -1), refund);
    		new ExportExcel("退款", Refund.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出退款记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("refund:refund:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Refund> list = ei.getDataList(Refund.class);
			for (Refund refund : list){
				try{
					refundService.save(refund);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条退款记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条退款记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入退款失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
    }
	
	/**
	 * 下载导入退款数据模板
	 */
	@RequiresPermissions("refund:refund:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "退款数据导入模板.xlsx";
    		List<Refund> list = Lists.newArrayList(); 
    		new ExportExcel("退款数据", Refund.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/refund/refund/?repage";
    }
	
	
	

}