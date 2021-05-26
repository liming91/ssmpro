package com.generic;


import org.junit.Test;

import java.util.List;

/**
 * 测试DAO泛型的方法
 */
public class UserTestDao {

    @Test
    public void userDaoTest(){
        DAO<User> userDAO = new DAO<>();
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setName("胡歌");
        User user1 = new User();
        user1.setId(2);
        user1.setAge(34);
        user1.setName("胡军");
        userDAO.saveUser("1001",user);
        userDAO.saveUser("1002",user1);
        User u = userDAO.getUser("1001");
        System.out.println(u);
        user1.setName("刘德华");
        userDAO.updateUser("1001",user);
        List<User> list = userDAO.getListUser();
        System.out.println(list);
    }
}
