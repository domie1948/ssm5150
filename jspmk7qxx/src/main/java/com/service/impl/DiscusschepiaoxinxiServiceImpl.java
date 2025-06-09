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


import com.dao.DiscusschepiaoxinxiDao;
import com.entity.DiscusschepiaoxinxiEntity;
import com.service.DiscusschepiaoxinxiService;
import com.entity.vo.DiscusschepiaoxinxiVO;
import com.entity.view.DiscusschepiaoxinxiView;

@Service("discusschepiaoxinxiService")
public class DiscusschepiaoxinxiServiceImpl extends ServiceImpl<DiscusschepiaoxinxiDao, DiscusschepiaoxinxiEntity> implements DiscusschepiaoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschepiaoxinxiEntity> page = this.selectPage(
                new Query<DiscusschepiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusschepiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschepiaoxinxiEntity> wrapper) {
		  Page<DiscusschepiaoxinxiView> page =new Query<DiscusschepiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschepiaoxinxiVO> selectListVO(Wrapper<DiscusschepiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschepiaoxinxiVO selectVO(Wrapper<DiscusschepiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschepiaoxinxiView> selectListView(Wrapper<DiscusschepiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschepiaoxinxiView selectView(Wrapper<DiscusschepiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
