/**
 * tzdeskϵͳƽ̨
 * mybatis
 * com.test.mybatis
 * TestMyatisSessionFactory.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��18��-����10:02:51 
 * 2015̶�ݽ�����˾-��Ȩ����
 */
package com.tz.test01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tz.bean.User;

/**
 * mybatis 与 数据库的链接。
 *
 * 
 */
public class TestMyatisSessionFactory {
    // 这个 session 工厂必须是 全局的， 这个session 必须你是你我是我。
	private  SqlSessionFactory sessionFactory;
	
	@Before
	public void before() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public  void handler() throws IOException{
	    // 这个session 必须你是你我是我。
		SqlSession session = sessionFactory.openSession();
        System.out.println("222，" + sessionFactory);



		//List<User> users = session.selectList("com.tz.bean.userMapper.findUsers");
		//for (User user : users) {
		//	System.out.println("==============="+user.getUsername());
		//}
	}


	

}
