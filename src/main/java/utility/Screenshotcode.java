package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshotcode extends TestBase
{
	//date
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		
	}
	
	//screenshot capture
	public static void captureScreenshot(String nameOfMethod) throws IOException
	{
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\csank\\eclipse-workspace\\Selenium_Framework_projectFirst\\Screenshot\\"+nameOfMethod+"--"+getDate()+".jpeg");
	FileHandler.copy(source, destination);
	}

}
