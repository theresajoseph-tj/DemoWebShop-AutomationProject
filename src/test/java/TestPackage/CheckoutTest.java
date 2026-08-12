package TestPackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.AddtocartPage;
import PagePackage.CheckoutPage;

public class CheckoutTest extends BaseClass {
	
	CheckoutPage cp;
	AddtocartPage cart;
	
	@BeforeMethod
	public void checkoutpagesetup()
	{

        cart = new AddtocartPage(driver);
        
        driver.manage().deleteAllCookies();
        
        // Open Home Page
        driver.get("https://demowebshop.tricentis.com/");

        // Login
        cart.clickLogin();

        cart.login(
                "thek1312@gmail.com",
                "thek1312"
        );

        // Add products to cart
        cart.addBook();
        cart.addComputer();
        cart.addBlueJeans();
        cart.addThirdAlbum();

        // Open Shopping Cart
        cart.clickShoppingCart();

        // Proceed to Checkout
        cart.clickTermsAndConditions();
        cart.clickCheckout();

        // Create Checkout Page object
        cp = new CheckoutPage(driver);
    }
	
	@Test(priority = 1)
	public void verifyBillingAddress() 
	{
		cp.selectNewAddress();
		cp.enterBillingAddress(
			    "Theresa",
			    "Joseph",
			    "theresa123@gmail.com",
			    "India",
			    "Muvattupuzha",
			    "Thekkekunnel House",
			    "686661",
			    "9876543210");
		cp.clickContinue();
		cp.clickShippingAddressContinue();
		cp.selectGroundShipping();
		cp.clickShippingMethodContinue();
		cp.selectCashOnDelivery();
		cp.clickPaymentMethodContinue();
		cp.clickPaymentconfirmation();
		cp.clickConfirmOrder();
		cp.clickFinalContinue();
		
		
		
}
}