package Selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Topic_04_HandleTexboxTextArea {
    WebDriver driver;
    String customerName, dateOfBirth, address, city, state, pin, phone, email, password, customerID;
    String editAddress, editCity, editState, editPin, editPhone, editEmail;
    
    By customerNameLocator = By.xpath("//input[@name='name']");
    By dateOfBirthLocator = By.xpath("//input[@id='dob']");
    By addressLocator = By.xpath("//textarea[@name='addr']");
    By cityLocator = By.xpath("//input[@name='city']");
    By stateLocator = By.xpath("//input[@name='state']");
    By pinLocator = By.xpath("//input[@name='pinno']");
    By phoneLocator = By.xpath("//input[@name='telephoneno']");
    By emailLocator = By.xpath("//input[@name='emailid']");
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		customerName = "Thu";
		dateOfBirth = "2000-10-01";
		address = "123 ABC";
		city = "HCM";
		state = "Thu Duc";
		pin = "111111";
		phone = "0909123456";
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		password = "123456";
		
		editAddress = "456 ABC";
		editCity = "HCM City";
		editState = "Quan Thu Duc";
		editPin = "222222";
		editPhone = "1234567890";
		editEmail = "seleniumonline" + randomNumber() + "@gmail.com";
		
		
	  }	
  public void TC_01_CreateCustomer(){
	  //Step 02 - Đăng nhập với thông tin: User =  mngr172599 | Pass = bYbYbun
	  	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr172599");
	  	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bYbYbun");
	  	driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  	
	  	//Verify HomePage được hiển thị thành công
	  	
	  	//C1
	  	/*String homePageText = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
	  	Assert.assertArrayEquals(homePageText, "Welcome To Manager's Page of Guru99 Bank");*/
	  	
	  	//C2
	  	Assert.assertTrue(driver.findElement(By.xpath("//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	  	
	  //Step 03 - Chọn menu New Customer
	  	driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	  
	  //Step 04 - Nhập toàn bộ dữ liệu đúng > Click Submit
	  	driver.findElement(customerNameLocator).sendKeys(customerName);
	  	driver.findElement(By.xpath("//input[@value='f']")).click();
	  	driver.findElement(dateOfBirthLocator).sendKeys(dateOfBirth);
	  	driver.findElement(addressLocator).sendKeys(address);
	  	driver.findElement(cityLocator).sendKeys(city);
	  	driver.findElement(stateLocator).sendKeys(state);
	  	driver.findElement(pinLocator).sendKeys(pin);
	  	driver.findElement(phoneLocator).sendKeys(phone);
	  	driver.findElement(emailLocator).sendKeys(email);
	  	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  //Step 05 - Sau khi hệ thống tạo mới Customer thành công > Get ra thông tin của Customer ID
	  	customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	  	System.out.println("Customer ID = " + customerID);
	  	
	  //Step 06 - Verify tất cả thông tin được tạo mới thành công
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dateOfBirth);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
	  }
  public void TC_02_EditCustomer(){
	//Step 07 - Chọn menu Edit Customer > Nhập Customer ID > Submit
	  	driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerID);
	  	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  	
	//Step 08 - Tại màn hình Edit Customer:
	  		//Verify giá trị tại 2 field: Customer Name và Address đúng với dữ liệu khi tạo mới New Customer tại Step 04
	  	Assert.assertEquals(driver.findElement(customerNameLocator).getAttribute("value"),customerName);
	  	Assert.assertEquals(driver.findElement(addressLocator).getText(), address);
	  	
	 //Step 09 - Nhập giá trị mới tại tất cả các field (ngoại trừ những field bị disable) > Submit
	  	driver.findElement(addressLocator).clear();
	  	driver.findElement(addressLocator).sendKeys(editAddress);
	  	driver.findElement(cityLocator).clear();
	  	driver.findElement(cityLocator).sendKeys(editCity);
	  	driver.findElement(stateLocator).clear();
	  	driver.findElement(stateLocator).sendKeys(editState);
	  	driver.findElement(pinLocator).clear();
	  	driver.findElement(pinLocator).sendKeys(editPin);
	  	driver.findElement(phoneLocator).clear();
	  	driver.findElement(phoneLocator).sendKeys(editPhone);
	  	driver.findElement(emailLocator).clear();
	  	driver.findElement(emailLocator).sendKeys(editEmail);
	  	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  	
	 //Step 10 - Verify giá trị tất cả các field đúng với dữ liệu sau khi đã Edit thành công
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddress);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editPhone);
	  	Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);	  	
  }

 @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
 public int randomNumber() {
	 Random random = new Random();//lay ra bo thu vien random cua java ra
	 return random.nextInt(999999);
 }

}