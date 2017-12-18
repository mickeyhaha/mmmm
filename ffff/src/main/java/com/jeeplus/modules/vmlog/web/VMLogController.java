/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmlog.web;

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
import com.jeeplus.modules.vmlog.entity.VMLog;
import com.jeeplus.modules.vmlog.service.VMLogService;

/**
 * 售货机日志Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/vmlog/vMLog")
public class VMLogController extends BaseController {

	@Autowired
	private VMLogService vMLogService;
	
	@ModelAttribute
	public VMLog get(@RequestParam(required=false) String id) {
		VMLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vMLogService.get(id);
		}
		if (entity == null){
			entity = new VMLog();
		}
		return entity;
	}
	
	/**
	 * 售货机日志列表页面
	 */
	@RequiresPermissions("vmlog:vMLog:list")
	@RequestMapping(value = {"list", ""})
	public String list(VMLog vMLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VMLog> page = vMLogService.findPage(new Page<VMLog>(request, response), vMLog); 
		model.addAttribute("page", page);
		return "modules/vmlog/vMLogList";
	}

	/**
	 * 查看，增加，编辑售货机日志表单页面
	 */
	@RequiresPermissions(value={"vmlog:vMLog:view","vmlog:vMLog:add","vmlog:vMLog:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(VMLog vMLog, Model model) {
		model.addAttribute("vMLog", vMLog);
		return "modules/vmlog/vMLogForm";
	}

	/**
	 * 保存售货机日志
	 */
	@RequiresPermissions(value={"vmlog:vMLog:add","vmlog:vMLog:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(VMLog vMLog, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, vMLog)){
			return form(vMLog, model);
		}
		if(!vMLog.getIsNewRecord()){//编辑表单保存
			VMLog t = vMLogService.get(vMLog.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(vMLog, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			vMLogService.save(t);//保存
		}else{//新增表单保存
			vMLogService.save(vMLog);//保存
		}
		addMessage(redirectAttributes, "保存售货机日志成功");
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
	}
	
	/**
	 * 删除售货机日志
	 */
	@RequiresPermissions("vmlog:vMLog:del")
	@RequestMapping(value = "delete")
	public String delete(VMLog vMLog, RedirectAttributes redirectAttributes) {
		vMLogService.delete(vMLog);
		addMessage(redirectAttributes, "删除售货机日志成功");
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
	}
	
	/**
	 * 批量删除售货机日志
	 */
	@RequiresPermissions("vmlog:vMLog:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			vMLogService.delete(vMLogService.get(id));
		}
		addMessage(redirectAttributes, "删除售货机日志成功");
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("vmlog:vMLog:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(VMLog vMLog, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机日志"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<VMLog> page = vMLogService.findPage(new Page<VMLog>(request, response, -1), vMLog);
    		new ExportExcel("售货机日志", VMLog.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出售货机日志记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("vmlog:vMLog:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<VMLog> list = ei.getDataList(VMLog.class);
			for (VMLog vMLog : list){
				try{
					vMLogService.save(vMLog);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条售货机日志记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条售货机日志记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入售货机日志失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
    }
	
	/**
	 * 下载导入售货机日志数据模板
	 */
	@RequiresPermissions("vmlog:vMLog:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机日志数据导入模板.xlsx";
    		List<VMLog> list = Lists.newArrayList(); 
    		new ExportExcel("售货机日志数据", VMLog.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmlog/vMLog/?repage";
    }
	
	
	

}