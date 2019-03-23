package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_UploadFile {
	WebDriver driver;
	
	//Get ra duong dan tai thu muc dang dung
	String rootFolder = System.getProperty("user.dir");
	
	String fileName01 = "01.png";
	String fileName02 = "02.jpeg";
	String fileName03 = "03.png";
	
	String filePath01 = rootFolder + "//uploadFile//" + fileName01;
	String filePath02 = rootFolder + "//uploadFile//" + fileName02;
	String filePath03 = rootFolder + "//uploadFile//" + fileName03;
	
	
@BeforeClass
public void beforeClass() {
		  String os = System.getProperty("os.name").toLowerCase();
			
			if (os.contains("mac")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver");
			}else {
				System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			}
			driver = new ChromeDriver();
			//driver = new FirefoxDriver();

		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
	  }
	
 public void TC_01_SingleUpload() throws Exception {
	//Step 01 - Truy cập vào trang: http://blueimp.github.com/jQuery-File-Upload/
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	
	//Step 02 - Sử dụng phương thức sendKeys để upload 1 file
	WebElement addFileButton = driver.findElement(By.xpath("//input[@type ='file']"));
	addFileButton.sendKeys(filePath01);
	
	Thread.sleep(3000);
  }
  
@Test
public void TC_02_MultipleUpload() throws Exception {
	//Step 01 - Truy cập vào trang: http://blueimp.github.com/jQuery-File-Upload/
	driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	
	//Step 02 - Sử dụng phương thức sendKeys để upload  file
	WebElement addFileButton = driver.findElement(By.xpath("//input[@type ='file']"));
	addFileButton.sendKeys(filePath01 + "\n" + filePath02 + "\n" + filePath03);
	
	Thread.sleep(4000);
	//Step 03 - Kiểm tra file đã được chọn thành công
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName01 + "']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName02 + "']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName03 + "']")).isDisplayed());
	
	//Step 04 - Click Start button để upload cho cả 3 file
	List <WebElement> startButtons = driver.findElements(By.xpath("//table//button[@class='btn btn-primary start']"));
	for (WebElement startBtn: startButtons) {
		startBtn.click();
		Thread.sleep(2000);
	}
	//Step 05 - Sau khi upload thành công verify cả 3 file đã được upload
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='" + fileName01 + "']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='" + fileName02 + "']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@href and @title ='" + fileName03 + "']")).isDisplayed());
	
}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}