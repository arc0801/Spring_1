package com.arc.s1;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceTest extends TestAbstractCase {

	@Autowired
	private SqlSession sqlSession;
	//private DataSource dataSource;
	
	@Test
	public void test() throws Exception {
		assertNotNull(sqlSession);
		//assertNotNull(dataSource.getConnection());
	}

}
