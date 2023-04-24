package com.igeek.hbut.shixi.service;

import com.igeek.hbut.shixi.entity.Video;

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
public interface IVideoService extends IService<Video> {

	/**
	 * 插入一条视频信息
	 * @param video
	 * @return
	 * @throws Exception
	 */
	public Integer insertVideo(Video video) throws Exception;

	/**
	 * 获取视频信息列表
	 * @return
	 * @throws Exception 
	 */
	public List<Video> queryVideoList() throws Exception;

	/**
	 * 根据主键获得一条视频信息
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	public Video queryVideoById(Long aid) throws Exception;
	
	/**
	 * 获取动漫视频信息列表
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	public List<Video> queryVideodongman() throws Exception;

	/**
	 * 获取舞蹈视频信息列表
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	public List<Video> queryVideowudao() throws Exception;

}
