/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.holo.h5.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.vm.service.VendingMachineService;

/**
 * 售货机管理Controller
 * @author Jason Dong
 * @version 2017-12-20
 */
@Controller
@RequestMapping(value = "/h5/vm/vendingMachine")
public class VendingMachineH5Controller extends BaseController {

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
	@RequestMapping(value = {"list", ""})
	@ResponseBody
	public List<VendingMachine> list(VendingMachine vendingMachine) {
		System.out.println("===========list called");
		//System.out.println(vendingMachine.getId());
		System.out.println(vendingMachine.getName());
		
		List<VendingMachine> vms = vendingMachineService.findList(new VendingMachine());
		return vms;
	}

}