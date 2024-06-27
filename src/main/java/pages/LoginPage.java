package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//Object Repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApplication() throws IOException
	{
		logger = report.createTest("Login to Sauce Lab Application");
		userTextBox.sendKeys(ReadData.readPropertyFile("Username"));
		logger.log(Status.INFO, "UserName is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login is successfull");
		return driver.getCurrentUrl();
	}
	
	public String verifyMultiCredentials(String un, String password)
	{
		userTextBox.sendKeys(un);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
		
	}
	
	public String verifyTitleofApplication()
	{
		return driver.getTitle();
		
	}

}// logic
