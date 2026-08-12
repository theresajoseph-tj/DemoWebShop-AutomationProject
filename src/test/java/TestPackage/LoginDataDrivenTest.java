package TestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PagePackage.LoginDataDrivenPage;
import Utility.ExcelUtils;
public class LoginDataDrivenTest {

	WebDriver driver;

	LoginDataDrivenPage login;

	@BeforeClass
	public void setup() throws Exception {

		ExcelUtils.openExcel("Login");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		login = new LoginDataDrivenPage(driver);
	}
	@Test
	public void loginValidation() throws Exception {

		int rowCount = ExcelUtils.getRowCount();

		for (int i = 1; i <= rowCount; i++) {

			String email = ExcelUtils.getCellData(i, 0);
			String password = ExcelUtils.getCellData(i, 1);
			String expected = ExcelUtils.getCellData(i, 2);

			driver.get("https://demowebshop.tricentis.com/");

			login.clickLoginLink();

			login.enterEmail(email);

			login.enterPassword(password);

			login.clickLoginButton();

			Thread.sleep(2000);

			String actual;

			if (login.isLogoutDisplayed()) {

				actual = "Valid User";

				login.clickLogout();

			} else {

				actual = "Invalid User";
			}

			ExcelUtils.setCellData(i, 3, actual);

			String status;

			if (actual.equalsIgnoreCase(expected)) {

				status = "PASS";

			} else {

				status = "FAIL";
			}

			ExcelUtils.setCellData(i, 4, status);

			System.out.println("Row " + i +
					" | Expected = " + expected +
					" | Actual = " + actual +
					" | Status = " + status);

			Thread.sleep(1000);
		}
	}

	@AfterClass
	public void tearDown() throws Exception {

		ExcelUtils.saveAndClose();

		if (driver != null) {

			driver.quit();
		}
	}
}
