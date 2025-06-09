package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgoupiaozhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgoupiaozhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgoupiaozhinanView;


/**
 * 购票指南评论表
 *
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface DiscussgoupiaozhinanService extends IService<DiscussgoupiaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgoupiaozhinanVO> selectListVO(Wrapper<DiscussgoupiaozhinanEntity> wrapper);
   	
   	DiscussgoupiaozhinanVO selectVO(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
   	
   	List<DiscussgoupiaozhinanView> selectListView(Wrapper<DiscussgoupiaozhinanEntity> wrapper);
   	
   	DiscussgoupiaozhinanView selectView(@Param("ew") Wrapper<DiscussgoupiaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgoupiaozhinanEntity> wrapper);
   	
}

