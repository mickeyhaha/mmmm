package com.holo.h5.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holo.utils.AesUtils;
import com.jeeplus.common.security.Digests;
import com.jeeplus.common.utils.Encodes;
import com.jeeplus.common.web.MobileBaseController;
import com.jeeplus.modules.sys.dao.UserDao;

/** 
 * @Description 艺车贷 用户手机登陆
 * @author 刘小龙
 * @date 2017年5月26日 下午3:17:19 
 * @version V1.3.1
 */ 
@Controller
@RequestMapping(value = "/ecarloan/mobile")  	
public class UserMobileLoginController extends MobileBaseController{
	
	public static final int HASH_INTERATIONS = 1024;

	@Autowired
	private UserDao userDao;

	/** 
	 * @Description 艺车贷跳转登陆页面
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			Cookie userInfo=null;
			for (Cookie cookie : cookies) {
				if("userInfo".equals(cookie.getName())){
					userInfo=cookie;
					break;
				}
			}
			if(userInfo!=null){
				String[] split = AesUtils.decrypt(userInfo.getValue(), null, null).split("-");
				Long oldTime=Long.valueOf(split[1]);
				if((new Date().getTime()-oldTime)/24/60/60/1000<=15){
					/*
					//如果日期是15天以内的则有效
					String loginName = split[0];
					List<EUserInfo> userList =eUserInfoService.userLoginVerify(loginName);
					if(userList!=null&&userList.size()>0){
						Integer data_scope = 100; //指定数据范围100
						EUserInfo user = new EUserInfo();
						//如果用户有多个角色，选择角色数据范围key值最小的，如果两个角色数据范围相同，选择前一个
						for(EUserInfo us:userList){
							if(us.getDataScope() < data_scope){
								data_scope = us.getDataScope();
								user = us;
							}
						}
						session.setAttribute("user", user);//用户信息保存到session中
						session.setMaxInactiveInterval(7*24*60*60);//设置session过期时间
						UserAuthMenu menu=userAuthMenuService.getUserRoleRedirectUrl(loginName);

						Map<String,UserAuthMenu> map= userAuthMenuService.userLoginAuthJudge(user);
						session.setAttribute("menus",map);
						return "redirect:"+menu.getMenuLink();

					}*/
				}
			}
		}
		return "mobile/login";
	}
	@RequestMapping(value = "loginOut")
	public String loginOut(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		Cookie cookie=new Cookie("userInfo",null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.removeAttribute("user");
		return "mobile/login";
	}

	
	/** 
	 * @Description 艺车贷登录校验
	 */
	@ResponseBody
	@RequestMapping(value = "verify")
	public String userLoginVerify(String loginName, String passWord, HttpServletRequest request, HttpServletResponse response){
		/*
		List<EUserInfo> userList =eUserInfoService.userLoginVerify(loginName);
		if (userList==null) {
			return errorData("用户不存在");
		}
		
		Integer data_scope = 100; //指定数据范围100
		EUserInfo user = new EUserInfo();
		//如果用户有多个角色，选择角色数据范围key值最小的，如果两个角色数据范围相同，选择前一个
		for(EUserInfo us:userList){
			if(us.getDataScope() < data_scope){
				data_scope = us.getDataScope();
				user = us;
			}
		}
		String secretKey=user.getPassWord();
		//密码校验
		if(!validatePassword(passWord,secretKey)){
			return errorData("用户密码错误");
		}
		
		UserAuthMenu menu=userAuthMenuService.getUserRoleRedirectUrl(loginName);
		if (menu ==null) {
			return errorData("系统错误,请联系管理员!!");
		}else{
			//将用户存储至session
			HttpSession session=request.getSession();
			session.setAttribute("user", user);//用户信息保存到session中
			session.setMaxInactiveInterval(7*24*60*60);//设置session过期时间

			//设置cookie 保存用户15天
			String id = AesUtils.encrypt(loginName+"-"+new Date().getTime(),null,null);
			Cookie cookie=new Cookie("userInfo",id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*15);
			response.addCookie(cookie);
//			userAuthMenuDao
			Map<String,UserAuthMenu> map= userAuthMenuService.userLoginAuthJudge(user);
			session.setAttribute("menus",map);
			return successData(menu.getMenuLink());
		}*/
		return null;
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	private static boolean validatePassword(String plainPassword, String password) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}
	
}
