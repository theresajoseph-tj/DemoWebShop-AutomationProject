package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.Logoutpage;

public class LogoutTest extends BaseClass {
	
	Logoutpage lp;
	
	@BeforeMethod
	public void logoutsetup()
	{
		lp = new Logoutpage(driver);
	}
	 
     @Test 
     public void Verifylogout()
     {
    	  lp.clickLogin();
    	  
    	 // Enter Email
         lp.enterEmail("thek1312@gmail.com");

         // Enter Password
         lp.enterPassword("thek1312");
    	  
         lp.clickloginbtn();
    	  
    	 // Click Logout
    	    lp.clicklogout();
    	    
    	    //verify loginlink is displayed after logout
    	    
    	    Assert.assertTrue(lp.isloginlinkisdisplayed());
    	    
    	    

     }
    
 
    

}
