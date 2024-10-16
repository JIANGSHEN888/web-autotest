package hyxf.Autotest.webtest.Collection.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * @ClassName: BasePage
 * @Description: TODO
 * @Author: JIANGSHEN
 * @Date: 2024/8/31 21:46
 * @Version: 1.0
 **/
public class BasePage {
    public static EdgeDriver driver;

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> finElements(By by) {
        return driver.findElements(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String context) {
        findElement(by).sendKeys(context);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

}
