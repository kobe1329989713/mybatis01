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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //List<User> users = session.selectList("com.tz.bean.UserMapper.findUsers");
        //for (User user : users) {
        //	System.out.println("==============="+user.getUsername());
        //}


        // 保存。
        User user = new User();
        //user.setUsername("keke来点距离_07");
        //user.setPassword("111111");
        //user.setAccount("keke");
        //user.setTelephone("23423423423423");
        //user.setIdcard("324565543");
        //user.setIsDelete(0);
        //user.setMale(1);
        //user.setBirthday(new Date());
        //user.setEmail("2346546@qq.com");
        //user.setAddress("是打发是打发大");
        //user.setTeacherId(1);
        //user.setSubjectId(1);
        //user.setAge(30);
        //user.setStatus(1);
        //user.setType(2);
        //int count = session.insert("com.tz.bean.UserMapper.saveUser", user);
        //System.out.println(count>0?"保存成功":"保存失败");


        // 更新。
        //user.setId(2);
        //int count = session.update("com.tz.bean.UserMapper.updateUser", user);
        //System.out.println(count>0?"保存成功":"保存失败");


        // 删除
        // 注：它是不传 对象 的，直接  8 ，注：它哪个xml 第一个删除的的写法。
        //int count = session.delete("com.tz.bean.UserMapper.deleteUser", 8);

        // 第二个删除 ，它就要传一个对象，注：哪个 xml 里面哪个伟参哪里的写法。
        //user.setId(7);
        //int count = session.delete("com.tz.bean.UserMapper.deleteUser", user);


        // 第三个删除，传入一个 map 参数来删除
        Map<String, Object> map = new HashMap<>();
        map.put("username","keke来点距离_04");
        map.put("account", "keke5888");
        int count = session.delete("com.tz.bean.UserMapper.deleteUser2", map);
        System.out.println(count>0?"保存成功":"保存失败");
    }
}
