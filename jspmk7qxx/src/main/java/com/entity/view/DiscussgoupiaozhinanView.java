package com.entity.view;

import com.entity.DiscussgoupiaozhinanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购票指南评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
@TableName("discussgoupiaozhinan")
public class DiscussgoupiaozhinanView  extends DiscussgoupiaozhinanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgoupiaozhinanView(){
	}
 
 	public DiscussgoupiaozhinanView(DiscussgoupiaozhinanEntity discussgoupiaozhinanEntity){
 	try {
			BeanUtils.copyProperties(this, discussgoupiaozhinanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
