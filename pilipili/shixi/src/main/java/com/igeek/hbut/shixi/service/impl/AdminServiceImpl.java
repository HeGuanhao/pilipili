package com.igeek.hbut.shixi.service.impl;

import com.igeek.hbut.shixi.entity.Admin;
import com.igeek.hbut.shixi.entity.User;
import com.igeek.hbut.shixi.mapper.AdminMapper;
import com.igeek.hbut.shixi.mapper.UserMapper;
import com.igeek.hbut.shixi.service.IAdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 注册管理员
	 */
	@Override
	public Integer saveRegister(Admin admin) throws Exception {
			Integer rsInt = 0;
		
		// 根据用户名查询是否重复
		QueryWrapper<Admin> adminWrapper = new QueryWrapper<Admin>();
		adminWrapper.eq("admid", admin.getAdmid());
		Admin seladmin = adminMapper.selectOne(adminWrapper);
		
		if (seladmin == null) {
			LocalDateTime now = LocalDateTime.now();
			admin.setCreate_time(now);
			admin.setUpdate_time(now);
			rsInt = adminMapper.insert(admin);
		}
		return rsInt;
	}

	@Override
	public Admin getAdminByCookie(HttpServletRequest request) throws Exception {
		Admin admin = null;
		String adminName = null;
		String password = null;
		
		//从cookie获取用户名和密码
		HttpSession session = request.getSession();
		adminName = (String)session.getAttribute("adminName");
		password = (String)session.getAttribute("password");
		
		if(adminName!=null && password!=null) {
			QueryWrapper<Admin> adminWrapper = new QueryWrapper<Admin>();
			adminWrapper.eq("admid", adminName);
			adminWrapper.eq("password", password);
			admin = adminMapper.selectOne(adminWrapper);
		}
		return admin;
	}
	
	/**
	 * 表单登录
	 */
	@Override
	public Admin getAdminByNamePassword(String adminName, String password) throws Exception {
		QueryWrapper<Admin> adminWrapper = new QueryWrapper<Admin>();
		adminWrapper.eq("admid", adminName);
		adminWrapper.eq("password", password);
		Admin admin = adminMapper.selectOne(adminWrapper);
		return admin;
	}

}
