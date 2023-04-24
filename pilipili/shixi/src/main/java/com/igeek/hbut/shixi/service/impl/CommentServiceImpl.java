package com.igeek.hbut.shixi.service.impl;

import com.igeek.hbut.shixi.entity.Comment;
import com.igeek.hbut.shixi.mapper.CommentMapper;
import com.igeek.hbut.shixi.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
	@Autowired
	private CommentMapper commentMapper;
	
	/*
	 * 插入一条评论
	 */
	@Override
	public Integer insertComment(Comment comment) throws Exception {
		LocalDateTime now = LocalDateTime.now();
		comment.setCreate_time(now);
		comment.setUpdate_time(now);
		return commentMapper.insert(comment);
	}
	
	/*
	 * 显示该视频下的所有评论
	 */
	@Override
	public List<Comment> queryCommentList(Long aid) throws Exception {
		List<Comment> commentlist = commentMapper.queryCommentList(aid);
		return commentlist;
	}

}
