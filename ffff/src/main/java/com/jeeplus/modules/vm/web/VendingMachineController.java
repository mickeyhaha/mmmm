/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vm.web;

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

import com.jeeplus.modules.vmgroup.entity.VmGroup;
import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.vm.service.VendingMachineService;

/**
 * 售货机管理Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/vm/vendingMachine")
public class VendingMachineController extends BaseController {

	@Autowired
	private VendingMachineService vendingMachineService;
	
	@ModelAttribute
	public VendingMachine get(@RequestParam(required=false) String id) {
		VendingMachine entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vendingMachineService.get(id);
		}
		if (entity == null){
			entity = new VendingMachine();
		}
		return entity;
	}
	
	/**
	 * 售货机管理列表页面
	 */
	@RequiresPermissions("vm:vendingMachine:list")
	@RequestMapping(value = {"list", ""})
	public String list(VendingMachine vendingMachine, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VendingMachine> page = vendingMachineService.findPage(new Page<VendingMachine>(request, response), vendingMachine); 
		model.addAttribute("page", page);
		return "modules/vm/vendingMachineList";
	}

	/**
	 * 查看，增加，编辑售货机管理表单页面
	 */
	@RequiresPermissions(value={"vm:vendingMachine:view","vm:vendingMachine:add","vm:vendingMachine:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(VendingMachine vendingMachine, Model model) {
		model.addAttribute("vendingMachine", vendingMachine);
		return "modules/vm/vendingMachineForm";
	}

	/**
	 * 保存售货机管理
	 */
	@RequiresPermissions(value={"vm:vendingMachine:add","vm:vendingMachine:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(VendingMachine vendingMachine, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, vendingMachine)){
			return form(vendingMachine, model);
		}
		if(!vendingMachine.getIsNewRecord()){//编辑表单保存
			VendingMachine t = vendingMachineService.get(vendingMachine.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(vendingMachine, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			vendingMachineService.save(t);//保存
		}else{//新增表单保存
			vendingMachineService.save(vendingMachine);//保存
		}
		addMessage(redirectAttributes, "保存售货机管理成功");
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
	}
	
	/**
	 * 删除售货机管理
	 */
	@RequiresPermissions("vm:vendingMachine:del")
	@RequestMapping(value = "delete")
	public String delete(VendingMachine vendingMachine, RedirectAttributes redirectAttributes) {
		vendingMachineService.delete(vendingMachine);
		addMessage(redirectAttributes, "删除售货机管理成功");
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
	}
	
	/**
	 * 批量删除售货机管理
	 */
	@RequiresPermissions("vm:vendingMachine:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			vendingMachineService.delete(vendingMachineService.get(id));
		}
		addMessage(redirectAttributes, "删除售货机管理成功");
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("vm:vendingMachine:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(VendingMachine vendingMachine, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<VendingMachine> page = vendingMachineService.findPage(new Page<VendingMachine>(request, response, -1), vendingMachine);
    		new ExportExcel("售货机管理", VendingMachine.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出售货机管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("vm:vendingMachine:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<VendingMachine> list = ei.getDataList(VendingMachine.class);
			for (VendingMachine vendingMachine : list){
				try{
					vendingMachineService.save(vendingMachine);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条售货机管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条售货机管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入售货机管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
    }
	
	/**
	 * 下载导入售货机管理数据模板
	 */
	@RequiresPermissions("vm:vendingMachine:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "售货机管理数据导入模板.xlsx";
    		List<VendingMachine> list = Lists.newArrayList(); 
    		new ExportExcel("售货机管理数据", VendingMachine.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/vm/vendingMachine/?repage";
    }
	
	
	/**
	 * 选择分组编号
	 */
	@RequestMapping(value = "selectvmGroup")
	public String selectvmGroup(VmGroup vmGroup, String url, String fieldLabels, String fieldKeys, String searchLabel, String searchKey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VmGroup> page = vendingMachineService.findPageByvmGroup(new Page<VmGroup>(request, response),  vmGroup);
		try {
			fieldLabels = URLDecoder.decode(fieldLabels, "UTF-8");
			fieldKeys = URLDecoder.decode(fieldKeys, "UTF-8");
			searchLabel = URLDecoder.decode(searchLabel, "UTF-8");
			searchKey = URLDecoder.decode(searchKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("labelNames", fieldLabels.split("\\|"));
		model.addAttribute("labelValues", fieldKeys.split("\\|"));
		model.addAttribute("fieldLabels", fieldLabels);
		model.addAttribute("fieldKeys", fieldKeys);
		model.addAttribute("url", url);
		model.addAttribute("searchLabel", searchLabel);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("obj", vmGroup);
		model.addAttribute("page", page);
		return "modules/sys/gridselect";
	}
	

}