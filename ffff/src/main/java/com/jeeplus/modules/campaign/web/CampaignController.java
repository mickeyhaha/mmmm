/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.campaign.web;

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
import com.jeeplus.modules.campaign.entity.Campaign;
import com.jeeplus.modules.campaign.service.CampaignService;

/**
 * 促销Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/campaign/campaign")
public class CampaignController extends BaseController {

	@Autowired
	private CampaignService campaignService;
	
	@ModelAttribute
	public Campaign get(@RequestParam(required=false) String id) {
		Campaign entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = campaignService.get(id);
		}
		if (entity == null){
			entity = new Campaign();
		}
		return entity;
	}
	
	/**
	 * 促销列表页面
	 */
	@RequiresPermissions("campaign:campaign:list")
	@RequestMapping(value = {"list", ""})
	public String list(Campaign campaign, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Campaign> page = campaignService.findPage(new Page<Campaign>(request, response), campaign); 
		model.addAttribute("page", page);
		return "modules/campaign/campaignList";
	}

	/**
	 * 查看，增加，编辑促销表单页面
	 */
	@RequiresPermissions(value={"campaign:campaign:view","campaign:campaign:add","campaign:campaign:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Campaign campaign, Model model) {
		model.addAttribute("campaign", campaign);
		return "modules/campaign/campaignForm";
	}

	/**
	 * 保存促销
	 */
	@RequiresPermissions(value={"campaign:campaign:add","campaign:campaign:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Campaign campaign, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, campaign)){
			return form(campaign, model);
		}
		if(!campaign.getIsNewRecord()){//编辑表单保存
			Campaign t = campaignService.get(campaign.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(campaign, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			campaignService.save(t);//保存
		}else{//新增表单保存
			campaignService.save(campaign);//保存
		}
		addMessage(redirectAttributes, "保存促销成功");
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
	}
	
	/**
	 * 删除促销
	 */
	@RequiresPermissions("campaign:campaign:del")
	@RequestMapping(value = "delete")
	public String delete(Campaign campaign, RedirectAttributes redirectAttributes) {
		campaignService.delete(campaign);
		addMessage(redirectAttributes, "删除促销成功");
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
	}
	
	/**
	 * 批量删除促销
	 */
	@RequiresPermissions("campaign:campaign:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			campaignService.delete(campaignService.get(id));
		}
		addMessage(redirectAttributes, "删除促销成功");
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("campaign:campaign:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Campaign campaign, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "促销"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Campaign> page = campaignService.findPage(new Page<Campaign>(request, response, -1), campaign);
    		new ExportExcel("促销", Campaign.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出促销记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("campaign:campaign:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Campaign> list = ei.getDataList(Campaign.class);
			for (Campaign campaign : list){
				try{
					campaignService.save(campaign);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条促销记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条促销记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入促销失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
    }
	
	/**
	 * 下载导入促销数据模板
	 */
	@RequiresPermissions("campaign:campaign:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "促销数据导入模板.xlsx";
    		List<Campaign> list = Lists.newArrayList(); 
    		new ExportExcel("促销数据", Campaign.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/campaign/campaign/?repage";
    }
	
	
	

}