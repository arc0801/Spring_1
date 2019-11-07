package com.arc.s1.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	//DAO 객체 없으면 Service 운용 못 해
	
	//@Resource(name = "n")
	@Inject
	@Qualifier("n1")
	private NoticeDAO noticeDAO;
	
	//@Inject
	public NoticeService(NoticeDAO noticeDAO) {
		//리턴 타입 아예 없는 게 생성자 Constructor
		this.noticeDAO = noticeDAO;
		//this는 생략
	}
	
	//@Inject
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		int result = noticeDAO.noticeUpdate(noticeDTO);
		return result;
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = noticeDAO.noticeWrite(noticeDTO);
		return result;
	}
	
	public NoticeDTO noticeSelect(int num) throws Exception {
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(num);
		return noticeDTO;
	}
	
	public List<NoticeDTO> noticeList() throws Exception {
		List<NoticeDTO> ar = noticeDAO.noticeList();
		
		return ar;
	}
}
