package com.igeek.hbut.shixi.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.igeek.hbut.shixi.entity.User;
import com.igeek.hbut.shixi.service.IUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/register")
	public String register() {
		return "userRegister";
	}
	
	@PostMapping("/registerPost")
	public String registerPost(String userName, String Name,String password, String passwordRep, Model model) {
		userName = userName.trim();
		Name = Name.trim();
		password = password.trim();
		passwordRep = passwordRep.trim();
		
		StringBuilder errorMsg = new StringBuilder();
		if(userName=="") {
			errorMsg.append("用户名不能为空！；");
		}
		if(Name=="") {
			errorMsg.append("昵称不能为空！；");
		}
		if(password == "") {
			errorMsg.append("密码不能为空！；");
		}
		if(!password.equals(passwordRep)) {
			errorMsg.append("密码与确认密码不一致！；");
		}
		if(errorMsg.length() > 0) {
			model.addAttribute("errorMsg", errorMsg.toString());
			return "userRegisterResult";
		}
		
		User user = new User();
		user.setMid(userName);
		user.setName(Name);
		user.setPassword(password);
		try {
			Integer rsInt = userService.saveRegister(user);
			if(rsInt == 0) {
				errorMsg.append("用户名已被注册！");
				model.addAttribute("errorMsg", errorMsg.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userRegisterResult";
	}
	
	@GetMapping("/login")
	public String login() {
		return "userLogin";
	}
	
	@PostMapping("/loginPost")
	public String loginPost(HttpServletRequest request, String userName, String password, Model model) {
		User user = null;
		try {
			user = userService.getUserByNamePassword(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user != null) {	//用户名和密码正确
			//设置cookie
			/*
			Cookie cookieUsername = new Cookie("userName", user.getUserName());
			response.addCookie(cookieUsername);
			Cookie cookiePassword = new Cookie("password", user.getPassword());
			response.addCookie(cookiePassword);
			*/
			HttpSession session = request.getSession();
			//session.setAttribute("name", user.getName());
			//session.setAttribute("password", user.getPassword());
			session.setAttribute("user",user);
		} else {	//用户名或密码不正确
			return "userLoginFail";
		}
		if(request.getParameter("referer")!=null && !request.getParameter("referer").equals("null")) {
			return "redirect:" + request.getParameter("referer");
		} else {
			//return "redirect:/video/list";
			return "redirect:/video/home";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		/*
		Cookie[] cookie = request.getCookies();
		if(cookie!=null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				Cookie cook = cookie[i];
				if (cook.getName().equalsIgnoreCase("userName") || cook.getName().equalsIgnoreCase("password")) {
					cook.setMaxAge(0);
					reponse.addCookie(cook);
				}
			}
		}
		*/
		request.getSession().invalidate();
		
		//return "redirect:/video/list";
		return "redirect:/video/home";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "userDetail";
	}
	
	@GetMapping("/alterpassword")
	public String alterpassword() {
		return "userAlterpassword";
	}
}
