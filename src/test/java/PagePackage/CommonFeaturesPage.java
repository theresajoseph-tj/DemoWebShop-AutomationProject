package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonFeaturesPage {

	@FindBy(className = "header-logo")
	WebElement logo;
	@FindBy(xpath ="//div[@class='header-menu']//a[@href='/books']")
	WebElement books;
	@FindBy(linkText = "Register")
	WebElement register;
	@FindBy(linkText = "Log in")
	WebElement login;
	@FindBy(id = "small-searchterms")
	WebElement Searchbox;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement Searchbutton;
	
	@FindBy(xpath = "//div[@class='header-menu']//a[@href='/books']")
	WebElement booksnav;
	@FindBy(xpath = "//div[@class='header-menu']//a[@href='/computers']")
	WebElement computers;
    @FindBy(xpath = "//div[@class='header-menu']//a[@href='/electronics']")
	WebElement electronics;
    @FindBy(xpath = "//div[@class='header-menu']//a[@href='/apparel-shoes']")
	WebElement apparelShoes;
    @FindBy(xpath = "//div[@class='header-menu']//a[@href='/digital-downloads']")
	WebElement digitalDownloads;
    @FindBy(xpath = "//div[@class='header-menu']//a[@href='/jewelry']")
	WebElement jewelry;
    @FindBy(xpath = "//div[@class='header-menu']//a[@href='/gift-cards']")
	WebElement giftCards;
	@FindBy(linkText = "Shopping cart")
	WebElement Shoopingcart;
	@FindBy(linkText = "Wishlist")
	WebElement wishlist;
	
	WebDriver driver;
	
	public CommonFeaturesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	public boolean islogodisplayed()
	{
		return logo.isDisplayed();
	}
	
	public void clickbooks()
	{
		books.click();
	}
	public void clicklogo()
	{
		logo.click();
	}
	
	public boolean isregisterdisplayed()
	{
		return register.isDisplayed();
	}
	
	public void clickregister()
	{
		register.click();
	}
	public boolean islogindisplayed()
	{
		return login.isDisplayed();
	}
	
	public void clicklogin()
	{
		login.click();
	}
	
	public void entersearchproduct(String Product)
	{
		Searchbox.clear();
		Searchbox.sendKeys(Product);
	}
	
	public void clickserachbutton()
	{
		Searchbutton.click();
	}
	
  public boolean isbookdisplayed()
	{
		return booksnav.isDisplayed();
	}
	
	public boolean isComputersDisplayed() {
	    return computers.isDisplayed();
	}

	public boolean isElectronicsDisplayed() {
	    return electronics.isDisplayed();
	}

	public boolean isApparelShoesDisplayed() {
	    return apparelShoes.isDisplayed();
	}

	public boolean isDigitalDownloadsDisplayed() {
	    return digitalDownloads.isDisplayed();
	}

	public boolean isJewelryDisplayed() {
	    return jewelry.isDisplayed();
	}

	public boolean isGiftCardsDisplayed() {
	    return giftCards.isDisplayed();
	}
	public void clickbooksnavi()
	{
		booksnav.click();
	}
	
	public void clickingShoppingCart()
	{
		Shoopingcart.click();
	}
	public void clickWishlist() {

	    wishlist.click();

	}
}
