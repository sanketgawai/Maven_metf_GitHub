package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	static WebDriver driver;
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// ham is liy aisa kare ge ki hame bar bar test class me
		// open browser ka code na likh na pade
		// ham test class me sidha ye method call karege
		
		//ham ne new ChromeDriver() ko driver me store kiya hai  
		// means hame driver ko return karna hai 
		// means driver ka jo type wo hi mehtod ka return type hona chahiye
		//return driver;
		//driver ka return type WebDriver hai to mehtod me void ko replace with it
		
		return driver;
		
		
	}
	
	public static WebDriver openFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver","E:\\software testing\\selenium\\new\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		return driver;

		
		
}

} 