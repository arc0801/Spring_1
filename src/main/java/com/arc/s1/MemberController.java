package com.arc.s1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public void memberJoin() {
		
	}
	
	@RequestMapping("memberJoin")
	public void memberJoin2() {
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public void memberLogin2() {
		
	}
	
	@RequestMapping("memberLogin")
	public void memberLogin() {
		
	}
}
