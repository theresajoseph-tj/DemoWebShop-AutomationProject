package TestPackage;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.CommonFeaturesPage;

public class CommonFeaturesTest extends BaseClass
{
	CommonFeaturesPage page;
	@BeforeMethod
	public void pagesetup()
	{
		page = new CommonFeaturesPage(driver);
    }

    @Test(priority = 1)
    public void VerifyApplicationURL() 
    {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
        
        System.out.println("Verifying URL");
        // Expected URL
        String expectedURL = "https://demowebshop.tricentis.com/";

        // Actual URL
        String actualURL = driver.getCurrentUrl();

        // Print URLs in Console
        System.out.println("Expected URL : " + expectedURL);
        System.out.println("Actual URL   : " + actualURL);

        // Assertion
        Assert.assertEquals(actualURL, expectedURL, "Application URL is incorrect.");

        // Success Message
        System.out.println("URL Verification Successful");
        System.out.println();
        
    }
    
    
   @Test(priority = 2)
   public void VerifyApplicationTitle()
    {
        
	    System.out.println("Verifying Title");
        String expectedTitle = "Demo Web Shop";
        String actualTitle = driver.getTitle();

        System.out.println("Expected Title : " + expectedTitle);
        System.out.println("Actual Title : " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Application Title is incorrect.");

       System.out.println("Title Verification Successful");
       System.out.println();
    }
    
    
    @Test(priority = 3)
    public void VerifyLogoDisplayed() 
    {
    
    	
    	System.out.println("Verifying Demo Web Shop Logo..."); 
    	
    	Assert.assertTrue(page.islogodisplayed(),"Demo Web Shop logo is not displayed.");
    	
       System.out.println("Logo Verification Successful");
       System.out.println();
	
}
    @Test(priority = 4)
    public void verifyLogoNavigatesToHomePage()
    {
    	System.out.println("Verifying Logo Navigates to HomePage");
    	System.out.println("Clicking Books menu...");
    	
    	page.clickbooks();
    	
    	System.out.println("Clicking Demo Web Shop Logo...");
    	
    	page.clicklogo();
    	
    	String expectedURL = "https://demowebshop.tricentis.com/";
        String actualURL = driver.getCurrentUrl();
        
        System.out.println("Expected URL : " + expectedURL);
        System.out.println("Actual URL : " + actualURL);
        
        Assert.assertEquals(actualURL, expectedURL, "Logo did not navigate to the Home Page.");
        
        System.out.println("Logo Navigation Verification Successful");
        System.out.println();

    }
    @Test(priority = 5)
    public void VerifyRegisterDisplayed() 
    {
    	
        System.out.println("Verifying Register Link...");
    	Assert.assertTrue(page.isregisterdisplayed(),"Register link is not displayed.");
    	System.out.println("Register Link Verification Successful");
        System.out.println();
        }
    @Test(priority = 6)
    public void VerifyRegisterNavigation()
    {
    
    	System.out.println("Verifying Register Navigation");
    	page.clickregister();
    	String expectedUrl ="https://demowebshop.tricentis.com/register";
    	String actualUrl=driver.getCurrentUrl();
    	System.out.println("Expected URL : " + expectedUrl);
    	System.out.println("Actual URL : " + actualUrl);
    	Assert.assertEquals(expectedUrl,actualUrl,"Register link did not navigate to the Register page");
    	System.out.println("Register Navigation Verification Successful");
    	System.out.println();

}
    @Test(priority = 7)
    public void VerifyLoginDisplayed()
    {
    
    	System.out.println("Verify Login Link");
    	Assert.assertTrue(page.islogindisplayed(),"Login link is not displayed.");
    	System.out.println("Login Link Verification Successful");
    	System.out.println();
    	
    }
    @Test(priority = 8)
    public void verifyLoginNavigation() throws InterruptedException 
    {
    	
    	System.out.println("Verifying Login Navigation ");
    	page.clicklogin();
    	Thread.sleep(3000);
        String expectedUrl = "https://demowebshop.tricentis.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Login link did not navigate to the Login page.");
       System.out.println("Login Navigation Verification Successful");
       System.out.println();
        
}
    @Test(priority = 9)
    public void verifyValidProductSearch() throws InterruptedException 
    {
    	System.out.println("Verifying Valid Product Search...");
    	
    	page.entersearchproduct("Fiction EX");
    	page.clickserachbutton();
    	
    	Thread.sleep(3000);
    	
    	String expectedUrl =  "https://demowebshop.tricentis.com/search?q=Fiction+EX";
        String actualUrl = driver.getCurrentUrl();
        
        System.out.println("Expected URL : " + expectedUrl);
        System.out.println("Actual URL : " + actualUrl);
        
        Assert.assertEquals(actualUrl, expectedUrl,"Valid product search failed.");
        System.out.println("Valid Product Search Verification Successful");
        
        System.out.println();
}
    @Test(priority = 10)
    public void verifyInvalidProductSearch() throws InterruptedException {

        System.out.println("Verifying Invalid Product Search...");

        page.entersearchproduct("expired123");
        page.clickserachbutton();

        Thread.sleep(3000);

        String expectedUrl = "https://demowebshop.tricentis.com/search?q=expired123";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Expected URL : " + expectedUrl);
        System.out.println("Actual URL : " + actualUrl);

        Assert.assertEquals(actualUrl, expectedUrl,"Invalid product search failed.");

        System.out.println("Invalid Product Search Verification Successful");
    }

    @Test(priority = 11)
    public void verifyEmptyProductSearch() throws InterruptedException {

        System.out.println("Verifying Empty Product Search...");

        page.entersearchproduct("");
        page.clickserachbutton();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        String expectedMessage = "Please enter some search keyword";
        String actualMessage = alert.getText();

        System.out.println("Expected Message : " + expectedMessage);
        System.out.println("Actual Message : " + actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage,
                "Empty Product Search Failed.");

        alert.accept();

        System.out.println("Empty Product Search Verification Successful");
        System.out.println();
    }
    
    @Test(priority = 12)
    public void verifyNavigationMenuLinksDisplayed() {

        System.out.println("Verifying Navigation Menu Links...");

        Assert.assertTrue(page.isbookdisplayed(),
                "Books link is not displayed.");

        Assert.assertTrue(page.isComputersDisplayed(),
                "Computers link is not displayed.");

        Assert.assertTrue(page.isElectronicsDisplayed(),
                "Electronics link is not displayed.");

        Assert.assertTrue(page.isApparelShoesDisplayed(),
                "Apparel & Shoes link is not displayed.");

        Assert.assertTrue(page.isDigitalDownloadsDisplayed(),
                "Digital Downloads link is not displayed.");

        Assert.assertTrue(page.isJewelryDisplayed(),
                "Jewelry link is not displayed.");

        Assert.assertTrue(page.isGiftCardsDisplayed(),
                "Gift Cards link is not displayed.");

        System.out.println("Navigation Menu Links Verification Successful");
        System.out.println();
    }
    @Test(priority = 13)
    public void verifyBooksNavigation() throws InterruptedException {

        System.out.println("Verifying Books Navigation...");

        page.clickbooksnavi();

        Thread.sleep(2000);

        String expectedUrl = "https://demowebshop.tricentis.com/books";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Expected URL : " + expectedUrl);
        System.out.println("Actual URL : " + actualUrl);

        Assert.assertEquals(actualUrl, expectedUrl,
                "Books navigation failed.");

        System.out.println("Books Navigation Verification Successful");
        System.out.println();

    }
    @Test(priority = 14)
    public void VerifyShoppingCartLinkIsClickable() throws InterruptedException
    {
    	System.out.println("Verify ShoppingCart Link");
    	page.clickingShoppingCart();
    	Thread.sleep(4000);
    	String Expectedurl="https://demowebshop.tricentis.com/cart";
    	String actualurl = driver.getCurrentUrl();	
    	System.out.println("Expected URL : " + Expectedurl);
        System.out.println("Actual URL : " + actualurl);
        Assert.assertEquals(actualurl, Expectedurl,"Shopping Cart link is not clickable.");
        System.out.println("Shopping Cart Link Verification Successful");
        System.out.println();
    }
    @Test(priority = 15)
    public void verifyWishlistLinkIsClickable() throws InterruptedException {

        System.out.println("Verify Wishlist Link");

        page.clickWishlist();

//        Thread.sleep(4000);

        String expectedUrl = "https://demowebshop.tricentis.com/wishlist";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Expected URL : " + expectedUrl);
        System.out.println("Actual URL : " + actualUrl);

        Assert.assertEquals(actualUrl, expectedUrl,
                "Wishlist link is not clickable.");

        System.out.println("Wishlist Link Verification Successful");
        System.out.println();

    }
    
}


