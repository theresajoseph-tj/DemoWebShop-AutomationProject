package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement loginHeading;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "RememberMe")
	WebElement rememberMe;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;

	@FindBy(linkText = "Forgot password?")
	WebElement forgotPassword;
	
	@FindBy(linkText = "Log out")
	WebElement logoutLink;
	
     WebDriver driver;
     
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLogin() {

		loginLink.click();
	}
	public boolean isLoginHeadingDisplayed() {

		return loginHeading.isDisplayed();
	}
	
	public boolean isEmailDisplayed() {

		return email.isDisplayed();
	}
	public boolean isPasswordDisplayed() {

		return password.isDisplayed();
	}
	public boolean isRememberMeDisplayed() {

		return rememberMe.isDisplayed();
	}

	public boolean isLoginButtonDisplayed() {

		return loginButton.isDisplayed();
	}
	public boolean isForgotPasswordDisplayed() {

		return forgotPassword.isDisplayed();
	}
	public void login(String userEmail, String userPassword) {

	    email.clear();
	    email.sendKeys(userEmail);

	    password.clear();
	    password.sendKeys(userPassword);

	    loginButton.click();
	}
	public boolean isLogoutDisplayed() {

	    return logoutLink.isDisplayed();
	}

}
