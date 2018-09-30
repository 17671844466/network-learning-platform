package com.online.college.rest.business;

import java.util.List;
import java.util.Map;

import com.online.college.core.course.domain.Course;

public interface ICourseBusiness {
	
	Map<String,List<Course>> getCourses();
	
}
