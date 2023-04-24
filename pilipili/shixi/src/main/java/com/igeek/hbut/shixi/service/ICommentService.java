package com.igeek.hbut.shixi.service;

import com.igeek.hbut.shixi.entity.Comment;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
public interface ICommentService extends IService<Comment> {

	
	/*
	 * 插入一条评论
	 */
	public Integer insertComment(Comment comment) throws Exception;

	/*
	 * 显示该视频下的所有评论
	 */
	public List<Comment> queryCommentList(Long aid) throws Exception;

}
