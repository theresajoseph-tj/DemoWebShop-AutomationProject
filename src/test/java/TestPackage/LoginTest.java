package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.LoginPage;

public class LoginTest extends BaseClass 
{
	LoginPage lp;
	@BeforeMethod
public void openloginpage()
{
	 lp = new LoginPage(driver);
	lp.clickLogin();
	
}

   @Test(priority = 1)
     public void verifyLoginHeading()
   {

	System.out.println("Verify Login Page Heading");

	Assert.assertTrue(lp.isLoginHeadingDisplayed());

	System.out.println("Login Page Heading Verified Successfully");
	System.out.println("");
}
   
   @Test(priority = 2)
	public void verifyEmailField() {

		System.out.println("Verify Email Field");

		Assert.assertTrue(lp.isEmailDisplayed());

		System.out.println("Email Field Verified Successfully");
		System.out.println("");
	}
	@Test(priority = 3)
	public void verifyPasswordField() {

		System.out.println("Verify Password Field");

		Assert.assertTrue(lp.isPasswordDisplayed());

		System.out.println("Password Field Verified Successfully");
		System.out.println("");
	}
	@Test(priority = 4)
	public void verifyRememberMeCheckbox() {

		System.out.println("Verify Remember Me Checkbox");

		Assert.assertTrue(lp.isRememberMeDisplayed());

		System.out.println("Remember Me Checkbox Verified Successfully");
		System.out.println("");
	}
	@Test(priority = 5)
	public void verifyLoginButton() {

		System.out.println("Verify Login Button");

		Assert.assertTrue(lp.isLoginButtonDisplayed());

		System.out.println("Login Button Verified Successfully");
		System.out.println("");
	}
	@Test(priority = 6)
	public void verifyForgotPasswordLink() {

		System.out.println("Verify Forgot Password Link");

		Assert.assertTrue(lp.isForgotPasswordDisplayed());

		System.out.println("Forgot Password Link Verified Successfully");
		System.out.println("");
	}
   
	@Test(priority = 7)
	public void verifyLoginFunctionality() {

	    System.out.println("Verify Login Functionality");

	    lp.login(
	            "jismypauly123@gmail.com",
	            "jismy123");
   
	    Assert.assertTrue(lp.isLogoutDisplayed(),
	            "Login Failed");

	    System.out.println("Login Successful");
   
	}
   
}
