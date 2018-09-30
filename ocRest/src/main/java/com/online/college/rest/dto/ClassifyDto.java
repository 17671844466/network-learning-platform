package com.online.college.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.online.college.core.consts.domain.ConstsClassify;

public class ClassifyDto extends ConstsClassify{

	//二级分类
	private List<ConstsClassify> subClassify = new ArrayList<ConstsClassify>();

	public List<ConstsClassify> getSubClassify() {
		return subClassify;
	}

	public void setSubClassify(List<ConstsClassify> subClassify) {
		this.subClassify = subClassify;
	}
	
}
