package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GoupiaozhinanEntity;
import com.entity.view.GoupiaozhinanView;

import com.service.GoupiaozhinanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 购票指南
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
@RestController
@RequestMapping("/goupiaozhinan")
public class GoupiaozhinanController {
    @Autowired
    private GoupiaozhinanService goupiaozhinanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoupiaozhinanEntity goupiaozhinan, HttpServletRequest request){

        EntityWrapper<GoupiaozhinanEntity> ew = new EntityWrapper<GoupiaozhinanEntity>();
    	PageUtils page = goupiaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goupiaozhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoupiaozhinanEntity goupiaozhinan, HttpServletRequest request){
        EntityWrapper<GoupiaozhinanEntity> ew = new EntityWrapper<GoupiaozhinanEntity>();
    	PageUtils page = goupiaozhinanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goupiaozhinan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoupiaozhinanEntity goupiaozhinan){
       	EntityWrapper<GoupiaozhinanEntity> ew = new EntityWrapper<GoupiaozhinanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goupiaozhinan, "goupiaozhinan")); 
        return R.ok().put("data", goupiaozhinanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoupiaozhinanEntity goupiaozhinan){
        EntityWrapper< GoupiaozhinanEntity> ew = new EntityWrapper< GoupiaozhinanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goupiaozhinan, "goupiaozhinan")); 
		GoupiaozhinanView goupiaozhinanView =  goupiaozhinanService.selectView(ew);
		return R.ok("查询购票指南成功").put("data", goupiaozhinanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GoupiaozhinanEntity goupiaozhinan = goupiaozhinanService.selectById(id);
        return R.ok().put("data", goupiaozhinan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GoupiaozhinanEntity goupiaozhinan = goupiaozhinanService.selectById(id);
        return R.ok().put("data", goupiaozhinan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        GoupiaozhinanEntity goupiaozhinan = goupiaozhinanService.selectById(id);
        if(type.equals("1")) {
        	goupiaozhinan.setThumbsupnum(goupiaozhinan.getThumbsupnum()+1);
        } else {
        	goupiaozhinan.setCrazilynum(goupiaozhinan.getCrazilynum()+1);
        }
        goupiaozhinanService.updateById(goupiaozhinan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoupiaozhinanEntity goupiaozhinan, HttpServletRequest request){
    	goupiaozhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goupiaozhinan);

        goupiaozhinanService.insert(goupiaozhinan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody GoupiaozhinanEntity goupiaozhinan, HttpServletRequest request){
    	goupiaozhinan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goupiaozhinan);

        goupiaozhinanService.insert(goupiaozhinan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoupiaozhinanEntity goupiaozhinan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goupiaozhinan);
        goupiaozhinanService.updateById(goupiaozhinan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goupiaozhinanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GoupiaozhinanEntity> wrapper = new EntityWrapper<GoupiaozhinanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = goupiaozhinanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
