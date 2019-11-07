package com.arc.s1;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arc.notice.NoticeDAO;

public class TestCase extends TestAbstractCase {
//WAS랑 상관없이 테스트 진행함
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		assertNotNull(noticeDAO);
	}

}
