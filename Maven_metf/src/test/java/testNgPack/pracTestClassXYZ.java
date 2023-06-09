package testNgPack;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import PomClasses.ForgotPasswordPage;
import PomClasses.LoginOrSignUpPage;
import PomClasses.SignUpPopUp;
import browser.Browser;
import browser.pracBrowser;
import utils.Utility;

public class pracTestClassXYZ extends pracBrowser  {
	WebDriver driver;
	LoginOrSignUpPage loginOrSignUpPage; 
	ForgotPasswordPage forgotPasswordPage ;
	SignUpPopUp signUpPopUp ;
	SoftAssert soft ;
	ArrayList<String> addr; 
	static String TestID;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = Browser.openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = Browser.openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void createObjectOfPomClass()
	{
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		signUpPopUp = new SignUpPopUp(driver);  
	}
	
		
	@BeforeMethod
	public void openApplication()
	{
		System.out.println("Before Mehtod");
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.clickoncreatNewAccount();
	}
	
	
	@Test
	public void verifyTermLink123()
	{
		System.out.println("Test -1");
		signUpPopUp.clickOnTermLink();
		
		addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedURL = "https://www.facebook.com/legal/terms/update";
		String expectedTtile = "Faceb";
		
//		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTtile)) 
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
		
		boolean result = (actualURL.equals(expectedURL) && (actualTitle.equals(expectedTtile)));
//		Assert.assertEquals(result, result);
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(result, result);
		soft.assertAll();
		
	}
	
	
			
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("After method");
		
		if(TestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenShot(driver, TestID);
		}
			
	}
		@AfterClass
		public void clearPomObjects() {
			loginOrSignUpPage = null;
			signUpPopUp = null;
		}
		
		@AfterTest
		public void afterTest() {
			driver.quit();
			driver = null;
			System.gc();
		}
		
	
	
	
}

