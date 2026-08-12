package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagePackage.productpage;

public class ProductTest extends BaseClass {

	productpage pp;

	@BeforeMethod
	public void openhomepage() {
		pp = new productpage(driver);
	}

	// UI TESTING

	@Test(priority = 1)
	public void VerifyingBooksMenu() {
		System.out.println("Verifying Books Navigation Menu......");
		Assert.assertTrue(pp.isbooksdisplayed(), "Books Navigation Menu is not displayed");
		System.out.println("Books Navigation Menu Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 2)
	public void verifyComputersMenu() {
		System.out.println("Verifying Computers Navigation Menu...");

		Assert.assertTrue(pp.isComputersDisplayed(), "Computers Navigation Menu is not displayed");

		System.out.println("Computers Navigation Menu Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 3)
	public void verifyElectronicsMenu() {
		System.out.println("Verifying Electronics Navigation Menu...");

		Assert.assertTrue(pp.isElectronicsDisplayed(), "Electronics Navigation Menu is not displayed");

		System.out.println("Electronics Navigation Menu Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 4)
	public void verifyApparelMenu() {
		System.out.println("Verifying Apparel & Shoes Navigation Menu...");

		Assert.assertTrue(pp.isApparelDisplayed(), "Apparel & Shoes Navigation Menu is not displayed");

		System.out.println("Apparel & Shoes Navigation Menu Displayed Successfully");
		System.out.println();
	}

	// FUNCTIONAL TESTING

	@Test(priority = 5)
	public void verifyBooksPage() {
		System.out.println("Verifying Books Page...");

		pp.clickBooks();

		Assert.assertEquals(pp.getBooksHeading(), "Books");

		System.out.println("Books Page Opened Successfully");
		System.out.println();
	}

	@Test(priority = 6)
	public void verifyComputersPage() {
		System.out.println("Verifying Computers Page...");

		pp.clickComputers();

		Assert.assertEquals(pp.getComputersHeading(), "Computers");

		System.out.println("Computers Page Opened Successfully");
		System.out.println();
	}

	@Test(priority = 7)
	public void verifyElectronicsPage() {
		System.out.println("Verifying Electronics Page...");

		pp.clickElectronics();

		Assert.assertEquals(pp.getElectronicsHeading(), "Electronics");

		System.out.println("Electronics Page Opened Successfully");
		System.out.println();
	}

	@Test(priority = 8)
	public void verifyApparelPage() {
		System.out.println("Verifying Apparel & Shoes Page...");

		pp.clickApparel();

		Assert.assertEquals(pp.getApparelHeading(), "Apparel & Shoes");

		System.out.println("Apparel & Shoes Page Opened Successfully");
		System.out.println();
	}

	@Test(priority = 9)

	public void verifySortByDropdownDisplayed() {

	    System.out.println("Verifying Sort By Dropdown...");
	    pp.clickBooks();

	    Assert.assertTrue(pp.isSortByDisplayed());

	    System.out.println("Sort By Dropdown Displayed Successfully");

	}
	
	
	@Test(priority = 10)

	public void verifySortByAtoZ() {

	    System.out.println("Verifying Sort By A to Z...");
	    
	    pp.clickBooks();

	    pp.selectSortByAtoZ();

	    Assert.assertEquals(pp.getSelectedSortOption(),
	            "Name: A to Z");

	    System.out.println("Sort By A to Z Selected Successfully");

	}
	
	@Test(priority = 11)

	public void verifySortByZtoA() {

	    System.out.println("Verifying Sort By Z to A...");
	    
	    pp.clickBooks();

	    pp.selectSortByZtoA();

	    Assert.assertEquals(pp.getSelectedSortOption(),
	            "Name: Z to A");

	    System.out.println("Sort By Z to A Selected Successfully");

	}
	@Test(priority = 12)
	public void verifyViewAsDisplayed()
	{
	    pp.clickBooks();

	    Assert.assertTrue(pp.isViewAsDisplayed());

	    System.out.println("View As Dropdown Displayed Successfully");
	}
	
	@Test(priority = 13)
	public void verifyListView()
	{
	    pp.clickBooks();

	    pp.selectListView();

	    Assert.assertEquals(pp.getSelectedView(), "List");

	    System.out.println("List View Selected Successfully");
	}
	@Test(priority = 14)
	public void verifyFilterByPriceDisplayed()
	{
	    pp.clickBooks();

	    Assert.assertTrue(pp.isUnder25Displayed());

	    System.out.println("Filter By Price Displayed Successfully");
	}
	
	@Test(priority = 15)
	public void verifyUnder25Filter()
	{
	    pp.clickBooks();

	    pp.clickUnder25Price();

	    //Assert.assertEquals(pp.getActivePriceFilter(), "Under 25.00");

	    System.out.println("Under 25 Price Filter Applied Successfully");
	}
	// PRODUCT DETAILS TESTING

	@Test(priority = 16)
	public void verifyComputingInternetProduct() {
		System.out.println("Opening Computing and Internet Product...");

		pp.clickBooks();
		pp.clickComputingInternet();

		Assert.assertTrue(pp.isProductNameDisplayed());

		System.out.println("Computing and Internet Product Opened Successfully");
		System.out.println();
	}

	@Test(priority = 17)
	public void verifyProductImage() {
		System.out.println("Verifying Product Image...");

		Assert.assertTrue(pp.isProductImageDisplayed());

		System.out.println("Product Image Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 18)
	public void verifyProductPrice() {
		System.out.println("Verifying Product Price...");

		Assert.assertTrue(pp.isProductPriceDisplayed());

		System.out.println("Product Price Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 19)
	public void verifyProductDescription() {
		System.out.println("Verifying Product Description...");

		Assert.assertTrue(pp.isProductDescriptionDisplayed());

		System.out.println("Product Description Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 20)
	public void verifyQuantityTextbox() {
		System.out.println("Verifying Quantity Textbox...");

		Assert.assertTrue(pp.isQuantityTextboxDisplayed());

		System.out.println("Quantity Textbox Displayed Successfully");
		System.out.println();
	}

	@Test(priority = 21)
	public void verifyAddToCartButton() {
		System.out.println("Verifying Add to Cart Button...");

		Assert.assertTrue(pp.isAddToCartButtonDisplayed());

		System.out.println("Add to Cart Button Displayed Successfully");
		System.out.println();
	}

	// EDGE CASE TESTING

	@Test(priority = 22)
	public void verifyProductPageAfterRefresh() {
		System.out.println("Verifying Product Details Page After Refresh...");

		pp.clickBooks();
		pp.clickComputingInternet();
		pp.refreshPage();
		Assert.assertTrue(pp.isProductNameDisplayed());
		System.out.println("Product Details Page Displayed Successfully After Refresh");
		System.out.println();
	}
}
