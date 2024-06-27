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
import pages.Checkout_Step_Two_Page;
import pages.Complete_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshotcode;

public class Complete_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	Checkout_Step_One_Page check1;
	Checkout_Step_Two_Page check2;
	Complete_Page complete;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new Checkout_Step_One_Page();
		check2 = new Checkout_Step_Two_Page();
		complete = new Complete_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.enterToCart();
		cart.verifyCheckoutBtn();
		check1.inputInformation();
		check2.clickOnFinishBtn();
	}
	
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle= "Checkout: Complete!";
		String actTitle= complete.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Complete page title is = " + actTitle);
	}
	@Test
	public void verifyAppLogoTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle= complete.verifyAppLogoTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Complete page logo title is = " + actTitle);
	}
	@Test
	public void verifyMenuBtnTest()
	{
		boolean result = complete.verifyMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Menu button on Complete page isDisplay = " + result);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = complete.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " + result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean resultFacebook = complete.verifyFacebookLogo();
		Assert.assertEquals(resultFacebook, true);
		Reporter.log("Facebook logo is present = " + resultFacebook);
	}
    @Test
    public void verifyLinkedinLogotest()
    {
    	boolean resultLinkedin = complete.verifyLinkedinLogo();
    	Assert.assertEquals(resultLinkedin, true);
    	Reporter.log("Linkedin logo is present = " + resultLinkedin);
    }
	@Test
	public void verifyFooterTextTest()
	{
		String expFooterTxt = "© " + "2024" + " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooterTxt = complete.verifyFooterText();
		Assert.assertEquals(expFooterTxt, actFooterTxt);
		Reporter.log("Footer text is = " + actFooterTxt);
	}
	@Test
	public void clickOnCartIconTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL= complete.clickOnCartIcon();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After click on cart btn url is = " + actURL);
	}
	@Test
	public void verifyCompleteImgTest()
	{
		boolean result = complete.verifyCompleteImg();
		Assert.assertEquals(result, true);
		Reporter.log("Complete img is present = " + result);
		
	}
	@Test
	public void verifyThankYouHeadingTest()
	{
		String exp="Thank you for your order!";
		String act= complete.verifyThankYouHeading();
		Assert.assertEquals(exp, act);
		Reporter.log("Complete page thank you heading = " + act);
	}
	@Test
	public void verifyCompleteTextTest()
	{
		String exp="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String act= complete.verifyCompleteText();
		Assert.assertEquals(exp, act);
		Reporter.log("Complete page text is = " + act);
	}
	@Test
	public void verifyBackHomeBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= complete.verifyBackHomeBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After click on backHome btn url is = " + actURL);
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
