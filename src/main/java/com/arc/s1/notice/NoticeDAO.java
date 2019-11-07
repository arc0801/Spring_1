package com.arc.s1.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.arc.util.DBConnector;

@Scope("prototype")
@Repository
@Qualifier("n1") //noticeDAO 객체가 여러 개일 때 이름을 주자
public class NoticeDAO {
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		int result = 0;
		
		Connection con = DBConnector.getConnect();
		String sql = "update notice set title=?, writer=?, contents=? where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		st.setInt(4, noticeDTO.getNum());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = 0;
		
		Connection con = DBConnector.getConnect();
		String sql = "insert into notice values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public NoticeDTO noticeSelect(int num) throws Exception {
		NoticeDTO noticeDTO = null;
		
		Connection con = DBConnector.getConnect();
		String sql = "select * from notice where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setContents(rs.getString("contents"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
	}
	
	public List<NoticeDTO> noticeList() throws Exception {
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		
		Connection con = DBConnector.getConnect();
		String sql = "select * from notice order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
