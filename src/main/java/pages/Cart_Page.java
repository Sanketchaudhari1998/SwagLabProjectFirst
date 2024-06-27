package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	// Object Repository
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoTitle;
	@FindBy(xpath = "//span[@class='title']") private WebElement cartPageTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement quantityLabel;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionLabel;
	@FindBy(xpath = "//button[@name='continue-shopping']") private WebElement continueShoppingBtn;
	@FindBy(xpath = "//button[@name='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	
	// Calling
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	
	public String verifyPageTitle()
    {
		return cartPageTitle.getText();
    	
    }
    
    public String verifyAppLogoTitle()
    {
		return appLogoTitle.getText();
    	
    }
    
    public boolean verifyMenuBtn()
    {
		return menuBtn.isDisplayed();
    	
    }
    
    public String verifyprodQuantityLabel()
    {
		return quantityLabel.getText();
    	
    }
    
    public String verifyProdDescriptionLabel()
    {
		return descriptionLabel.getText();
    	
    }
    
    public String verifyContinueShoppingBtn()
    {
    	continueShoppingBtn.click();
		return driver.getCurrentUrl();
    }
    
    public String verifyCheckoutBtn()
    {
    	checkoutBtn.click();
		return driver.getCurrentUrl();
    	
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
    
    public String verifyFooterText()
    {
		return footerText.getText();
    	
    }
	

}
