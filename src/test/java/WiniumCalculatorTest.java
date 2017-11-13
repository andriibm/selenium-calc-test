
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class WiniumCalculatorTest {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    @BeforeClass
    public static void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "D:\\desktop_calc_b2\\Calculator.exe");
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), capabilities);
        driverWait = new WebDriverWait(driver, 30);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("1000")));
    }

    @Test
    public void add_test()
    {
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("39", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void sub_test()
    {
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("0")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("-2", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void mul_test()
    {
        driver.findElement(By.name("0")).click();
        driver.findElement(By.name(".")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("*")).click();
        driver.findElement(By.name("7")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("38", driver.findElement(By.id("1000")).getText());
    }

    @Test
    public void div_test()
    {
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("0")).click();
        driver.findElement(By.name("/")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();
        Assert.assertEquals("30", driver.findElement(By.id("1000")).getText());
    }

    @After
    public void clear()
    {
        driver.findElement(By.name("Clear")).click();
    }

    @AfterClass
    public static void  stop()
    {
        driver.quit();
    }
}
