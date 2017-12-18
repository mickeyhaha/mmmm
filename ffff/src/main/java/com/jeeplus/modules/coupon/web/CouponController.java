/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.coupon.web;

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
import com.jeeplus.modules.coupon.entity.Coupon;
import com.jeeplus.modules.coupon.service.CouponService;

/**
 * 优惠券Controller
 * @author Jason Dong
 * @version 2017-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/coupon/coupon")
public class CouponController extends BaseController {

	@Autowired
	private CouponService couponService;
	
	@ModelAttribute
	public Coupon get(@RequestParam(required=false) String id) {
		Coupon entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = couponService.get(id);
		}
		if (entity == null){
			entity = new Coupon();
		}
		return entity;
	}
	
	/**
	 * 优惠券列表页面
	 */
	@RequiresPermissions("coupon:coupon:list")
	@RequestMapping(value = {"list", ""})
	public String list(Coupon coupon, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Coupon> page = couponService.findPage(new Page<Coupon>(request, response), coupon); 
		model.addAttribute("page", page);
		return "modules/coupon/couponList";
	}

	/**
	 * 查看，增加，编辑优惠券表单页面
	 */
	@RequiresPermissions(value={"coupon:coupon:view","coupon:coupon:add","coupon:coupon:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Coupon coupon, Model model) {
		model.addAttribute("coupon", coupon);
		return "modules/coupon/couponForm";
	}

	/**
	 * 保存优惠券
	 */
	@RequiresPermissions(value={"coupon:coupon:add","coupon:coupon:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Coupon coupon, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, coupon)){
			return form(coupon, model);
		}
		if(!coupon.getIsNewRecord()){//编辑表单保存
			Coupon t = couponService.get(coupon.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(coupon, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			couponService.save(t);//保存
		}else{//新增表单保存
			couponService.save(coupon);//保存
		}
		addMessage(redirectAttributes, "保存优惠券成功");
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
	}
	
	/**
	 * 删除优惠券
	 */
	@RequiresPermissions("coupon:coupon:del")
	@RequestMapping(value = "delete")
	public String delete(Coupon coupon, RedirectAttributes redirectAttributes) {
		couponService.delete(coupon);
		addMessage(redirectAttributes, "删除优惠券成功");
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
	}
	
	/**
	 * 批量删除优惠券
	 */
	@RequiresPermissions("coupon:coupon:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			couponService.delete(couponService.get(id));
		}
		addMessage(redirectAttributes, "删除优惠券成功");
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("coupon:coupon:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Coupon coupon, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "优惠券"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Coupon> page = couponService.findPage(new Page<Coupon>(request, response, -1), coupon);
    		new ExportExcel("优惠券", Coupon.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出优惠券记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("coupon:coupon:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Coupon> list = ei.getDataList(Coupon.class);
			for (Coupon coupon : list){
				try{
					couponService.save(coupon);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条优惠券记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条优惠券记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入优惠券失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
    }
	
	/**
	 * 下载导入优惠券数据模板
	 */
	@RequiresPermissions("coupon:coupon:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "优惠券数据导入模板.xlsx";
    		List<Coupon> list = Lists.newArrayList(); 
    		new ExportExcel("优惠券数据", Coupon.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/coupon/coupon/?repage";
    }
	
	
	

}