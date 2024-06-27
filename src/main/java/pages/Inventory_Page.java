package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_Page extends TestBase
{
	//Object Repository
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement produstBackpackBtn;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productTshirtBtn;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacketBtn;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productOnsieShirtBtn;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productRedTshirt;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']") private WebElement removeProdBackpack;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-onesie']") private WebElement removeProdOnesie;
	@FindBy(xpath = "//span[@class='title']") private WebElement pagetitle;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	
	//calling
    public Inventory_Page()
    {
    	PageFactory.initElements(driver, this);  
    	
    }
    
	//methods
    public String verifyPageTitle()
    {
		return pagetitle.getText();
    	
    }
    
    public String verifyAppLogoTitle()
    {
		return appLogoTitle.getText();
    	
    }
    
    public boolean verifyMenuBtn()
    {
		return menuBtn.isDisplayed();
    	
    }
    
    public boolean verifyTwitterLogo()
    {
		return twitterLogo.isDisplayed();
    	
    }
    
    public boolean verifyFacebookLogo()
    {
		return facebookLogo.isDisplayed();
    	
    }
    
    public boolean verifyLinkedinLogo()
    {
		return linkedinLogo.isDisplayed();
    	
    }
    
    public String add6Products()
    {
    	HandleDropdownList.handleSelect(dropDown, "Price (low to high)");
    	produstBackpackBtn.click();
    	productBikeLight.click();
    	productJacketBtn.click();
    	productOnsieShirtBtn.click();
    	productRedTshirt.click();
    	productTshirtBtn.click();
		return cartCount.getText();
    }
    
    public String removeProduct()
    {
    	add6Products(); //calling add method
    	removeProdBackpack.click();
    	removeProdOnesie.click();
		return cartCount.getText();
    }
    
    public String verifyFooterText()
    {
		return footerText.getText();
    	
    }
    public String enterToCart()
	{
		cartIcon.click();
		return driver.getCurrentUrl();
		
	}
    
    

}
