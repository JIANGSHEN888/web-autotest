package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LoginPage
 * @Description: TODO
 * @Author: JIANGSHEN
 * @Date: 2024/8/31 23:27
 * @Version: 1.0
 **/
public class LoginPage extends BasePage {

    //定位器，获取登录相关元素
    By usernameInput = By.name("username");
    By passwordInput = By.id("password");
    By loginButton = By.xpath("//input[@value='百度一下']");
    By errorMsg = By.cssSelector("#error_msg");
    By homeTitle = By.id("homeTitle");

    /**
     * @param
     * @Description: <打开网页>
     * @Return: null
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/9/1 0:20
     */
    public void openPage() {
        String url = "https://www.baidu.com/";
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//隐式等待
//        WebDriverWait wait = new WebDriverWait(driver,5);    显式等待
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));   等到某个元素找到时结束

        driver.navigate().to(url);//访问目标网页
        driver.manage().window().maximize();//网页最大化
        driver.switchTo().frame("login_frame");//操作范围切换至登录小窗口

    }

    public void closePage(){
        driver.quit();
    }

    /**
     * @param
     * @Description: <1s延时>
     * @Return: null
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/9/1 0:19
     */
    public void sleepWait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String login(String username,String password){
        //清空输入框
        findElement(usernameInput).clear();
        findElement(passwordInput).clear();
        //输入登录用户
        sendKeys(usernameInput,username);
        sendKeys(passwordInput,password);
        click(loginButton);
        return getText(homeTitle);
    }



}
