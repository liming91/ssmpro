package com.ming;

import com.ming.dao.DeptMapper;
import com.ming.dao.EmpMapper;
import com.ming.dao.EmpMapperCustom;
import com.ming.dao.UserMapper;
import com.ming.model.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * spring单元测试dao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class mapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpMapperCustom empMapperCustom;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void mapperCrud() {
        //1.原始的是先获取IOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
//        DeptMapper deptMapper = applicationContext.getBean(DeptMapper.class);
//        System.out.println(deptMapper);
        // deptMapper.insertSelective(new Dept(null,"销售部"));
        //批量插入利用SqlSessionTemplate
        /*for (int i=0;i<1000;i++){
           String uuid= UUID.randomUUID().toString().substring(0,5)+i;
           EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
           empMapper.insertSelective(new Emp(null,uuid,"m",uuid+"@qq.com",1));
        }*/

    }

}
