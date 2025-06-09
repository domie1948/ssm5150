package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschepiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschepiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschepiaoxinxiView;


/**
 * 车票信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
public interface DiscusschepiaoxinxiService extends IService<DiscusschepiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschepiaoxinxiVO> selectListVO(Wrapper<DiscusschepiaoxinxiEntity> wrapper);
   	
   	DiscusschepiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
   	
   	List<DiscusschepiaoxinxiView> selectListView(Wrapper<DiscusschepiaoxinxiEntity> wrapper);
   	
   	DiscusschepiaoxinxiView selectView(@Param("ew") Wrapper<DiscusschepiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschepiaoxinxiEntity> wrapper);
   	
}

