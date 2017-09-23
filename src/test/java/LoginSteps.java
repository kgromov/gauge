import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by konstantin on 23.09.2017.
 */
public class LoginSteps {
    @Step("open page")
    public void gotoPage() {

    }

    @Step("login as admin user")
    public void loginAsAdmin() throws InterruptedException {
        Driver.webDriver.get(System.getenv("APP_URL"));
        new WebDriverWait(Driver.webDriver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.name("UserName")));
        Gauge.writeMessage("Page title is %s", Driver.webDriver.getTitle());
        Driver.webDriver.findElement(By.name("UserName")).sendKeys(System.getenv("USER_NAME"));
        Driver.webDriver.findElement(By.name("Password")).sendKeys(System.getenv("USER_PASSWORD"));
        Driver.webDriver.findElement(By.xpath(".//input[@type='submit']")).click();
        Thread.sleep(5000);
        Gauge.writeMessage("Page title is %s", Driver.webDriver.getTitle());
        assertTrue( Driver.webDriver.findElement(By.xpath(".//div[@class='px-header-logo']")).isDisplayed());

    }
}
