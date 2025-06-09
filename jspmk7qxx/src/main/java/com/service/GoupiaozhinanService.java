package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoupiaozhinanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GoupiaozhinanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GoupiaozhinanView;


/**
 * 购票指南
 *
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface GoupiaozhinanService extends IService<GoupiaozhinanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoupiaozhinanVO> selectListVO(Wrapper<GoupiaozhinanEntity> wrapper);
   	
   	GoupiaozhinanVO selectVO(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
   	
   	List<GoupiaozhinanView> selectListView(Wrapper<GoupiaozhinanEntity> wrapper);
   	
   	GoupiaozhinanView selectView(@Param("ew") Wrapper<GoupiaozhinanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoupiaozhinanEntity> wrapper);
   	
}

