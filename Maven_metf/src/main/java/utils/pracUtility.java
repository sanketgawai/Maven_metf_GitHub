package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class pracUtility {
	static WebDriver driver;

	public static void captureScreenShot(WebDriver driver,String TestID) throws IOException
	{
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		
		String display = dateFormat.format(date);
		
		String arr [] = display.split(display);
		String datePrint = arr[0];
		String timePrint = arr[1];
		
		File dest = new File("G:\\softwere testing\\automation\\others in atomation\\"
				+TestID+"((dd-mm-yyyy))"
				+datePrint+"Time(hr-min-sec)"
				+timePrint+").png");
		FileHandler.copy(src, dest);
	}
	
	
	
	
	
	
	
	
	
	public static String getDatafromExcel(String sheetname,int row,int column) throws FileNotFoundException {
		String data;
		
		String path = "G:\\softwere testing\\automation\\xcel data\\Book 1.xlsx";
		FileInputStream file = new FileInputStream(path);
		data = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		
		
	}
	
	
	
	
}
