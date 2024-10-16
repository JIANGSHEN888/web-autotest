package hyxf.Autotest.webtest.Collection.page;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
    By usernameInput = By.xpath("//input[@type='text' and @placeholder='账号']");
    By passwordInput = By.xpath("//input[@type='password' and @placeholder='密码']");
    By loginButton = By.xpath("//button[@class='el-button btn el-button--primary']");
    By errorMsg = By.cssSelector("#error_msg");
    By homeTitle = By.xpath("//span[text()='杭银催收系统'][1]");

    public EdgeOptions setEdgeOptions(){
        System.setProperty("webdriver.edge.driver", "webDrivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.verboseLogging", "true");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");//允许驱动访问所有网络
        return edgeOptions;
    }
    /**
     * @param
     * @Description: <打开网页>
     * @Return: null
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/9/1 0:20
     */
    public void openLoginPage() {
        String url = "https://urge-web-bat.51xf.cn/";
        driver = new EdgeDriver(setEdgeOptions());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//隐式等待
//        WebDriverWait wait = new WebDriverWait(driver,5);    显式等待
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));   等到某个元素找到时结束
        driver.navigate().to(url);//访问目标网页
        driver.manage().window().maximize();//网页最大化
//        driver.switchTo().frame("login_frame");//操作范围切换至登录小窗口
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
