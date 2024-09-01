package com.example.testcase;

import com.example.page.LoginPage;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static sun.security.jgss.GSSUtil.login;

/**
 * @ClassName: TestUrgeHomePage
 * @Description: TODO
 * @Author: JIANGSHEN
 * @Date: 2024/9/1 11:39
 * @Version: 1.0
 **/
public class TestUrgeHomePage {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    void openHomePage(){
        loginPage.openPage();
    }

    @Test
    void userLogin(){
        String username = "adminstrator";
        String password = "123456";
        String expectHomeTitle = "催收系统";
        Assert.assertEquals(loginPage.login(username,password),expectHomeTitle);
    }

    @AfterMethod
    void closePage(){
        loginPage.closePage();
    }
}
