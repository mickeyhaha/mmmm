/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.batch.web;

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
import com.jeeplus.modules.batch.entity.Batch;
import com.jeeplus.modules.batch.service.BatchService;

/**
 * 批次管理Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/batch/batch")
public class BatchController extends BaseController {

	@Autowired
	private BatchService batchService;
	
	@ModelAttribute
	public Batch get(@RequestParam(required=false) String id) {
		Batch entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = batchService.get(id);
		}
		if (entity == null){
			entity = new Batch();
		}
		return entity;
	}
	
	/**
	 * 批次管理列表页面
	 */
	@RequiresPermissions("batch:batch:list")
	@RequestMapping(value = {"list", ""})
	public String list(Batch batch, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Batch> page = batchService.findPage(new Page<Batch>(request, response), batch); 
		model.addAttribute("page", page);
		return "modules/batch/batchList";
	}

	/**
	 * 查看，增加，编辑批次管理表单页面
	 */
	@RequiresPermissions(value={"batch:batch:view","batch:batch:add","batch:batch:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Batch batch, Model model) {
		model.addAttribute("batch", batch);
		return "modules/batch/batchForm";
	}

	/**
	 * 保存批次管理
	 */
	@RequiresPermissions(value={"batch:batch:add","batch:batch:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Batch batch, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, batch)){
			return form(batch, model);
		}
		if(!batch.getIsNewRecord()){//编辑表单保存
			Batch t = batchService.get(batch.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(batch, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			batchService.save(t);//保存
		}else{//新增表单保存
			batchService.save(batch);//保存
		}
		addMessage(redirectAttributes, "保存批次管理成功");
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
	}
	
	/**
	 * 删除批次管理
	 */
	@RequiresPermissions("batch:batch:del")
	@RequestMapping(value = "delete")
	public String delete(Batch batch, RedirectAttributes redirectAttributes) {
		batchService.delete(batch);
		addMessage(redirectAttributes, "删除批次管理成功");
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
	}
	
	/**
	 * 批量删除批次管理
	 */
	@RequiresPermissions("batch:batch:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			batchService.delete(batchService.get(id));
		}
		addMessage(redirectAttributes, "删除批次管理成功");
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("batch:batch:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Batch batch, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "批次管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Batch> page = batchService.findPage(new Page<Batch>(request, response, -1), batch);
    		new ExportExcel("批次管理", Batch.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出批次管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("batch:batch:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Batch> list = ei.getDataList(Batch.class);
			for (Batch batch : list){
				try{
					batchService.save(batch);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条批次管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条批次管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入批次管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
    }
	
	/**
	 * 下载导入批次管理数据模板
	 */
	@RequiresPermissions("batch:batch:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "批次管理数据导入模板.xlsx";
    		List<Batch> list = Lists.newArrayList(); 
    		new ExportExcel("批次管理数据", Batch.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/batch/batch/?repage";
    }
	
	
	

}