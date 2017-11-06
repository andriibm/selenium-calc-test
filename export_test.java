package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ExportTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "file:///C:/Users/Tom/Downloads/TestAutomation/web%20calc/calc.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testExport() throws Exception {
    driver.get(baseUrl + "file:///C:/Users/Tom/Downloads/TestAutomation/web%20calc/calc.html");
    driver.findElement(By.xpath("//input[@value='1']")).click();
    driver.findElement(By.xpath("//input[@value='4']")).click();
    driver.findElement(By.xpath("//input[@value='+']")).click();
    driver.findElement(By.xpath("//input[@value='2']")).click();
    driver.findElement(By.xpath("//input[@value='5']")).click();
    driver.findElement(By.xpath("//input[@value='=']")).click();
    try {
      assertEquals("39", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='C']")).click();
    driver.findElement(By.xpath("//input[@value='4']")).click();
    driver.findElement(By.xpath("//input[@value='8']")).click();
    driver.findElement(By.xpath("//input[@value='-']")).click();
    driver.findElement(By.xpath("//input[@value='5']")).click();
    driver.findElement(By.xpath("//input[@value='0']")).click();
    driver.findElement(By.xpath("//input[@value='=']")).click();
    try {
      assertEquals("-2", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='C']")).click();
    driver.findElement(By.xpath("//input[@value='0']")).click();
    driver.findElement(By.xpath("//input[@value='.']")).click();
    driver.findElement(By.xpath("//input[@value='5']")).click();
    driver.findElement(By.xpath("//input[@value='x']")).click();
    driver.findElement(By.xpath("//input[@value='9']")).click();
    driver.findElement(By.xpath("//input[@value='6']")).click();
    driver.findElement(By.xpath("//input[@value='=']")).click();
    try {
      assertEquals("48", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='C']")).click();
    driver.findElement(By.xpath("//input[@value='1']")).click();
    driver.findElement(By.xpath("//input[@value='2']")).click();
    driver.findElement(By.xpath("//input[@value='0']")).click();
    driver.findElement(By.xpath("//input[@value='/']")).click();
    driver.findElement(By.xpath("//input[@value='4']")).click();
    driver.findElement(By.xpath("//input[@value='=']")).click();
    try {
      assertEquals("30", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='C']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
