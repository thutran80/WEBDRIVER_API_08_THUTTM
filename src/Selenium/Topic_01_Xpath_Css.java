package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Xpath_Css {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();  
	}
	
  @Test
  public void TC_00_Xpath_xample() throws Exception  {
	  
//<input id="email" class="input-text required-entry validate-email" type="email" title="Email Address" value="" name="login[username]" spellcheck="false" autocorrect="off" autocapitalize="off">
	  //Id
	  driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.id("email")).clear();
	  
	  
	  //Xpath-id
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  		
	  
	  //Class -- chu y: trong ClassName chi lay 1 phan trong chuoi, khong lay toan bo
	  driver.findElement(By.className("validate-email")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.className("validate-email")).clear();
	  
	  
	  //Xpath-class
	  driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).clear();
	  
	  
	  //Name
	  driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.name("login[username]")).clear();
	  	  
	  //Xpath-name
	  driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("automation@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@name='login[username]']")).clear();
	  	  
  }
  

  


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}