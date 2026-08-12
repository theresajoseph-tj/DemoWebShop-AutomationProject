package TestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PagePackage.RegisterDataDrivenpage;
import Utility.ExcelUtils;
public class RegisterDatadrivenTest {
	WebDriver driver;

    RegisterDataDrivenpage register;
    @BeforeClass
    public void setup() throws Exception {

        ExcelUtils.openExcel("Register");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

   register = new RegisterDataDrivenpage(driver);
    }
   @Test
   public void registrationValidation() throws Exception {

       int rowCount = ExcelUtils.getRowCount();

       for (int i = 1; i <= rowCount; i++) {

           String gender = ExcelUtils.getCellData(i, 0);
           String firstName = ExcelUtils.getCellData(i, 1);
           String lastName = ExcelUtils.getCellData(i, 2);
           String email = ExcelUtils.getCellData(i, 3);
           String password = ExcelUtils.getCellData(i, 4);
           String confirmPassword = ExcelUtils.getCellData(i, 5);
           String expected = ExcelUtils.getCellData(i, 6);

           driver.get("https://demowebshop.tricentis.com/register");

           register.selectGender(gender);

           register.enterFirstName(firstName);

           register.enterLastName(lastName);

           register.enterEmail(email);

           register.enterPassword(password);

           register.enterConfirmPassword(confirmPassword);

           register.clickRegister();

           Thread.sleep(2000);

           String actual;

           if (register.getResult().contains("Your registration completed")) {

               actual = "Valid User";

           } else {

               actual = "Invalid User";
           }

           ExcelUtils.setCellData(i, 7, actual);

           String status = actual.equalsIgnoreCase(expected)
                   ? "PASS"
                   : "FAIL";

           ExcelUtils.setCellData(i, 8, status);

           System.out.println("Row " + i +
                   " | Expected = " + expected +
                   " | Actual = " + actual +
                   " | Status = " + status);
       }
   }

   @AfterClass
   public void tearDown() throws Exception {

       ExcelUtils.saveAndClose();

       driver.quit();
   }

    }


