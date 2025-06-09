package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GoupiaozhinanDao;
import com.entity.GoupiaozhinanEntity;
import com.service.GoupiaozhinanService;
import com.entity.vo.GoupiaozhinanVO;
import com.entity.view.GoupiaozhinanView;

@Service("goupiaozhinanService")
public class GoupiaozhinanServiceImpl extends ServiceImpl<GoupiaozhinanDao, GoupiaozhinanEntity> implements GoupiaozhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoupiaozhinanEntity> page = this.selectPage(
                new Query<GoupiaozhinanEntity>(params).getPage(),
                new EntityWrapper<GoupiaozhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoupiaozhinanEntity> wrapper) {
		  Page<GoupiaozhinanView> page =new Query<GoupiaozhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GoupiaozhinanVO> selectListVO(Wrapper<GoupiaozhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoupiaozhinanVO selectVO(Wrapper<GoupiaozhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoupiaozhinanView> selectListView(Wrapper<GoupiaozhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoupiaozhinanView selectView(Wrapper<GoupiaozhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
