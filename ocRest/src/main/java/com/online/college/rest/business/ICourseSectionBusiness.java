package com.online.college.rest.business;

import java.util.Map;

import com.online.college.rest.dto.CourseSectionDto;

public interface ICourseSectionBusiness {

	/**
	 * 获取某个课程的章节数据
	 * @param courseId
	 * @return
	 */
	Map<Long,CourseSectionDto> getAllCourseSections(Long courseId);
	
}
