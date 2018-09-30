package com.online.college.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.college.common.web.JsonView;
import com.online.college.rest.business.IClassifyBusiness;
import com.online.college.rest.dto.ClassifyDto;

@Controller
public class PortalClassifyController {

	@Autowired
	private IClassifyBusiness classifyBusiness;
	
	@RequestMapping("/getClassifyJson")
	@ResponseBody
	public String getClassifyJson(HttpServletRequest request){
		try{
			Map<String,ClassifyDto> map = classifyBusiness.getAllClassify();
			List<ClassifyDto> list = new ArrayList<ClassifyDto>();
			for(String key : map.keySet()){
				list.add(map.get(key));
			}
			String resultStr =  JsonView.render(list);
			//跨域访问，客户端js 必须是 jsonp
			return request.getParameter("callback") + "(" + resultStr + ")";
			
			//不是跨域的，正常ajax请求的
//			return resultStr;
		}catch(Exception e){
			return JsonView.render(17000);//代表什么错误
		}
	}
}
