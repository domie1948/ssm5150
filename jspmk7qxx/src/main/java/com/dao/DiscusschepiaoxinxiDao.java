package com.dao;

import com.entity.DiscusschepiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschepiaoxinxiVO;
import com.entity.view.DiscusschepiaoxinxiView;


/**
 * 车票信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface DiscusschepiaoxinxiDao extends BaseMapper<DiscusschepiaoxinxiEntity> {
	
	List<DiscusschepiaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
	
	DiscusschepiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
	
	List<DiscusschepiaoxinxiView> selectListView(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);

	List<DiscusschepiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
	
	DiscusschepiaoxinxiView selectView(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
	
}
