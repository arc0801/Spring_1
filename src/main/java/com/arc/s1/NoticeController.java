package com.arc.s1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s1.notice.NoticeDTO;

@Controller
@RequestMapping("/notice/**")
// *한 개면 바로 하위까지만, **두 개면 sub 파일도 포함
public class NoticeController {

	//noticeWrite POST
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, HttpServletRequest request, HttpSession session) {
		//오버로딩 메서드명 동일, 매개변수 달라야 함
		
		
		
		//request.getSession();
		//request.getSession().getServletContext(); //application
		
		//System.out.println(noticeDTO.getNum());
		//값을 받아오지 않으면 디폴트값이 들어간다  ex)int-0, reference-null
		//System.out.println(noticeDTO.getTitle());
		//System.out.println(noticeDTO.getWriter());
		//System.out.println(noticeDTO.getContents());
		//System.out.println(noticeDTO.getReg_date());
		return "redirect:./noticeList";
	}
	
	//noticeWrite GET
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET) //절대주소로 써야해!! '/'는 루트주소야.
	public void noticeWrite() {
		
	}
	
	//selectOne
	@RequestMapping(value = "noticeSelect", method = {RequestMethod.GET, RequestMethod.POST}) //얘가 들어오면 해당 method 실행
	public void noticeSelect(Model model, @RequestParam(value = "n", required = false, defaultValue = "1") int num) {//이름이 다를 때
		//int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		String data = "Notice Data";
		model.addAttribute("data", data);
		//model은 request랑 비슷함.
		//return "notice/noticeSelect";
		//'web-inf/views'와 '.jsp'는 자동으로 만들어 주니까 그 사이의 jsp 파일명만 써주면 됨
	}
	
	//list
	@RequestMapping("noticeList")
	public ModelAndView noticeList() {
		// URL notice/noticeLsit
		// return notice/noticeList
		// 두 개가 같으면 spring이 알아서 생성해 줌
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", "Notice List");
		mv.setViewName("notice/noticeList");
		return mv;
		//여기서 우리가 만든 거니까 리턴해줘야함!
	}
	
}
