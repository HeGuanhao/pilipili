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

import com.igeek.hbut.shixi.entity.Admin;
import com.igeek.hbut.shixi.entity.User;
import com.igeek.hbut.shixi.service.IAdminService;
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
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@GetMapping("/register")
	public String register() {
		return "adminRegister";
	}
	
	@PostMapping("/registerPost")
	public String registerPost(String adminName,String password, String passwordRep, Model model) {
		adminName = adminName.trim();
		password = password.trim();
		passwordRep = passwordRep.trim();
		
		StringBuilder errorMsg = new StringBuilder();
		if(adminName=="") {
			errorMsg.append("用户名不能为空！；");
		}
		if(password == "") {
			errorMsg.append("密码不能为空！；");
		}
		if(!password.equals(passwordRep)) {
			errorMsg.append("密码与确认密码不一致！；");
		}
		if(errorMsg.length() > 0) {
			model.addAttribute("errorMsg", errorMsg.toString());
			return "adminRegisterResult";
		}
		
		Admin admin = new Admin();
		admin.setAdmid(adminName);
		admin.setPassword(password);
		try {
			Integer rsInt = adminService.saveRegister(admin);
			if(rsInt == 0) {
				errorMsg.append("用户名已被注册！");
				model.addAttribute("errorMsg", errorMsg.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adminRegisterResult";
	}
	
	@GetMapping("/login")
	public String login() {
		return "adminLogin";
	}
	
	@PostMapping("/loginPost")
	public String loginPost(HttpServletRequest request, String adminName, String password, Model model) {
		Admin admin = null;
		try {
			admin = adminService.getAdminByNamePassword(adminName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(admin != null) {	//用户名和密码正确
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
			session.setAttribute("admin",admin);
		} else {	//用户名或密码不正确
			return "adminLoginFail";
		}
		if(request.getParameter("referer")!=null && !request.getParameter("referer").equals("null")) {
			return "redirect:" + request.getParameter("referer");
		} else {
			return "redirect:/video/adminlist";
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
		
		return "redirect:/video/adminlist";
	}
}
