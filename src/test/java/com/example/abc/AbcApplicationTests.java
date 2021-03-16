package com.example.abc;

import com.example.abc.pojo.User;
import com.example.abc.service.Userservice;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.*;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@SpringBootTest
@RunWith(SpringRunner.class)
//@ContextConfiguration({ classpath*:"classpath:applicationContext-mybatis-test.xml"})
@TestExecutionListeners({
        DbUnitTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class, databaseConnection = { "dataSource" })
class AbcApplicationTests {

@Autowired
private Userservice userservice;

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/testshuju/cha.xml",connection = "dataSource")
    void insert() {
        User user=new User();

      userservice.insert(user);
        Assert.assertEquals("张三",user.getName());

    }
    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/testshuju/cha.xml",connection = "dataSource")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/testshuju/qiwang.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "/testshuju/qiwang.xml")
    void selectbyid() {
        User user=userservice.selectbyid(1);
        Assert.assertEquals("张三",user.getName());
    }






    @Test
    void contextLoads() {
    }

}
