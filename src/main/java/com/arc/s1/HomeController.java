package com.arc.s1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/notice/noticeWrite") //절대주소 생각해봐 '/'는 루트주소야.
	public String noticeWrite() {
		
		return "notice/noticeWrite";
	}
	
	@RequestMapping("/notice/noticeSelect") //얘가 들어오면 해당 method 실행
	public String noticeSelect() {
		
		return "notice/noticeSelect";
		//'web-inf/views'와 '.jsp'는 자동으로 만들어 주니까 그 사이의 jsp 파일명만 써주면 됨
	}
	
	@RequestMapping("/notice/noticeList")
	public String noticeList() {
		
		return "notice/noticeList";
	}
	
	@RequestMapping("/test")
	public String test() {
		
		return "test";
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
