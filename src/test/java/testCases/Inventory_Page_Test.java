package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshotcode;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		login.loginToApplication();
	}
	
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " + result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean resultFacebook = invent.verifyFacebookLogo();
		Assert.assertEquals(resultFacebook, true);
		Reporter.log("Facebook logo is present = " + resultFacebook);
	}
    @Test
    public void verifyLinkedinLogotest()
    {
    	boolean resultLinkedin = invent.verifyLinkedinLogo();
    	Assert.assertEquals(resultLinkedin, true);
    	Reporter.log("Linkedin logo is present = " + resultLinkedin);
    }
	@Test
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 3); // 6 (0,3)
		String actCount= invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products added to cart = " + actCount);
	}
	@Test
	public void removeProductTest() throws EncryptedDocumentException, IOException
	{
		String epxCount=ReadData.readExcel(0,4);// 4 (0,4)
		String actCount= invent.removeProduct();
		Assert.assertEquals(epxCount, actCount);
		Reporter.log("Total products after remove to the cart " + actCount);
	}
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle =ReadData.readExcel(0,5); // Products (0,5)
		String actTitle = invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Inventory page Title = "+actTitle);
	}
	@Test
	public void verifyAppLogoTitleTest()
	{
		String expAppLogoTitle="Swag Labs";
		String actAppLogoTitle= invent.verifyAppLogoTitle();
		Assert.assertEquals(expAppLogoTitle, actAppLogoTitle);
		Reporter.log("App logo Title is = " + actAppLogoTitle);
	}
	@Test
	public void verifyMenuBtnTest()
	{
		boolean resultMenuBtn = invent.verifyMenuBtn();
		Assert.assertEquals(resultMenuBtn, true);
		Reporter.log("Menu button is present = " + resultMenuBtn);
	}
	@Test
	public void verifyFooterTextTest()
	{
		String expFooterTxt = "© " + "2024" + " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooterTxt = invent.verifyFooterText();
		Assert.assertEquals(expFooterTxt, actFooterTxt);
		Reporter.log("Footer text is = " + actFooterTxt);
	}
	@Test
	public void enterToCartTest()
	{
		String expURL= "https://www.saucedemo.com/cart.html";
		String actURL= invent.enterToCart();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart page URL = " + actURL);
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
