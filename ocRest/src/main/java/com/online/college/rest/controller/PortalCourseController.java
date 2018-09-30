package com.online.college.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.college.common.web.JsonView;
import com.online.college.rest.business.ICourseBusiness;

@Controller
@RequestMapping("/course/")
public class PortalCourseController {
	
	@Autowired
	private ICourseBusiness courseBusiness;

	@RequestMapping("getCourses")
	@ResponseBody
	public String getCourses(HttpServletRequest request){
		try{
			String resultStr = JsonView.render(courseBusiness.getCourses());
			return request.getParameter("callback") + "(" + resultStr + ")";
		}catch(Exception e){
			return JsonView.render(17000);
		}
	}
	
}
