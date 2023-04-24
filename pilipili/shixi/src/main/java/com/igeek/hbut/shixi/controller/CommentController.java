package com.igeek.hbut.shixi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.igeek.hbut.shixi.entity.Comment;
import com.igeek.hbut.shixi.service.ICommentService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/add")
	public String commentAdd(String content, String aid, String userId) throws Exception {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setOid(aid);
		comment.setMid(userId);
		commentService.insertComment(comment);
		return "redirect:/video/show?aid=" + aid;
	}

}
