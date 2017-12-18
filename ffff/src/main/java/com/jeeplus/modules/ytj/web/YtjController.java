/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ytj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antbox.domain.RfidMachine;
import com.jeeplus.common.web.BaseController;

/**
 * YiTiJi Controller
 * @author Jason Dong
 * @version 2017-12-12
 */
@Controller
@RequestMapping(value = "/bussiness/v1/download/newest/rfid_edition")
public class YtjController extends BaseController {

	@ModelAttribute
	public RfidMachine get() {
		System.out.println("=============Downloading new version get called");
		return new RfidMachine();
	}	

}