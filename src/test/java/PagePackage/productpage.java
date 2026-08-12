package PagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productpage {

	@FindBy(xpath = "//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='header-menu']/ul[@class='top-menu']/li[1]")
	WebElement books;

	@FindBy(xpath = "//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='header-menu']/ul[@class='top-menu']/li[2]")
	WebElement computers;
	

	@FindBy(xpath = "//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='header-menu']/ul[@class='top-menu']/li[3]")
	WebElement electronoics;
	
	@FindBy(xpath = "//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='header-menu']/ul[@class='top-menu']/li[4]")
	WebElement apparel;
	
	@FindBy(xpath = "//h1[normalize-space()='Books']")
	WebElement booksheading;
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
	WebElement computersHeading;;
	@FindBy(xpath = "//h1[normalize-space()='Electronics']")
	WebElement electronicsHeading;
	@FindBy(xpath = "//h1[normalize-space()='Apparel & Shoes']")
	WebElement apparelHeading;
	
	@FindBy(linkText = "Computing and Internet")
	WebElement computingInternet;
	
	// Product Details
    @FindBy(xpath = "//h1[@itemprop='name']")
	WebElement productName;
    
    @FindBy(xpath = "//img[@id='main-product-img-13']")
    WebElement productImage;
    
    @FindBy(xpath = "//span[@class='price-value-13']")
    WebElement productPrice;
    
    @FindBy(xpath = "//div[@class='short-description']")
    WebElement productDescription;
    
    @FindBy(xpath  = "//*[@id=\"addtocart_13_EnteredQuantity\"]")
    WebElement quantityTextbox;
    
    @FindBy(xpath  = "//*[@id=\"add-to-cart-button-13\"]")
    WebElement addToCartButton;
    
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortByDropdown;
    
    @FindBy(id = "products-viewmode")
    WebElement viewAsDropdown;
    
    @FindBy(xpath = "//li[1]//a[1]//span[1]")
    WebElement under25Price;
    
	WebDriver driver;
	public productpage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean isbooksdisplayed()
	{
		return books.isDisplayed();
	}
	  public boolean isComputersDisplayed()
	    {
	        return computers.isDisplayed();
	    }

	    public boolean isElectronicsDisplayed()
	    {
	        return  electronoics.isDisplayed();
	    }

	    public boolean isApparelDisplayed()
	    {
	        return apparel.isDisplayed();
	    }
	    
	    public void clickBooks()
	    {
	    	books.click();
	    }

	    public void clickComputers()
	    {
	    	computers.click();
	    }

	    public void clickElectronics()
	    {
	    	electronoics.click();
	    }

	    public void clickApparel()
	    {
	    	apparel.click();
	    }
	    public String getBooksHeading()
	    {
	        return booksheading.getText();
	    }

	    public String getComputersHeading()
	    {
	        return computersHeading.getText();
	    }

	    public String getElectronicsHeading()
	    {
	        return electronicsHeading.getText();
	    }

	    public String getApparelHeading()
	    {
	        return apparelHeading.getText();
	    }
	    
	 // Click Product

	    public void clickComputingInternet()
	    {
	        computingInternet.click();
	    }
	    
	 // Verification Methods

	    public boolean isProductNameDisplayed()
	    {
	        return productName.isDisplayed();
	    }
	    
	    public boolean isProductImageDisplayed()
	    {
	        return productImage.isDisplayed();
	    }
	    
	    public boolean isProductPriceDisplayed()
	    {
	        return productPrice.isDisplayed();
	    }
	    public boolean isProductDescriptionDisplayed()
	    {
	        return productDescription.isDisplayed();
	    }
	    public boolean isQuantityTextboxDisplayed()
	    {
	        return quantityTextbox.isDisplayed();
	    }
	    public boolean isAddToCartButtonDisplayed()
	    {
	        return addToCartButton.isDisplayed();
	    }
	    public void refreshPage()
	    {
	        driver.navigate().refresh();
	    }
	    
	    // functional testing
	    public boolean isSortByDisplayed() {
	        return sortByDropdown.isDisplayed();
	    }
	    // A TO Z ===> SORTING
	    public void selectSortByAtoZ() {

	        Select select = new Select(sortByDropdown);
	        select.selectByVisibleText("Name: A to Z");

	    }
	    public String getSelectedSortOption() {

	        Select select = new Select(sortByDropdown);
	        return select.getFirstSelectedOption().getText();

	    }
	    // Z TO A
	    public void selectSortByZtoA() {

	        Select select = new Select(sortByDropdown);
	        select.selectByVisibleText("Name: Z to A");

	    }
	    // LIST VIEW
	    public boolean isViewAsDisplayed()
	    {
	        return viewAsDropdown.isDisplayed();
	    }
	    public void selectListView()
	    {
	        Select select = new Select(viewAsDropdown);
	        select.selectByVisibleText("List");
	    }    
	    public String getSelectedView()
	    {
	        Select select = new Select(viewAsDropdown);
	        return select.getFirstSelectedOption().getText();
	    }
	    // PRIZE FILTER
	    
	    
	    public boolean isUnder25Displayed()
	    {
	        return under25Price.isDisplayed();
	    }
	    
	    public void clickUnder25Price()
	    {
	        under25Price.click();
	    }
//	    public String getActivePriceFilter()
//	    {
//	        return under25Price.getText();
//	    }
}
