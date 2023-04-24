package com.igeek.hbut.shixi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.igeek.hbut.shixi.entity.User;
import com.igeek.hbut.shixi.service.IUserService;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	private IUserService userService;
	
	/**
	 * Controller执行前调用此方法
	 * 返回true表示继续执行，返回false中止执行
	 * 这里可以加入登录校验、权限拦截等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (userService == null) {//解决service为null无法注入问题
            System.out.println("userService is null!!!");
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (IUserService) factory.getBean("userServiceImpl");
        }
		
		//判断是否登录
		try {
			User user = userService.getUserByCookie(request);
			if(user != null) {
				request.setAttribute("user", user);
			}
			System.out.println("登录过滤" + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * controller执行后但未返回视图前调用此方法
  	 * 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * controller执行后且视图返回后调用此方法
  	 * 这里可得到执行controller时的异常信息
  	 * 这里可记录操作日志
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
