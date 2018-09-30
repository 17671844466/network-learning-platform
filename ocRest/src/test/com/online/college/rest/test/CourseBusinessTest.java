package com.online.college.rest.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.online.college.common.util.JsonUtil;
import com.online.college.common.web.SpringBeanFactory;
import com.online.college.core.course.domain.Course;
import com.online.college.rest.business.IClassifyBusiness;
import com.online.college.rest.business.ICourseBusiness;
import com.online.college.rest.dto.ClassifyDto;

public class CourseBusinessTest extends TestCase{

	public void testGetCourses(){
		ICourseBusiness bis = (ICourseBusiness)SpringBeanFactory.getBean("courseBusinessImpl");
		
		Map<String,List<Course>> map = bis.getCourses();
		try {
			System.out.println(JsonUtil.toJson(map).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
