package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.RegisterPage;

public class RegisterTest extends BaseClass {
	 RegisterPage rp;
	 @BeforeMethod
	 public void openregisterpage()
	 {
		 rp = new RegisterPage(driver);
		 rp.clickRegister();
	 }
	 
	 //Register UI
	 
	@Test(priority = 1)
	public void verifyRegisterPageHeading()
	{
	  

       System.out.println("Verifying Register Heading..."); 
	   Assert.assertTrue(rp.isRegisterHeadingDisplayed(),"Register Page Heading is not displayed");
	   System.out.println("Heading Display Successfully");
       System.out.println();
	}
	
    @Test(priority = 2)
public void VerifyFirstNameField()
{
    	
    	 System.out.println("Verifying FirstNameField..."); 
    	 Assert.assertTrue(rp.isfirstnameDisplayed());
    	  System.out.println("First Name Field Display Successfully");
    	  System.out.println();
}
    @Test(priority = 3)
    public void verifyLastNameField()
    {
    	
    	 System.out.println("Verifying LastNameField..."); 
    	 Assert.assertTrue(rp.islastnamedisplayed());
    	  System.out.println("Last Name Field Display Successfully");
    	  System.out.println();
    	 
    }
    @Test(priority = 4)
    public void verifyEmailField() {


    	System.out.println("Verifying Email Field....");

    	Assert.assertTrue(rp.isEmailDisplayed(),
    			"Email Field is not displayed");

    	System.out.println("Email Field Display Successfully");
    	System.out.println();
    }
    @Test(priority = 5)
    public void verifyPasswordField() {

    	System.out.println("Verifying Password Field....");

    	Assert.assertTrue(rp.isPasswordDisplayed(),
    			"Password Field is not displayed");

    	System.out.println("Password Field Display Successfully");
    	System.out.println();
    }
    @Test(priority = 6)
    public void verifyConfirmPasswordField() {

    	System.out.println("Verifying Confirm Password Field....");

    	Assert.assertTrue(rp.isConfirmPasswordDisplayed(),
    			"Confirm Password Field is not displayed");

    	System.out.println("Confirm Password Field Display Successfully");
    	System.out.println();
    }
    
 
    @Test(priority = 7)
    public void verifyRegisterButton() {
    	
      System.out.println("Verifying Register Button....");

    	Assert.assertTrue(rp.isRegisterButtonDisplayed(),
    			"Register Button is not displayed");

    	System.out.println("Register Button Display Successfully");
    	System.out.println();
    }
    
    // Register Functionality
    
    @Test(priority = 8)
    public void VerifyRegistrationFunctionality()
    {
    
      System.out.println("Verify Registration functionality");
      rp.registerUser("Marium","Thomas","mariumthomas854"+System.currentTimeMillis()+"@gmail.com","mariumthomas854","mariumthomas854");
      
      String actual =rp.getsuccessmessage();
      String expected ="Your registration completed";
      Assert.assertEquals(actual, expected);
      System.out.println("Registration Functionality Verified Successfully");
      rp.logout();
      
}
    
}















