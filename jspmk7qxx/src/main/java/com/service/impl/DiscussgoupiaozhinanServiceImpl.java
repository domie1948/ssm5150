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


import com.dao.DiscussgoupiaozhinanDao;
import com.entity.DiscussgoupiaozhinanEntity;
import com.service.DiscussgoupiaozhinanService;
import com.entity.vo.DiscussgoupiaozhinanVO;
import com.entity.view.DiscussgoupiaozhinanView;

@Service("discussgoupiaozhinanService")
public class DiscussgoupiaozhinanServiceImpl extends ServiceImpl<DiscussgoupiaozhinanDao, DiscussgoupiaozhinanEntity> implements DiscussgoupiaozhinanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgoupiaozhinanEntity> page = this.selectPage(
                new Query<DiscussgoupiaozhinanEntity>(params).getPage(),
                new EntityWrapper<DiscussgoupiaozhinanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgoupiaozhinanEntity> wrapper) {
		  Page<DiscussgoupiaozhinanView> page =new Query<DiscussgoupiaozhinanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgoupiaozhinanVO> selectListVO(Wrapper<DiscussgoupiaozhinanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgoupiaozhinanVO selectVO(Wrapper<DiscussgoupiaozhinanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgoupiaozhinanView> selectListView(Wrapper<DiscussgoupiaozhinanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgoupiaozhinanView selectView(Wrapper<DiscussgoupiaozhinanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
