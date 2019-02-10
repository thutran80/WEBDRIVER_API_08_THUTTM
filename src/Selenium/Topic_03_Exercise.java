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

public class Topic_03_Exercise {
    WebDriver driver;
	By emailTextbox = By.xpath("//input[@id='mail']");
	By under18Radio = By.xpath("//input[@id='under_18']");
	By educationTextArea = By.xpath("//textarea[@id='edu']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By biographyTextbox = By.xpath("//textarea[@id='bio']");
	By jobRole02 = By.xpath("//select[@id='id-job2']");
	By jobRole01 = By.xpath("//select[@id='id-job1']");
	By interDevelopment = By.xpath("//label[@class='light' and text()='Development']");
	By slider01 = By.xpath("//input[@id='slider-1']");
	By buttonEnabled = By.xpath("//button[@id='button-enabled']");
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  }	
  @Test
  public void TC_01_CheckElementisDisplay() throws Exception {
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  if (isElementDisplayed(emailTextbox)) {
		  driver.findElement(emailTextbox).sendKeys("Automation testing");
	  }
	  if (isElementDisplayed(under18Radio)) {
		  driver.findElement(under18Radio).click();
	  }
	  if (isElementDisplayed(educationTextArea)) {
		  driver.findElement(educationTextArea).sendKeys("Automation testing");
	  }
	   Thread.sleep(3000);		
  }
  
  @Test
  public void TC_02_CheckElementisEnable() throws Exception {
	  driver.get("https://daominhdam.github.io/basic-form/index.html");
	  Assert.assertTrue(isElementEnabled(emailTextbox));
	  Assert.assertTrue(isElementEnabled(under18Radio));
	  Assert.assertTrue(isElementEnabled(educationTextArea));
	  Assert.assertFalse(isElementEnabled(passwordTextbox));
	  Assert.assertFalse(isElementEnabled(biographyTextbox));
  }
  
  @Test
  public void TC_03_CheckSelected() throws Exception {
	 driver.get("https://daominhdam.github.io/basic-form/index.html");
	 driver.findElement(under18Radio).click();
	 driver.findElement(interDevelopment).click();
	 if (isSelected(under18Radio) == false) {
		 driver.findElement(under18Radio).click();
		 driver.findElement(interDevelopment).click();
	 }
	 
 }
 
 public boolean isElementDisplayed(By by) {
	 WebElement element = driver.findElement(by);
	 if (element.isDisplayed()) {
		 return true;
	 } return false;
 }
 
 public boolean isElementEnabled(By by) {
	 WebElement element = driver.findElement(by);
	 if (element.isEnabled()) {
		 System.out.println("Element:" + by + "is enabled!");
		 return true;
	 } else {
		 System.out.println("Element:" + by + "is disabled!");
		 return false;
	 }
 }  
 
 public boolean isSelected (By by) {
	 WebElement element = driver.findElement(by);
	 if(element.isSelected()) {
		 return true;
	 }return false;
 }
  
 @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}