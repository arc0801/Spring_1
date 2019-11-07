package com.arc.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	//DAO 객체 없으면 Service 운용 못 해
	
	@Inject
	private NoticeDAO noticeDAO;
		
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
