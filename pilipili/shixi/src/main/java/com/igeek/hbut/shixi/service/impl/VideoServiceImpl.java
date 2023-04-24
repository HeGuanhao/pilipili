package com.igeek.hbut.shixi.service.impl;

import com.igeek.hbut.shixi.entity.Video;
import com.igeek.hbut.shixi.mapper.VideoMapper;
import com.igeek.hbut.shixi.service.IVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {
	@Autowired
	private VideoMapper videoMapper;
	
	/**
	 * 插入一条视频信息
	 * @param video
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer insertVideo(Video video) throws Exception {
		LocalDateTime now = LocalDateTime.now();
		video.setCreate_time(now);
		video.setUpdate_time(now);
		return videoMapper.insert(video);
	}
	
	/**
	 * 获取视频信息列表
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Video> queryVideoList() throws Exception {
		//QueryWrapper<Video> videoWrapper = new QueryWrapper<Video>();
		//return videoMapper.selectList(videoWrapper);
		List<Video> videoList = videoMapper.queryVideoList();
		return videoList;
	}
	
	/**
	 * 根据主键获得一条视频信息
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	@Override
	public Video queryVideoById(Long aid) throws Exception {
		Video video=videoMapper.queryVideoById(aid);
		return video;
		//return videoMapper.selectById(aid);
	}
	
	/**
	 * 获取动漫视频信息列表
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Video> queryVideodongman() throws Exception{
		List<Video> videoList = videoMapper.queryVideodongman();
		return videoList;
	}
	
	/**
	 * 获取舞蹈视频信息列表
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Video> queryVideowudao() throws Exception{
		List<Video> videoList = videoMapper.queryVideowudao();
		return videoList;
	}
}
