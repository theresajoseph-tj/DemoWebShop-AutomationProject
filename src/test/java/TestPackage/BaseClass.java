package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest
	
	public void browsersetup()
	{
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	
//	@AfterTest
//   public void tearDown() {
//
//        driver.quit();
//   }
}
