/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmgroup.web;

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
import com.jeeplus.modules.vmgroup.entity.VmGroup;
import com.jeeplus.modules.vmgroup.service.VmGroupService;

/**
 * 售货机分组Controller
 * @author Jason Dong
 * @version 2017-12-12
 */
@Controller
@RequestMapping(value = "${adminPath}/vmgroup/vmGroup")
public class VmGroupController extends BaseController {

	@Autowired
	private VmGroupService vmGroupService;
	
	@ModelAttribute
	public VmGroup get(@RequestParam(required=false) String id) {
		VmGroup entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vmGroupService.get(id);
		}
		if (entity == null){
			entity = new VmGroup();
		}
		return entity;
	}
	
	/**
	 * 保存售货机分组成功列表页面
	 */
	@RequiresPermissions("vmgroup:vmGroup:list")
	@RequestMapping(value = {"list", ""})
	public String list(VmGroup vmGroup, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VmGroup> page = vmGroupService.findPage(new Page<VmGroup>(request, response), vmGroup); 
		model.addAttribute("page", page);
		return "modules/vmgroup/vmGroupList";
	}

	/**
	 * 查看，增加，编辑保存售货机分组成功表单页面
	 */
	@RequiresPermissions(value={"vmgroup:vmGroup:view","vmgroup:vmGroup:add","vmgroup:vmGroup:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(VmGroup vmGroup, Model model) {
		model.addAttribute("vmGroup", vmGroup);
		return "modules/vmgroup/vmGroupForm";
	}

	/**
	 * 保存保存售货机分组成功
	 */
	@RequiresPermissions(value={"vmgroup:vmGroup:add","vmgroup:vmGroup:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(VmGroup vmGroup, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, vmGroup)){
			return form(vmGroup, model);
		}
		if(!vmGroup.getIsNewRecord()){//编辑表单保存
			VmGroup t = vmGroupService.get(vmGroup.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(vmGroup, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			vmGroupService.save(t);//保存
		}else{//新增表单保存
			vmGroupService.save(vmGroup);//保存
		}
		addMessage(redirectAttributes, "保存保存售货机分组成功成功");
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
	}
	
	/**
	 * 删除保存售货机分组成功
	 */
	@RequiresPermissions("vmgroup:vmGroup:del")
	@RequestMapping(value = "delete")
	public String delete(VmGroup vmGroup, RedirectAttributes redirectAttributes) {
		vmGroupService.delete(vmGroup);
		addMessage(redirectAttributes, "删除保存售货机分组成功成功");
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
	}
	
	/**
	 * 批量删除保存售货机分组成功
	 */
	@RequiresPermissions("vmgroup:vmGroup:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			vmGroupService.delete(vmGroupService.get(id));
		}
		addMessage(redirectAttributes, "删除保存售货机分组成功成功");
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("vmgroup:vmGroup:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(VmGroup vmGroup, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "保存售货机分组成功"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<VmGroup> page = vmGroupService.findPage(new Page<VmGroup>(request, response, -1), vmGroup);
    		new ExportExcel("保存售货机分组成功", VmGroup.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出保存售货机分组成功记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("vmgroup:vmGroup:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<VmGroup> list = ei.getDataList(VmGroup.class);
			for (VmGroup vmGroup : list){
				try{
					vmGroupService.save(vmGroup);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条保存售货机分组成功记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条保存售货机分组成功记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入保存售货机分组成功失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
    }
	
	/**
	 * 下载导入保存售货机分组成功数据模板
	 */
	@RequiresPermissions("vmgroup:vmGroup:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "保存售货机分组成功数据导入模板.xlsx";
    		List<VmGroup> list = Lists.newArrayList(); 
    		new ExportExcel("保存售货机分组成功数据", VmGroup.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vmgroup/vmGroup/?repage";
    }
	
	
	

}