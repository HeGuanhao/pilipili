package com.igeek.hbut.shixi.service;

import com.igeek.hbut.shixi.entity.User;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
public interface IUserService extends IService<User> {

	/**
	 * 注册用户
	 */
	public Integer saveRegister(User user) throws Exception;

	/**
	 * 表单登录
	 */
	public User getUserByNamePassword(String userName, String password) throws Exception;

	/**
	 * 通过cookie或session判断是否登录
	 */
	public User getUserByCookie(HttpServletRequest request) throws Exception;

}
