package com.online.college.rest.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.core.consts.CourseEnum;
import com.online.college.core.course.domain.Course;
import com.online.college.core.course.service.ICourseService;
import com.online.college.rest.business.ICourseBusiness;

@Component
public class CourseBusinessImpl implements ICourseBusiness {

	@Autowired
	private ICourseService courseService;
	
	@Override
	public Map<String, List<Course>> getCourses() {
		Map<String,List<Course>> returnMap = new HashMap<String,List<Course>>();
		
		Course queryEntity = new Course();
		queryEntity.setFree(CourseEnum.FREE.value());
		//免费课程
		List<Course> freeCourses = courseService.getFiveCourses(queryEntity);
		for(Course item : freeCourses){
			if(StringUtils.isNotEmpty(item.getPicture())){
				item.setPicture(QiniuStorage.getUrl(item.getPicture()));
			}
		}
		returnMap.put("freeCourses", freeCourses);
		
		//实战课程
		queryEntity.setFree(CourseEnum.FREE_NOT.value());
		returnMap.put("actionCourses", courseService.getFiveCourses(queryEntity));
		
		return returnMap;
	}

}
