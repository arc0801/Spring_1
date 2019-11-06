package com.arc.s1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(String id, String pw) {
		ModelAndView mv = new ModelAndView();
		int result = 1;
		if(result>0) {
			mv.addObject("msg", "Join Success");
		}else {
			mv.addObject("msg", "Join Fail");
		}
		mv.addObject("path", "../");
		mv.setViewName("/common/common_result");
		
		return mv;
	}
	
	@RequestMapping("memberJoin")
	public void memberJoin() {
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(String id, String pw) {
		ModelAndView mv = new ModelAndView();
		//modeleandview는 model(viewname)이랑 String(addobject) 합친 것
		int result = 1;
		if(result>0) {
			mv.setViewName("redirect:/"); //model-redirect 방식
		}else {
			mv.addObject("msg", "Login Fail"); //view
			mv.addObject("path", "memberLogin"); //view
			mv.setViewName("/common/common_result"); //model-forward 방식
		}
		return mv;
	}
	
	@RequestMapping("memberLogin")
	public void memberLogin() {
		
	}
}
