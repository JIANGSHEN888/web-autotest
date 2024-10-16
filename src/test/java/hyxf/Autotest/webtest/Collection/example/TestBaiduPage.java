package hyxf.Autotest.webtest.Collection.example;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import static hyxf.Autotest.webtest.Utils.CmdExecService.generateAllureTestReport;

/**
 * @ClassName: TestBaiduPage
 * @Description: TODO
 * @Author: 64463
 * @Date: 2024/7/20 14:00
 * @Version: 1.0
 **/
public class TestBaiduPage {
    public EdgeDriver driver;

    @BeforeMethod
    /**
     * @Description: <打开浏览器>
     * @param null
     * @Return: void
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/7/9 22:35
     */ public void openBrowser() {
        System.setProperty("webdriver.edge.driver", "webDrivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.verboseLogging", "true");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");//允许驱动访问所有网络
        driver = new EdgeDriver(edgeOptions);
    }

    /**
     * @Description: <测试百度首页>
     * @Return: null
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/7/4 22:51
     */
    @Test
    public void testBaiduHomePage() {
        try {
            driver.navigate().to("https://www.baidu.com/");
            driver.findElement(By.id("kw")).sendKeys("WebDriver");
//            driver.findElement(By.id("su")).click();
//            driver.findElement(By.xpath("//input[@value='百度一下']")).click();
            driver.findElement(By.className("s_btn")).click();
            Thread.sleep(10000);
            Assert.assertTrue(driver.getPageSource().contains("工作原理及常用方法"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    /**
     * @Description: <关闭浏览器>
     * @param null
     * @Return: void
     * @Throws:
     * @Author: JiangShen
     * @Date: 2024/7/9 22:36
     */
    public void closeBrowser() {
        driver.quit();
        //生成allure测试报告
        generateAllureTestReport();
    }
}
