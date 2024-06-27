package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\csank\\eclipse-workspace\\Selenium_Framework_projectFirst\\src\\main\\java\\config\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);
		
	} //config.properties
	
	public static String readExcel(int rownum, int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\csank\\eclipse-workspace\\Selenium_Framework_projectFirst\\TestData\\Book1.xlsx");
		Sheet excelSheet1 = WorkbookFactory.create(file).getSheet("sheet1");
		String value = excelSheet1.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
	}

}
