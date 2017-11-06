import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalculatorTest {



    private WebDriver driver;

    @Before
    public void start()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tom/Downloads/TestAutomation/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Tom/Downloads/TestAutomation/web%20calc/calc.html");
    }

    @Test
    public void add_test()
    {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("39", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void sub_test()
    {
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("-2", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void mul_test()
    {
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='.']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='9']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("48", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void div_test()
    {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("30", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @After
    public void  stop()
    {
        driver.quit();
    }
}
