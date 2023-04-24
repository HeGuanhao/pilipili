package com.igeek.hbut.shixi.service.impl;

import com.igeek.hbut.shixi.entity.User;
import com.igeek.hbut.shixi.mapper.UserMapper;
import com.igeek.hbut.shixi.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 注册用户
	 */
	@Override
	public Integer saveRegister(User user) throws Exception {
		Integer rsInt = 0;
		
		// 根据用户名查询是否重复
		QueryWrapper<User> userWrapper = new QueryWrapper<User>();
		userWrapper.eq("mid", user.getMid());
		User seluser = userMapper.selectOne(userWrapper);
		
		if (seluser == null) {
			LocalDateTime now = LocalDateTime.now();
			user.setCreate_time(now);
			user.setUpdate_time(now);
			user.setFace("https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg");
			user.setAttention("0");
			user.setFans("0");
			user.setUpdate_time(now);
			rsInt = userMapper.insert(user);
		}
		return rsInt;
	}
	
	
	/**
	 * 表单登录
	 */
	@Override
	public User getUserByNamePassword(String userName, String password) throws Exception {
		QueryWrapper<User> userWrapper = new QueryWrapper<User>();
		userWrapper.eq("mid", userName);
		userWrapper.eq("password", password);
		User user = userMapper.selectOne(userWrapper);
		return user;
	}
	
	/**
	 * 通过cookie或session判断是否登录
	 */
	@Override
	public User getUserByCookie(HttpServletRequest request) throws Exception {
		User user = null;
		String userName = null;
		String password = null;
		
		//从cookie获取用户名和密码
		/*
		Cookie[] cookie = request.getCookies();
		if(cookie!=null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				Cookie cook = cookie[i];
				if (cook.getName().equalsIgnoreCase("userName")) { // 获取键
					userName = cook.getValue().toString();
				} else if(cook.getName().equalsIgnoreCase("password")) {
					password = cook.getValue().toString();
				}
			}
		}
		*/
		
		HttpSession session = request.getSession();
		userName = (String)session.getAttribute("userName");
		password = (String)session.getAttribute("password");
		
		if(userName!=null && password!=null) {
			QueryWrapper<User> userWrapper = new QueryWrapper<User>();
			userWrapper.eq("mid", userName);
			userWrapper.eq("password", password);
			user = userMapper.selectOne(userWrapper);
		}
		return user;
	}
}
