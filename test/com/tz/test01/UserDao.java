package com.tz.test01;

import com.tz.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试 mybatis 增 删 查 改。
 */
public class UserDao {

    private SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public  void handler() throws IOException{
        SqlSession session = sessionFactory.openSession();

        // 测试 查询。                               命名空间 点 ID
        List<User> users = session.selectList("com.tz.bean.UserMapper.findUsers");
        for (User user : users) {
        	System.out.println("==============="+user.getUsername());
        }
    }
}
