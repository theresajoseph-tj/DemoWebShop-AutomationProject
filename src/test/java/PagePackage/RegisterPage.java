package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {

	// Register Link
		@FindBy(linkText = "Register")
		WebElement registerLink;
		//a[@class='ico-register']

		// Register Page Heading
		@FindBy(xpath = "//div[@class='page-title']/h1")
		WebElement registerHeading;
		
		//h1[normalize-space()='Register']
		
		@FindBy(id = "FirstName")
		WebElement firstname;	
		@FindBy(id="LastName")
		WebElement lastname;
		@FindBy(id = "Email")
		WebElement email;
		@FindBy(id = "Password")
		WebElement password;
		@FindBy(id = "ConfirmPassword")
		WebElement confirmPassword;
		@FindBy(id = "register-button")
		WebElement registerButton;
		@FindBy(linkText = "Log out")
		WebElement logoutLink;
		@FindBy(xpath = "//div[@class='result']")
		WebElement SuccessMessage;

		
		WebDriver driver;
		public RegisterPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
		// Click Register Link
		public void clickRegister() {
			registerLink.click();
		}
		//Verify Register Heading
		public boolean isRegisterHeadingDisplayed() {
			return registerHeading.isDisplayed();
		}
		
		public boolean isfirstnameDisplayed()
		{
			return firstname.isDisplayed();
		}
		
		public boolean islastnamedisplayed()
		{
			return lastname.isDisplayed();
		}
		public boolean isEmailDisplayed() {
			return email.isDisplayed();
		}
		
		public boolean isPasswordDisplayed() {
			return password.isDisplayed();
		}
		public boolean isConfirmPasswordDisplayed() {
			return confirmPassword.isDisplayed();
		}
		public boolean isRegisterButtonDisplayed() {
			return registerButton.isDisplayed();
		}
		
		public void registerUser(String fname,
                String lname,
                String mail,
                String pass,
                String cpass)
		{ 
			firstname.clear();
			firstname.sendKeys(fname);
			
			lastname.clear();
			lastname.sendKeys(lname);
			
			email.clear();
			email.sendKeys(mail);
			
			password.clear();
			password.sendKeys(pass);
			
			confirmPassword.clear();
			confirmPassword.sendKeys(cpass);
			
			registerButton.click();
		
		}
	 public String getsuccessmessage()
	 {
		 return SuccessMessage.getText();
	 }
	 public void logout() {
		    logoutLink.click();
		}
}
