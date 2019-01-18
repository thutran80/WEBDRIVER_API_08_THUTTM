package Selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Exercise {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://live.guru99.com");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();  
	}
	
  @Test
 public void TC_01_LoginEmpty() {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[(@title='My Account')]")).click();//chua ki tu tuyen doi trong attribute
	  
	  //driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();//chua ki tu tuyen doi trong chuoi
	  
	  //driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'Account')]")).click();//chua ki tu tuong doi trong chuoi
	  
	  //driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][contains(text(),'My Account')]")).click();
	  
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
	  driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	  
	  String emailErrorMessage = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals(emailErrorMessage, "This is a required field.");
	  
	  String passErrorMessage = driver.findElement(By.xpath(" //div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals(passErrorMessage, "This is a required field.");
  }  
  
  public void TC_02_LoginWithEmailInvalid() {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[(@title='My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
	  driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	  
	  String emailErrorMessage = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	  Assert.assertEquals(emailErrorMessage, "Please enter a valid email address. For example johndoe@domain.com.");  
  }   

  public void TC_03_LoginWithPasswordLessThanSixcharacter() {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[(@title='My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	  
	  String emailErrorMessage = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(emailErrorMessage, "Please enter 6 or more characters without leading or trailing spaces.");  
  } 
  
  public void TC_04_LoginWithPasswordIncorrect() {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[(@title='My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
	  driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	  
	  String emailErrorMessage = driver.findElement(By.xpath("//div[@class='main']//span[text()='Invalid login or password.']")).getText();
	  Assert.assertEquals(emailErrorMessage, "Invalid login or password.");  
  }  
  
 public void TC_05_CreateAnAccount() throws Exception {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[(@title='My Account')]")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  driver.findElement(By.id("firstname")).sendKeys("Thu");
	  driver.findElement(By.id("middlename")).sendKeys("Minh");
	  driver.findElement(By.id("lastname")).sendKeys("Tran");
	  driver.findElement(By.id("email_address")).sendKeys("automation" + randomNumber() + "@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.id("confirmation")).sendKeys("123456");
	  driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	  
	  String messageCreateSucess = driver.findElement(By.xpath("//span[(text()='Thank you for registering with Main Website Store.')]")).getText();
	  Assert.assertEquals(messageCreateSucess, "Thank you for registering with Main Website Store.");

	  driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
	  driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	  
	  WebElement homePageLogo = driver.findElement(By.xpath("//img[@class='large']"));
	  Assert.assertTrue(homePageLogo.isDisplayed());
	  
 
  }  
  
  public int randomNumber() {
	  Random random = new Random();
	  return random.nextInt(999999);
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}