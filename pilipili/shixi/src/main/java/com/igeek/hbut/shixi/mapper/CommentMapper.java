package com.igeek.hbut.shixi.mapper;

import com.igeek.hbut.shixi.entity.Comment;

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
public interface CommentMapper extends BaseMapper<Comment> {
	
	
	@Select("SELECT a.*,b.name"
			+ "    FROM COMMENT a LEFT JOIN USER b ON a.mid=b.mid"
			+ "    WHERE a.oid=#{aid} ORDER BY a.rpid DESC")
	public List<Comment> queryCommentList(Long aid);
}
