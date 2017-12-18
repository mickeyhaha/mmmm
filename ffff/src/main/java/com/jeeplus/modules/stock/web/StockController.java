/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.stock.web;

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
import com.jeeplus.modules.stock.entity.Stock;
import com.jeeplus.modules.stock.service.StockService;

/**
 * 仓库库存Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/stock/stock")
public class StockController extends BaseController {

	@Autowired
	private StockService stockService;
	
	@ModelAttribute
	public Stock get(@RequestParam(required=false) String id) {
		Stock entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = stockService.get(id);
		}
		if (entity == null){
			entity = new Stock();
		}
		return entity;
	}
	
	/**
	 * 仓库库存列表页面
	 */
	@RequiresPermissions("stock:stock:list")
	@RequestMapping(value = {"list", ""})
	public String list(Stock stock, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Stock> page = stockService.findPage(new Page<Stock>(request, response), stock); 
		model.addAttribute("page", page);
		return "modules/stock/stockList";
	}

	/**
	 * 查看，增加，编辑仓库库存表单页面
	 */
	@RequiresPermissions(value={"stock:stock:view","stock:stock:add","stock:stock:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Stock stock, Model model) {
		model.addAttribute("stock", stock);
		return "modules/stock/stockForm";
	}

	/**
	 * 保存仓库库存
	 */
	@RequiresPermissions(value={"stock:stock:add","stock:stock:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Stock stock, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, stock)){
			return form(stock, model);
		}
		if(!stock.getIsNewRecord()){//编辑表单保存
			Stock t = stockService.get(stock.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(stock, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			stockService.save(t);//保存
		}else{//新增表单保存
			stockService.save(stock);//保存
		}
		addMessage(redirectAttributes, "保存仓库库存成功");
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
	}
	
	/**
	 * 删除仓库库存
	 */
	@RequiresPermissions("stock:stock:del")
	@RequestMapping(value = "delete")
	public String delete(Stock stock, RedirectAttributes redirectAttributes) {
		stockService.delete(stock);
		addMessage(redirectAttributes, "删除仓库库存成功");
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
	}
	
	/**
	 * 批量删除仓库库存
	 */
	@RequiresPermissions("stock:stock:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			stockService.delete(stockService.get(id));
		}
		addMessage(redirectAttributes, "删除仓库库存成功");
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("stock:stock:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Stock stock, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "仓库库存"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Stock> page = stockService.findPage(new Page<Stock>(request, response, -1), stock);
    		new ExportExcel("仓库库存", Stock.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出仓库库存记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("stock:stock:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Stock> list = ei.getDataList(Stock.class);
			for (Stock stock : list){
				try{
					stockService.save(stock);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条仓库库存记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条仓库库存记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入仓库库存失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
    }
	
	/**
	 * 下载导入仓库库存数据模板
	 */
	@RequiresPermissions("stock:stock:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "仓库库存数据导入模板.xlsx";
    		List<Stock> list = Lists.newArrayList(); 
    		new ExportExcel("仓库库存数据", Stock.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/stock/stock/?repage";
    }
	
	
	

}