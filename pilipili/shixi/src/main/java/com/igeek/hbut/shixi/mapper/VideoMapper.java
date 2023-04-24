package com.igeek.hbut.shixi.mapper;

import com.igeek.hbut.shixi.entity.Comment;
import com.igeek.hbut.shixi.entity.Video;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hgh
 * @since 2021-07-17
 */
public interface VideoMapper extends BaseMapper<Video> {

	
	/*@Select("SELECT a.*,b.name"
			+ "    FROM COMMENT a LEFT JOIN USER b ON a.mid=b.mid"
			+ "    WHERE a.oid=#{aid} ORDER BY a.rpid DESC")*/
	//select * from table1 where 1=1 limit 10 
	@Select("SELECT * "
			+" FROM VIDEO"
			+" limit 10")
	public List<Video> queryVideoList();

	@Select("SELECT * "
			+" FROM VIDEO"
			+" where tname like '%漫%' "
			+" limit 10")
	public List<Video> queryVideodongman();


	@Select("SELECT * "
			+" FROM VIDEO"
			+" Where aid=#{aid}")
	public Video queryVideoById(Long aid);

	@Select("SELECT * "
			+" FROM VIDEO"
			+" where tname like '%舞%' "
			+" limit 10")
	public List<Video> queryVideowudao();
}
