package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
	
	    @FindBy(xpath  = "//a[@class='ico-logout']")
	    WebElement logout;

	    @FindBy(xpath  = "//a[@class='ico-login']")
	    WebElement login;
	    
	    @FindBy(xpath  = "//input[@value='Log in']")
	    WebElement loginbutton;
	    
	    // Email field
	    @FindBy(id="Email")
	    WebElement email;
	    
         // Password field
	    @FindBy(id="Password")
	    WebElement password;
	    
	    
	
    WebDriver driver;
	public Logoutpage(WebDriver driver) {
		     this.driver = driver;
	        PageFactory.initElements(driver, this);
		
	}


    // Enter Email
    public void enterEmail(String emailId) {
        email.clear();
        email.sendKeys(emailId);
    }


    // Enter Password
    public void enterPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    
	public void clickLogin() {
		login.click();
	}
	
	public void clickloginbtn()
	{
		loginbutton.click();
	}
	public void clicklogout()
	{
		logout.click();
	}
	
	//assertions
	
	public boolean isloginlinkisdisplayed()
	{
		return login.isDisplayed();
	}
	
	
	
	
	
	
	
	
}
