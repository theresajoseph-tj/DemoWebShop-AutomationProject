package PagePackage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterDataDrivenpage {
	
	@FindBy(id = "gender-male")
    WebElement male;

    @FindBy(id = "gender-female")
    WebElement female;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement result;

	WebDriver driver;
	public RegisterDataDrivenpage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	public void selectGender(String gender) {

	    if (gender.equalsIgnoreCase("Male")) {
	        male.click();
	    } else {
	        female.click();
	    }
	}

	public void enterFirstName(String fname) {
	    firstName.clear();
	    firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
	    lastName.clear();
	    lastName.sendKeys(lname);
	}

	public void enterEmail(String mail) {
	    email.clear();
	    email.sendKeys(mail);
	}

	public void enterPassword(String pass) {
	    password.clear();
	    password.sendKeys(pass);
	}

	public void enterConfirmPassword(String cpass) {
	    confirmPassword.clear();
	    confirmPassword.sendKeys(cpass);
	}

	public void clickRegister() {
	    registerButton.click();
	}

	public String getResult() {

	    try {
	        return result.getText();
	    } catch (Exception e) {
	        return "";
	    }
}
}
