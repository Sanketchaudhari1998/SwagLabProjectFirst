package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Checkout_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshotcode;

public class Checkout_Step_One_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	Checkout_Step_One_Page check1;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new Checkout_Step_One_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.enterToCart();
		cart.verifyCheckoutBtn();
	}
	
	@Test
	public void inputInformationTest()
	{
		String expUrl= "https://www.saucedemo.com/checkout-step-two.html";
		String actUrl= check1.inputInformation();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Checkout page 2 Url is = " + actUrl);
	}
	@Test
	public void clickOnCancelBtnTest()
	{
		String expUrl= "https://www.saucedemo.com/cart.html";
		String actUrl= check1.clickOnCancelBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("After clicking on cancel button Url is = " + actUrl);
	}
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle= "Checkout: Your Information";
		String actTitle= check1.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout step one page title is = " + actTitle);
	}
	@Test
	public void verifyAppLogoTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle= check1.verifyAppLogoTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout step one page logo title is = " + actTitle);
	}
	@Test
	public void verifyMenuBtnTest()
	{
		boolean result = check1.verifyMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Menu button on checkout step one page isDisplay = " + result);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = check1.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " + result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean resultFacebook = check1.verifyFacebookLogo();
		Assert.assertEquals(resultFacebook, true);
		Reporter.log("Facebook logo is present = " + resultFacebook);
	}
    @Test
    public void verifyLinkedinLogotest()
    {
    	boolean resultLinkedin = check1.verifyLinkedinLogo();
    	Assert.assertEquals(resultLinkedin, true);
    	Reporter.log("Linkedin logo is present = " + resultLinkedin);
    }
	@Test
	public void verifyFooterTextTest()
	{
		String expFooterTxt = "© " + "2024" + " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooterTxt = check1.verifyFooterText();
		Assert.assertEquals(expFooterTxt, actFooterTxt);
		Reporter.log("Footer text is = " + actFooterTxt);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshotcode.captureScreenshot(it.getName());
		}
		driver.close();
	}

}
