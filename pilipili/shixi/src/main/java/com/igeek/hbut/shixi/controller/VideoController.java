package com.igeek.hbut.shixi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.igeek.hbut.shixi.entity.Comment;
import com.igeek.hbut.shixi.entity.Video;
import com.igeek.hbut.shixi.service.ICommentService;
import com.igeek.hbut.shixi.service.IVideoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private IVideoService videoService;
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/add")
	public String videoAdd() {
		return "videoAdd";
	}
	
	@PostMapping("/addPost")
	public String videoAddPost(Video video) throws Exception {
		videoService.insertVideo(video);
		return "videoAddResult";
	}
	
	@GetMapping("/list")
	public String videoList(Model model) throws Exception {
		List<Video> videoList = videoService.queryVideoList();
		model.addAttribute("videoList", videoList);
		return "videoList";
	}
	
	@GetMapping("/show")
	public String videoShow(Long aid, Model model) throws Exception {
		
		Video video = videoService.queryVideoById(aid);
		System.out.println(video.getAid());
		model.addAttribute("video", video);
		
		List<Comment> commentList = commentService.queryCommentList(aid);
		model.addAttribute("commentList", commentList);
		
		return "videoShow";
	}
	
	
	@GetMapping("/home")
	public String home() throws Exception {
		return "home";
	}
	
	@GetMapping("/dongman")
	public String videodongman(Model model) throws Exception {
		List<Video> videoList = videoService.queryVideodongman();
		model.addAttribute("videoList", videoList);
		return "videoDongman";
	}
	
	@GetMapping("/wudao")
	public String videowudao(Model model) throws Exception {
		List<Video> videoList = videoService.queryVideowudao();
		model.addAttribute("videoList", videoList);
		return "videoWudao";
	}

}
