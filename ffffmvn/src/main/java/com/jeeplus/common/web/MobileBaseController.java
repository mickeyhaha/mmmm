/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.common.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.holo.utils.TokenProccessor;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.modules.sys.entity.User;

/**
 * Mobile控制器支持类
 * @author jason.dong
 */
public abstract class MobileBaseController extends BaseController {
	@Autowired
	private HttpServletRequest request;
	 
	/** 
	 * @Description AJAX错误回调
	 */
	public String errorData(String msg){
		AjaxJson json = new AjaxJson();
		json.setSuccess(false);
		json.setMsg(msg);
		return new Gson().toJson(json);
	}
	
	 
	/** 
	 * @Description AJAX成功回调
	 */
	public String successData(Object data){
		AjaxJson json = new AjaxJson();
		json.setSuccess(true);
		json.put("data", data);
		return new Gson().toJson(json);
	}
	
	 
	/** 
	 * @Description 验证表单是否重复提交
	 */
	public boolean isRepeatSubmit(HttpServletRequest request) {  
        String client_token = request.getParameter(TokenProccessor.SESSION_TOKEN);  
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单  
        if(client_token==null){  
            return true;  
        }  
        //取出存储在Session中的token  
		Object attribute = request.getSession().getAttribute(TokenProccessor.SESSION_TOKEN);
		String server_token =null;
        if(attribute instanceof String){
			server_token = (String) attribute;
		}
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){  
            return true;  
        }  
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单  
        if(!client_token.equals(server_token)){  
            return true;  
        }  
        return false;  
    }  
	
	 
	/** 
	 * @Description 获取登录用户
	 */
	public User getLoginUser(){
		User user=(User) request.getSession().getAttribute("user");
		return user;
	}	
}
