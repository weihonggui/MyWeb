package com.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojo.PersonalInfo;
import com.app.service.IPersonalInfoService;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoController {
	
	@Resource
	private IPersonalInfoService personalInfoService;
	
	@RequestMapping("/insertOrUpdate")
	public String insertAtFirst(HttpServletRequest request,Model model){
		PersonalInfo personalInfo = new PersonalInfo();
		if(request.getSession().getAttribute("username") != null)
			personalInfo.setUsername((String)request.getSession().getAttribute("username"));
		if(request.getParameter("realname") != null)
			personalInfo.setRealname((String)request.getParameter("realname"));
		if(request.getParameter("email") != null)
			personalInfo.setEmail((String)request.getParameter("email"));
		if(request.getParameter("telephone") != null)
			personalInfo.setTelephone((String)request.getParameter("telephone"));
		if(request.getParameter("qq") != null)
			personalInfo.setQq((String)request.getParameter("qq"));
		if(request.getParameter("twitter") != null)
			personalInfo.setTwitter((String)request.getParameter("twitter"));
		if(request.getParameter("intro") != null)
			personalInfo.setIntro((String)request.getParameter("intro"));
		int result = 0;
		try{
			if(personalInfoService.checkUsername(personalInfo.getUsername()) == 0)
				result =  personalInfoService.insertAtFirst(personalInfo);
			else 
				result = personalInfoService.updatePersonalInfo(personalInfo);
		} catch(Exception e){
			System.out.println(e);
		}
		if(result > 0){
			model.addAttribute("message","保存成功");
		}else {
			model.addAttribute("message","发生错误，请重新提交");
		}
		model.addAttribute(personalInfo);
			
		return "personalCenter";
	}
	

}
