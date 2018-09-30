package com.online.college.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.online.college.core.course.domain.CourseSection;

public class CourseSectionDto extends CourseSection {

	//小节的列表
	private List<CourseSection> sectionList = new ArrayList<CourseSection>();

	public List<CourseSection> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<CourseSection> sectionList) {
		this.sectionList = sectionList;
	}
	
}
