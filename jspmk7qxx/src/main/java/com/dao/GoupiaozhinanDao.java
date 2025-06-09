package com.dao;

import com.entity.GoupiaozhinanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GoupiaozhinanVO;
import com.entity.view.GoupiaozhinanView;


/**
 * 购票指南
 * 
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface GoupiaozhinanDao extends BaseMapper<GoupiaozhinanEntity> {
	
	List<GoupiaozhinanVO> selectListVO(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
	
	GoupiaozhinanVO selectVO(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
	
	List<GoupiaozhinanView> selectListView(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);

	List<GoupiaozhinanView> selectListView(Pagination page,@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
	
	GoupiaozhinanView selectView(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
	
}
