package PagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	@FindBy(id="billing-address-select")
	WebElement billingAddress;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement email;
	
    @FindBy(id="BillingNewAddress_CountryId")
	WebElement country;
    
    @FindBy(id="BillingNewAddress_City")
	WebElement city;

    @FindBy(id="BillingNewAddress_Address1")
	WebElement address1;

    @FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
    
    @FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;

	@FindBy(xpath="//input[@onclick='Billing.save()']")
	WebElement continueBtn;
    
	@FindBy(css="#shipping-buttons-container input.new-address-next-step-button")
	WebElement shippingadressscontinue;
	
	@FindBy(id="shippingoption_0")
	WebElement groundShipping;
	
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	WebElement shippingMethodContinue;

	@FindBy(id="paymentmethod_0")
	WebElement cashOnDelivery;
	
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	WebElement paymentMethodContinue;
	
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
	WebElement paymentconfcontinue;
	
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement finalContinue;
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Select New Address
	public void selectNewAddress() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement billingAddressElement = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.id("billing-address-select")
		        )
		    );
		    Select s = new Select(billingAddressElement);
		s.selectByVisibleText("New Address");
	}
	
	// Fill Billing Address
	
	public void enterBillingAddress(String fn,
            String ln,
            String emailId,
            String countryName,
            String cityName,
            String address,
            String zip,
            String phone)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(firstName));
	    
		firstName.clear();
	    firstName.sendKeys(fn);

	    lastName.clear();
	    lastName.sendKeys(ln);

	    email.clear();
	    email.sendKeys(emailId);
	    
	    Select s = new Select(country);
	    s.selectByVisibleText(countryName);

	    city.clear();
	    city.sendKeys(cityName);

	    address1.clear();
	    address1.sendKeys(address);
		
	    zipCode.clear();
	    zipCode.sendKeys(zip);

	    phoneNumber.clear();
	    phoneNumber.sendKeys(phone);
	    
		}	
	public void clickContinue() {
		continueBtn.click();
	}
	
	public void clickShippingAddressContinue() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable( shippingadressscontinue));
	    shippingadressscontinue.click();
	}
	
	public void selectGroundShipping() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.elementToBeClickable(groundShipping));
    groundShipping.click();
	}
	public void clickShippingMethodContinue() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinue));
	    shippingMethodContinue.click();
	}
	public void selectCashOnDelivery() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(cashOnDelivery));
	    cashOnDelivery.click();
	}
	public void clickPaymentMethodContinue() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinue));
	    paymentMethodContinue.click();
	}
	
	public void clickPaymentconfirmation() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable( paymentconfcontinue));
		    paymentconfcontinue.click();
	}
	
	public void clickConfirmOrder() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
	    confirmOrder.click();
	}
	
	public void clickFinalContinue() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(finalContinue));
	    finalContinue.click();
	}
	}

