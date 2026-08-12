package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.AddtocartPage;

public class AddtocartTest extends BaseClass
{
	 AddtocartPage cp;

	    @BeforeMethod
	    public void setupCartPage() throws InterruptedException
	    {
	    	 driver.manage().deleteAllCookies();

	    	    driver.get("https://demowebshop.tricentis.com/");

	    	    cp = new AddtocartPage(driver);

	    	    cp.clickLogin();

	    	    cp.login(
	    	        "thek1312@gmail.com",
	    	        "thek1312"
	    	        );
	    	    cp.clickShoppingCart();

	    	    cp.clearCart();

	    	    cp.clickHomeLogo();
	    }
	    
//	    @Test(priority = 1)
//		public void verifyLoginFunctionality() throws InterruptedException {
//
//		    System.out.println("Verify Login Functionality");
//		    cp.clickLogin();
//            cp.login(
//		            "thek1312@gmail.com",
//		            "thek1312");
//         // Open Shopping Cart
//            cp.clickShoppingCart();
//         // Clear Cart
//            cp.clearCart();
//         // Redirect to homepage
//            cp.clickHomeLogo();
//	    }
//		    //FUNCTIONAL TESTING
	    @Test(priority = 1)
	    public void verifyAddProductsToCart() throws InterruptedException
	    {
	        System.out.println("Verifying Add Products to Shopping Cart...");

	        cp.addBook();
	        cp.addComputer();
	        cp.addBlueJeans();
	        cp.addThirdAlbum();
            cp.clickShoppingCart();
	        
            System.out.println("Shopping Cart opened successfully.");
            Thread.sleep(5000);
            System.out.println();
	    
}
	    
	    @Test(priority = 2)
	    public void verifyUpdateShoppingCart() {


	        System.out.println("Verifying Update Shopping Cart...");

	        cp.addBook();
	        cp.addComputer();
	        cp.addBlueJeans();
	        cp.addThirdAlbum();

	        cp.clickShoppingCart();

	        cp.updateQuantity();

	        cp.removeBlueJeans();

	        cp.clickUpdateShoppingCart();

	        Assert.assertEquals(cp.getQuantity(), "2");

	        Assert.assertNotNull(cp.getTotalPrice());

	        System.out.println("Shopping Cart Updated Successfully");
}
	    
	    
	    @Test(priority = 3)
	    public void verifyCheckout()
	    {
	    	 System.out.println("Verifying Checkout...");

	    	    cp.addBook();
	    	    cp.addComputer();
	    	    cp.addBlueJeans();
	    	    cp.addThirdAlbum();

	    	    cp.clickShoppingCart();

	    	    cp.clickTermsAndConditions();

	    	    cp.clickCheckout();

	    	    Assert.assertEquals(cp.getCheckoutHeading(), "Checkout");

	    	    System.out.println("Checkout Page Opened Successfully");
}
}