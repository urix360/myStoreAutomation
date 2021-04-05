package urix.MyStore.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	WebDriver driver;
	@BeforeClass
      public void setup()
    {
	  System.setProperty("webdriver.chrome.driver", "/Users/urix/automation/drivers/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
    }
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
