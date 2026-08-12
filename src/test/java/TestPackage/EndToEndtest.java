package TestPackage;
import PagePackage.RegisterPage;
import PagePackage.LoginPage;
import PagePackage.productpage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagePackage.AddtocartPage;
import PagePackage.CheckoutPage;
import PagePackage.Logoutpage;


public class EndToEndtest extends BaseClass{

	RegisterPage rp;
    LoginPage lp;
    productpage pp;
    AddtocartPage cp;
    CheckoutPage checkout;
    Logoutpage logoutPage;

    @Test
    public void verifyCompleteEndToEndFlow() throws InterruptedException {

        // =====================================================
        // 1. REGISTRATION
        // =====================================================

        System.out.println("========== REGISTRATION ==========");

        rp = new RegisterPage(driver);

        rp.clickRegister();

        String email =
                "mariumthomas"
                + System.currentTimeMillis()
                + "@gmail.com";

        String password = "mariumthomas854";

        rp.registerUser(
                "Marium",
                "Thomas",
                email,
                password,
                password
        );

        String actualMessage = rp.getsuccessmessage();
        String expectedMessage = "Your registration completed";

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Registration Failed"
        );

        System.out.println("Registration Successful");
        System.out.println("Registered Email: " + email);
        System.out.println();

        // Logout after registration
        rp.logout();

        System.out.println("User Logged Out After Registration");
        System.out.println();


        // =====================================================
        // 2. LOGIN WITH SAME REGISTERED USER
        // =====================================================

        System.out.println("========== LOGIN ==========");

        lp = new LoginPage(driver);

        lp.clickLogin();

        // Same email and password used during registration
        lp.login(email, password);

        Assert.assertTrue(
                lp.isLogoutDisplayed(),
                "Login Failed"
        );

        System.out.println(
                "Login Successful with Registered User"
        );
        System.out.println();

    

    // =====================================================
    // 3. PRODUCT MODULE
    // =====================================================

    System.out.println("========== PRODUCT MODULE ==========");

    pp = new productpage(driver);

    pp.clickBooks();

    pp.clickComputingInternet();

    Assert.assertTrue(
            pp.isProductNameDisplayed(),
            "Product Name is not displayed"
    );

    Assert.assertTrue(
            pp.isProductImageDisplayed(),
            "Product Image is not displayed"
    );

    Assert.assertTrue(
            pp.isProductPriceDisplayed(),
            "Product Price is not displayed"
    );

    Assert.assertTrue(
            pp.isProductDescriptionDisplayed(),
            "Product Description is not displayed"
    );

    System.out.println(
            "Computing and Internet Product Verified Successfully"
    );
    System.out.println();


    // =====================================================
    // 4. ADD TO CART
    // =====================================================

    System.out.println("========== ADD TO CART ==========");

    cp = new AddtocartPage(driver);

    cp.addBook();

    cp.clickShoppingCart();

    System.out.println(
            "Product Added to Shopping Cart Successfully"
    );

    Thread.sleep(2000);
    System.out.println();

    // =====================================================
    // 5. CHECKOUT
    // =====================================================

    System.out.println("========== CHECKOUT ==========");

    cp.clickTermsAndConditions();

    cp.clickCheckout();

    Assert.assertEquals(
            cp.getCheckoutHeading(),
            "Checkout",
            "Checkout Page is not displayed"
    );

    System.out.println(
            "Checkout Page Opened Successfully"
    );
    System.out.println();
    
    
    // =====================================================
    // 6. BILLING ADDRESS
    // =====================================================

    checkout = new CheckoutPage(driver);

    //checkout.selectNewAddress();

    checkout.enterBillingAddress(
            "Theresa",
            "Joseph",
            "theresa123@gmail.com",
            "India",
            "Muvattupuzha",
            "Thekkekunnel House",
            "686661",
            "9876543210"
    );

    checkout.clickContinue();

    System.out.println(
            "Billing Address Completed Successfully"
    );
    // =====================================================
    // 7. SHIPPING ADDRESS
    // =====================================================

    checkout.clickShippingAddressContinue();

    System.out.println(
            "Shipping Address Completed Successfully"
    );
    

    
    // =====================================================
    // 8. SHIPPING METHOD
    // =====================================================

    checkout.selectGroundShipping();

    checkout.clickShippingMethodContinue();

    System.out.println(
            "Ground Shipping Selected Successfully"
    );  
    
    

    // =====================================================
    // 9. PAYMENT METHOD
    // =====================================================

    checkout.selectCashOnDelivery();

    checkout.clickPaymentMethodContinue();

    System.out.println(
            "Cash on Delivery Selected Successfully"
    );


    // =====================================================
    // 10. PAYMENT INFORMATION
    // =====================================================

    checkout.clickPaymentconfirmation();

    System.out.println(
            "Payment Information Completed Successfully"
    ); 
    
    
    

    // =====================================================
    // 11. CONFIRM ORDER
    // =====================================================

    checkout.clickConfirmOrder();

    System.out.println(
            "Order Confirmed Successfully"
    );


    // =====================================================
    // 12. ORDER COMPLETION
    // =====================================================

    checkout.clickFinalContinue();

    System.out.println(
            "Order Completed Successfully"
    );
    System.out.println();
    
    

    // =====================================================
    // 13. LOGOUT
    // =====================================================

    System.out.println("========== LOGOUT ==========");

    logoutPage = new Logoutpage(driver);

    logoutPage.clicklogout();

    Assert.assertTrue(
            logoutPage.isloginlinkisdisplayed(),
            "Login link is not displayed after Logout"
    );

    System.out.println(
            "User Logged Out Successfully"
    );

    System.out.println(
            "Login Link Displayed Successfully After Logout"
    );

    System.out.println();
    System.out.println(
            "========== END-TO-END TEST COMPLETED SUCCESSFULLY =========="
    );
}
}