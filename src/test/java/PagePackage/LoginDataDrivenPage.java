package PagePackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDataDrivenPage {

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;

	@FindBy(linkText = "Log out")
	WebElement logout;
   
    WebDriver driver;
	public LoginDataDrivenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickLoginLink() {

		loginLink.click();
	}

	public void enterEmail(String mail) {

		email.clear();
		email.sendKeys(mail);
	}

	public void enterPassword(String pass) {

		password.clear();
		password.sendKeys(pass);
	}

	public void clickLoginButton() {

		loginButton.click();
	}

	public boolean isLogoutDisplayed() {

		try {

			return logout.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public void clickLogout() {

		if (isLogoutDisplayed()) {

			logout.click();
		}
}
}
