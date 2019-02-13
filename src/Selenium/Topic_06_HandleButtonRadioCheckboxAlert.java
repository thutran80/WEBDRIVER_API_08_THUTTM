package Selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_06_HandleButtonRadioCheckboxAlert {
	WebDriver driver;
	JavascriptExecutor javascript; //khai bao bien 

	@BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  javascript = (JavascriptExecutor) driver;
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}
	
	@Test
	  public void TC_01_HandleButton() {
		//Step 01 - Truy cập vào trang: http://live.guru99.com/			
		driver.get("http://live.guru99.com");
		
		//Step 02 - Click vào link My Account dưới footer (Sử dụng Javascript Executor code)
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		javascript.executeScript("arguments[0].click();", myAccountLink);
		
		//Step 03 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/login/
		String myAccountURL = driver.getCurrentUrl();
		Assert.assertEquals(myAccountURL, "http://live.guru99.com/index.php/customer/account/login/");
		
		//Step ssertEquals04 - Click vào button CREATE AN ACCOUNT (Sử dụng Javascript Executor code)
		WebElement createAnAccountBtn = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		javascript.executeScript("arguments[0].click();", createAnAccountBtn);
		
		//Step 06 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/create/
		String createAnAccountUrl = driver.getCurrentUrl();
		Assert.assertEquals(createAnAccountUrl, "http://live.guru99.com/index.php/customer/account/create/");

	}
  



	 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}