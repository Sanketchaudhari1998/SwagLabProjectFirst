package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Step_Two_Page extends TestBase
{
	// Object Repository
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogoTitle;
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement quantityLabel;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionLabel;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath = "//div[@data-test='payment-info-label']") private WebElement paymentInfoLabel;
	@FindBy(xpath = "//div[@data-test='payment-info-value']") private WebElement paymentInfoValue;
	@FindBy(xpath = "//div[@data-test='shipping-info-label']") private WebElement shippingInfoLabel;
	@FindBy(xpath = "//div[@data-test='shipping-info-value']") private WebElement shippingInfoValue;
	@FindBy(xpath = "//div[@data-test='total-info-label']") private WebElement totalInfoLabel;
	@FindBy(xpath = "//div[@data-test='subtotal-label']") private WebElement subTotal;
	@FindBy(xpath = "//div[@data-test='tax-label']") private WebElement tax;
	@FindBy(xpath = "//div[@data-test='total-label']") private WebElement total;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	
	
	// Calling
	public Checkout_Step_Two_Page()
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
    
    public String verifyprodQuantityLabel()
    {
		return quantityLabel.getText();
    	
    }
    
    public String verifyProdDescriptionLabel()
    {
		return descriptionLabel.getText();
    	
    }
    
    public String clickOnCancelBtn()
    {
    	cancelBtn.click();
		return driver.getCurrentUrl();
    	
    }
    
    public String clickOnFinishBtn()
    {
    	finishBtn.click();
		return driver.getCurrentUrl();
    	
    }
    
    public String verifyPaymentInfoLabel()
    {
		return paymentInfoLabel.getText();
    	
    }
    
    public String verifyPaymentInfoValue()
    {
		return paymentInfoValue.getText();
    	
    }
    
    public String verifyShippingInfoLabel()
    {
		return shippingInfoLabel.getText();
    	
    }
    
    public String verifyShippingInfoValue()
    {
		return shippingInfoValue.getText();
    	
    }
    
    public String verifyTotalInfoLabel()
    {
		return totalInfoLabel.getText();
    	
    }
    
    public String verifySubTotal()
    {
		return subTotal.getText();
    	
    }
    
    public String verifyTax()
    {
		return tax.getText();
    	
    }
    
    public String verifyTotal()
    {
		return total.getText();
    	
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
