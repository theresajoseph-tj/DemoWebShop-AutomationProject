package PagePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtocartPage {
	// BOOKS
    
    @FindBy(linkText = "Books")
    WebElement books;
    @FindBy(linkText = "Computing and Internet")
    WebElement computingInternet;
    @FindBy(id = "add-to-cart-button-13")
    WebElement addBookToCart;
    
    // COMPUTERS
    @FindBy(linkText = "Computers")
    WebElement computers;
    @FindBy(linkText = "Desktops")
    WebElement desktops;
    @FindBy(linkText = "Build your own cheap computer")
    WebElement cheapComputer;
    @FindBy(id = "add-to-cart-button-72")
    WebElement addComputerToCart;
    
    // APPAREL & SHOES
     @FindBy(linkText = "Apparel & Shoes")
    WebElement apparel;
    @FindBy(linkText = "Blue Jeans")
    WebElement blueJeans;
    @FindBy(id = "add-to-cart-button-36")
    WebElement addBlueJeansToCart;

    // DIGITAL DOWNLOADS
    @FindBy(linkText = "Digital downloads")
    WebElement digitalDownloads;
    @FindBy(linkText = "3rd Album")
    WebElement thirdAlbum;
    @FindBy(id = "add-to-cart-button-53")
    WebElement addThirdAlbumToCart;

    // SHOPPING CART
    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCart;
    
    // Quantity TEXTBOX (Computing and Internet)
     @FindBy(xpath = "//tr[.//*[normalize-space()='Computing and Internet']]//input[contains(@name,'itemquantity')]")
    WebElement quantityTextbox;
     
     // Remove CHECKBOX (Blue Jeans)
     @FindBy(xpath = "//td[@class='product']//a[normalize-space()='Blue Jeans']/ancestor::tr//input[@name='removefromcart']")
     WebElement removeBlueJeans;
     
     // Remove all items from cart checkbox (remove)
     @FindBy(name = "removefromcart")
     List<WebElement> removeCheckboxes;
     
     // Home logo
     @FindBy(xpath = "//div[@class='header-logo']/a/img")
     WebElement homeLogo;
     
     // Update Shopping Cart Button
     @FindBy(name = "updatecart")
     WebElement updateShoppingCart;
     
     // Total Price
     @FindBy(xpath = "//span[@class='product-price order-total']/strong")
     WebElement totalPrice;

     // Shopping Cart Heading
     @FindBy(xpath = "//h1[normalize-space()='Shopping cart']")
     WebElement shoppingCartHeading;
     
     // TERMS
     @FindBy(id = "termsofservice")
     WebElement termsCheckbox;

     // CHECKOUT BUTTON
     @FindBy(id = "checkout")
     WebElement checkoutButton;
     
     // CHECKOUT PAGE HEADING
     @FindBy(xpath="//h1[normalize-space()='Checkout']")
     WebElement checkoutHeading;
    
     //LOGIN
     @FindBy(linkText = "Log in")
 	WebElement loginLink;
    @FindBy(id = "Email")
 	WebElement email;
    @FindBy(id = "Password")
 	WebElement password;
    @FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
     
	WebDriver driver;
	public AddtocartPage(WebDriver driver) 
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
		
	}
	
	
	 // METHODS

    public void addBook()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Books"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Computing and Internet"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("add-to-cart-button-13"))).click();
    }


    public void addComputer()
    {
        computers.click();
        desktops.click();
        cheapComputer.click();
        addComputerToCart.click();
    }

    public void addBlueJeans()
    {
        apparel.click();
        blueJeans.click();
        addBlueJeansToCart.click();
    }

    public void addThirdAlbum()
    {
        digitalDownloads.click();
        thirdAlbum.click();
        addThirdAlbumToCart.click();
    }

    public void clickShoppingCart()
    {
        shoppingCart.click();
    }
    
    // UPDATE QUANTITY
    public void updateQuantity() {
        quantityTextbox.clear();
        quantityTextbox.sendKeys("2");
    }
    
    // REMOVE BLUE JEANS
    public void removeBlueJeans() {
        removeBlueJeans.click();
    }
    
    // Update Shopping Cart
    public void clickUpdateShoppingCart() {
        updateShoppingCart.click();
    }
    
    // Get Updated Quantity
    public String getQuantity() {
        return quantityTextbox.getAttribute("value");
    }
    
    // Get Total Price
    public String getTotalPrice() {
        return totalPrice.getText();
    }
    
    // CLICK TERMS
    public void clickTermsAndConditions()
    {
        termsCheckbox.click();
    }

    // CLICK CHECKOUT
    public void clickCheckout()
    {
        checkoutButton.click();
    }
    
    //get checkout page heading
    public String getCheckoutHeading()
    {
        return checkoutHeading.getText();
    }
    
    // LOGIN
    public void clickLogin() {

		loginLink.click();
	}
     public void login(String userEmail, String userPassword) {

	    email.clear();
	    email.sendKeys(userEmail);

	    password.clear();
	    password.sendKeys(userPassword);

	    loginButton.click();
	}
     //REMOVE FROM CART
     public void clearCart() throws InterruptedException
     {
         if (!removeCheckboxes.isEmpty())
         {
             for (WebElement checkbox : removeCheckboxes)
             {
                 checkbox.click();
             }
         Thread.sleep(4000);      
         updateShoppingCart.click();
         }
     }
     
     // HOME logo
     
     public void clickHomeLogo()
     {
         homeLogo.click();
     }

    
}
