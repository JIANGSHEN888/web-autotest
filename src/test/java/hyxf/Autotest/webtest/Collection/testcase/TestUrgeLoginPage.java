package hyxf.Autotest.webtest.Collection.testcase;

import hyxf.Autotest.webtest.Collection.page.LoginPage;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @ClassName: TestUrgeHomePage
 * @Description: TODO
 * @Author: JIANGSHEN
 * @Date: 2024/9/1 11:39
 * @Version: 1.0
 **/
public class TestUrgeLoginPage {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    void openHomePage(){
        loginPage.openLoginPage();
    }

    @Test
    void userLogin(){
        String username = "administrator1";
        String password = "888888";
        String expectHomeTitle = "杭银催收系统";
        Assert.assertEquals(loginPage.login(username,password),expectHomeTitle);
    }

    @AfterMethod
    void closePage(){
        loginPage.closePage();
    }
}
