package com.online.college.rest.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.college.core.course.domain.CourseSection;
import com.online.college.core.course.service.ICourseSectionService;
import com.online.college.rest.business.ICourseSectionBusiness;
import com.online.college.rest.dto.CourseSectionDto;

@Component
public class CourseSectionBusinessImpl implements ICourseSectionBusiness {

	@Autowired
	private ICourseSectionService courseSectionService;
	
	@Override
	public Map<Long, CourseSectionDto> getAllCourseSections(Long courseId) {
		CourseSection queryEntity = new CourseSection();
		queryEntity.setCourseId(courseId);
		List<CourseSection> list = courseSectionService.queryAll(queryEntity);
		
		Map<Long,CourseSectionDto> returnMap = new HashMap<Long,CourseSectionDto>();
		for(CourseSection item : list){
			if(Long.valueOf(0).equals(item.getParentId())){
				CourseSectionDto dto = new CourseSectionDto();
				BeanUtils.copyProperties(item, dto);
				returnMap.put(dto.getId(), dto);//章的信息放到map中
			}else{
				//小节
				returnMap.get(item.getParentId()).getSectionList().add(item);
			}
		}
		
		return returnMap;
	}

}
