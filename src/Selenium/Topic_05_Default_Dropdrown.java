package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Topic_05_Default_Dropdrown {
	WebDriver driver;
	//Select dropdownList;  --khai bao
	
	@BeforeClass
	public void beforeClass() {
	  driver = new FirefoxDriver();
	  //dropdownList = new Select(driver.findElement(By.xpath(""))); -- khoi tao
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();  
	}
	
  @Test
 public void Topic_05_Default_Dropdown () throws Exception {
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  
	  WebElement jobRoleDropdown = driver.findElement(By.xpath("//select[@id='job1']")); // vua khai bao vua khoi tao  
	  
	  Select jobRole = new Select(jobRoleDropdown); //jobRole duoc goi la instant cua thu vien Select
	  System.out.println("Dropdown status = " + jobRole.isMultiple());
	  Assert.assertFalse(jobRole.isMultiple()); //isMultiple la kieu boolean(dung hoac sai), thuoc thu vien
	  
	  //Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
	  jobRole.selectByVisibleText("Automation Tester");
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(jobRole.getFirstSelectedOption().getText(),"Automation Tester");
	 
  }  
  
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}