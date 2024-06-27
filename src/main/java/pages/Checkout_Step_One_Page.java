package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Step_One_Page extends TestBase
{
	// Object Repository
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoTitle;
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCode;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	
	// Calling
	public Checkout_Step_One_Page()
	{
		PageFactory.initElements(driver, this);
	}

	// Methods
	public String verifyPageTitle()
    {
		return pageTitle.getText();
    	
    }
    
    public String verifyAppLogoTitle()
    {
		return appLogoTitle.getText();
    	
    }
    
    public boolean verifyMenuBtn()
    {
		return menuBtn.isDisplayed();
    	
    }
    
    public String inputInformation()
    {
    	firstNameTxtBox.sendKeys("Harry");
    	lastNameTxtBox.sendKeys("Potter");
    	postalCode.sendKeys("425502");
    	continueBtn.click();
		return driver.getCurrentUrl();
    	
    }
    
    public String clickOnCancelBtn()
    {
    	cancelBtn.click();
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
