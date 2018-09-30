package com.online.college.rest.business.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.college.core.consts.domain.ConstsClassify;
import com.online.college.core.consts.service.IConstsClassifyService;
import com.online.college.rest.business.IClassifyBusiness;
import com.online.college.rest.dto.ClassifyDto;

//课程分类业务块
@Component
public class ClassifyBusinessImpl implements IClassifyBusiness {

	@Autowired
	private IConstsClassifyService constsClassifyService;
	
	public Map<String,ClassifyDto> getAllClassify(){
		Map<String,ClassifyDto> returnMap = new HashMap<String,ClassifyDto>();
		List<ConstsClassify> list = constsClassifyService.queryAll();
		Iterator<ConstsClassify> it = list.iterator();
		while(it.hasNext()){
			ConstsClassify item = it.next();
			if("0".equals(item.getParentCode())){//一级分类
				ClassifyDto dto = new ClassifyDto();
				BeanUtils.copyProperties(item, dto);
				returnMap.put(item.getCode(), dto);
			}else{
				if(null != returnMap.get(item.getParentCode())){
					returnMap.get(item.getParentCode()).getSubClassify().add(item);
				}
			}
		}
		return returnMap;
	}
	
}
