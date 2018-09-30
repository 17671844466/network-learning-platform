package com.online.college.rest.business;

import java.util.Map;

import com.online.college.rest.dto.ClassifyDto;

public interface IClassifyBusiness {

	Map<String,ClassifyDto> getAllClassify();
	
}
