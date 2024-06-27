package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Page extends TestBase
{
	//Object Repository
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoTitle;
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//img[@alt='Pony Express']") private WebElement completeImg;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement thankYouHeading;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement completeText;
	@FindBy(xpath = "//button[@name='back-to-products']") private WebElement backHomeBtn;
	
	//Calling
	public Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
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
    
    public String clickOnCartIcon()
	{
		cartIcon.click();
		return driver.getCurrentUrl();
		
	}
    
    public boolean verifyCompleteImg()
    {
    	boolean result = completeImg.isDisplayed();
		return result;
    	
    }
    
    public String verifyThankYouHeading()
    {
    	return thankYouHeading.getText();
    }
    
    public String verifyCompleteText()
    {
		return completeText.getText();
    	
    }
    
    public String verifyBackHomeBtn()
    {
    	backHomeBtn.click();
		return driver.getCurrentUrl();
    	
    }

}
