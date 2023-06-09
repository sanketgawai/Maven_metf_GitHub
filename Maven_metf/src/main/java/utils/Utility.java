package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	//2 method
	//public static banani hai : ku ki pure proj me kahi p bhi 
	//call kar sake
	//1. screenshot
	//2. excel sheet
	static WebDriver driver ;
				//return				//argument	
public static void captureScreenShot(WebDriver driver,String TestID) throws IOException {
		
		//screenshot ka code impliment karenge , esa ki jabhi method ko 
		// call kiya Screenshot Capture hojana chahiye
		// and us Screenshot me test method ka name ana chahi  ye
		// mehtod name : Test - verifyPolicity(screenshot ka name also same)
		// us ke samne date & time hona chahi ye
		

		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		// import form javatext
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		//This line of code creates an instance of the Java class SimpleDateFormat and initializes it with the pattern "dd-MM-yyyy hh-mm-ss".
		
//Note		// import form javatext
		Date date = new Date();
//Note	//This line of code creates a new instance of the Java class Date and initializes it with the current date and time.
		//DATE import from java.util
		String display = dateFormat.format(date);
		//format() method is being used to convert the date object into a String according to a specific date format.
		
		String arr [] = display.split(" ");
		String datePrint = arr[0];
		String timePrint = arr[1];
		
		File dest = new File("G:\\softwere testing\\automation\\others in atomation\\"
				+TestID+"(Date(dd-mm-yyyy) "
				+datePrint+" Time(hr-min-sec) "
				+timePrint+").png");
        FileHandler.copy(src, dest);
	

		
	}
	
				//return			//argument	
	public static String getDatafromExcel(String sheetname,int row,int column) throws EncryptedDocumentException, IOException {
		
		
		//sheetname, row ,column
		//testclass me decide hoga ki konse sheet ke konse row
		//column se data lana hai
		
		//excel sheet me Numeric & String ka data ho sakta hai
		// wa ha pe mehtod hame ek hi banani hai(use Try & catch)
		
		
//		String data ="";	//data UI pe enter kar wa na hai to method sendkeys
		// and sendkeys ki argument is string
		
//		try {
//			data = getStringCellValues();
//		}
	//	catch() {
//			double = getNumericCellValue();//Numeric return type double
	
			// lekin final result String me hi chahi ye to 
			// double ko String me convert karege
			//google : how to convert numeric data into string,
			// how to convert double into string
			// how to convert int into string
			
//			data = double to string conversion;
			
			//***** excel sheet ka code handle kar ne ke liye 
			// dependency add karni padegi apachi poi
			// maven ke screenshot meapachi poi ke dependency ke name hai
			// wo sabhi dependancy add karo 
			//build path se add nahi karna
			//pom.xml se add karege
		String data;
		
		String path = "G:\\softwere testing\\automation\\xcel data\\Book 1.xlsx"; 
		FileInputStream file = new FileInputStream(path);
		data = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		//*****WorkbookFactory me error -> add dependency 
		
		
		try 
		{
			data = WorkbookFactory.create(File).getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
			
		}
		catch(IllegalStateException e)
		{
			String path2 = "G:\\softwere testing\\automation\\xcel data\\Book 1.xlsx"; 
			FileInputStream file2 = new FileInputStream(path);
			double data2 = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			String condobtostr = String.valueOf(data2); //look at youtube
		}
		
		return data;
		
	}
	
}
