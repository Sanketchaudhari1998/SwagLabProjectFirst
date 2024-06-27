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
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshotcode;

public class LoginPage_Test extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	@Test
	public void loginToApplicationTest() throws IOException
	{
		String expURL = ReadData.readExcel(0, 0);//https://www.saucedemo.com/inventory.html(0,0)
		String actURL = login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
		
	}
	@Test
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL =ReadData.readExcel(0, 1); //https://www.saucedemo.com/ (0,1)
		String actURL = login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Swad lab is = " + actURL);
	}
	
	@Test
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle =ReadData.readExcel(0,2);//Swag Labs (0,2)
		String actTitle = login.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshotcode.captureScreenshot(it.getName());
		}
		report.flush();
		driver.close();
	}

}// testCases
