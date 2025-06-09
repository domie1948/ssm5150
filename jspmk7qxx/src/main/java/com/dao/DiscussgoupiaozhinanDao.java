package com.dao;

import com.entity.DiscussgoupiaozhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgoupiaozhinanVO;
import com.entity.view.DiscussgoupiaozhinanView;


/**
 * 购票指南评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface DiscussgoupiaozhinanDao extends BaseMapper<DiscussgoupiaozhinanEntity> {
	
	List<DiscussgoupiaozhinanVO> selectListVO(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
	
	DiscussgoupiaozhinanVO selectVO(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
	
	List<DiscussgoupiaozhinanView> selectListView(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);

	List<DiscussgoupiaozhinanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
	
	DiscussgoupiaozhinanView selectView(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
	
}
