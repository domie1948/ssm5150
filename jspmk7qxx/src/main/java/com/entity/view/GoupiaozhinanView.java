package com.entity.view;

import com.entity.GoupiaozhinanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购票指南
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-07 10:55:04
 */
@TableName("goupiaozhinan")
public class GoupiaozhinanView  extends GoupiaozhinanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoupiaozhinanView(){
	}
 
 	public GoupiaozhinanView(GoupiaozhinanEntity goupiaozhinanEntity){
 	try {
			BeanUtils.copyProperties(this, goupiaozhinanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
