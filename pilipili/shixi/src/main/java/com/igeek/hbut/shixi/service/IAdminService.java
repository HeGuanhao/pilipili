package com.igeek.hbut.shixi.service;

import com.igeek.hbut.shixi.entity.Admin;
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
public interface IAdminService extends IService<Admin> {
	/**
	 * 注册管理员
	 */
	public Integer saveRegister(Admin admin) throws Exception;
	
	/**
	 * 通过cookie或session判断是否登录
	 */
	public Admin getAdminByCookie(HttpServletRequest request) throws Exception;

	/**
	 * 表单登录
	 */
	public Admin getAdminByNamePassword(String adminName, String password) throws Exception;

}
