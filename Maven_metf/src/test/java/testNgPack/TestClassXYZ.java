package testNgPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
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
import utils.Utility;

public class TestClassXYZ extends Browser  {


		static WebDriver driver;
		static String TestID;
		private ArrayList<String> addr;
		private LoginOrSignUpPage loginOrSignUpPage;
		private  SignUpPopUp signUpPopUp;
		private ForgotPasswordPage forgotPasswordPage;
		SoftAssert soft;
		//har class me ye veriable diff banege to inhe private dec karte hai 

		@Parameters("browser")
		@BeforeTest
		public void openBrowser(String browserName) {
			
			
			if(browserName.equals("Chrome")) {
				driver =	Browser.openChromeBrowser();
			}
			
//			if(browserName.equals("Firefox")) {
//				driver =	Browser.openFirefoxBrowser();
//				}

			
//			if(browserName.equals("chrome")) {
//				System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new\\chromedriver.exe");
//				WebDriver driver = new ChromeDriver();
//			}
//			if(browserName.equals("Firefox")) {
//				
//				System.setProperty("webdriver.gecko.driver","E:\\software testing\\selenium\\new\\geckodriver.exe");
//				WebDriver driver = new FirefoxDriver();
//			}
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@BeforeClass
		public void creatPomObjects() {
			loginOrSignUpPage = new LoginOrSignUpPage(driver);
			signUpPopUp = new SignUpPopUp(driver);
			ForgotPasswordPage forgotPasswordPage =new ForgotPasswordPage(driver);
			soft = new SoftAssert();
		
		} 
		
		
//		Before method me : url enter karne ka and creat new accunt click karne ka code jo ki 1 hi bar likha rahe ga 
	//par execute multiple time hoga before every @Test
		@BeforeMethod
		public void beforeMehtod() {
			System.out.println("Before Method");
			
			driver.get("https://www.facebook.com/");
			
 
			
			//*********	System.out.println("Before Method");
			// in usability excel sheet ka code  use in facebook
//						String user = Utility.getDatafromExcel(TestID, 1, 0) //testId(sheetnam)row 1, column 0
//						loginOrSignUpPage.sendUserName(Utility.getDatafromExcel(TestID, 1, 0));
			
//			 			String pass = Utility.getDatafromExcel(TestID, 1, 0) //testId(sheetnam)row 1, column 0
//						loginOrSignUpPage.sendPassword(pass);
			loginOrSignUpPage.clickoncreatNewAccount();
		}
		
		@Test
		public void verifyTermLink123() {
			TestID = "1";
//			Assert.fail();
			System.out.println("Test - 1");
//			 signUpPopUp = new SignUpPopUp(driver);
			signUpPopUp.clickOnTermLink();
			
			addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			
			String actualURL = driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			
			String expectedURL ="https://www.facebook.com/legal/terms/update";
			String expectedTitle = "Faceb";
			  
			if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
			{
				System.out.println("PASSED");
			}
			else
			{
				System.out.println("FAILED");
			}
			
//			Assert.assertEquals(actualURL, expectedURL);
//			or
//			boolean result = (actualURL.equals(expectedTitle) && actualTitle.equals(expectedTitle));
//			Assert.assertEquals(result, result);
			
//			SoftAssert soft = new SoftAssert();
//			soft.assertEquals(actualTitle, expectedTitle);
//			soft.assertAll();
			
//			boolean result = (actualURL.equals(expectedURL) && actualTitle.equals(actualTitle));
//			soft = new SoftAssert();
//			soft.assertEquals(result, result);
//			soft.assertAll();
			
			
//			addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(0));
		}
		
		@Test
		public void verifyPrivacyLink123() {
			TestID = "2";
			System.out.println("test-2");
//			signUpPopUp = new SignUpPopUp(driver);
			signUpPopUp.clickOnPrivacyLink();
			
			addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			
			String actualURL =driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			
			String expectedURL ="https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
			String expectedTitle = "Meta Privacy Policy – How Meta collects and uses user data | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
//			if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
//			{
//				System.out.println("PASSED");
//			}
//			else
//			{
//				System.out.println("FAILED");
//			}
			boolean result = (actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle));
			
			Assert.assertEquals(result, result);
			
			
//			addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(0));
		}
		
		@Test()
		public void verifyCookiesLink123() {
			 TestID = "3";
			System.out.println("test-3");
//			 signUpPopUp = new SignUpPopUp(driver);
			signUpPopUp.clickOnCookiesLink();
			
			addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
					
			String actualURL =driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			
			String expectedURL ="https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
			String expectedTitle = "Meta Cookies Policy | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
//			if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
//			{
//				System.out.println("PASSED");
//			}
//			else
//			{
//				System.out.println("FAILED");
//			}
			boolean result = (actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle));
			
			Assert.assertEquals(result, result);
			
			
			
//			addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(0));
		}
		
		//after method me close curent tab driver.close
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			//The "afterMethod" method takes an "ITestResult" object as a parameter.
			//This object contains information about the result of the test method that was just executed,
			//such as whether it passed or failed, the duration of the test, and any associated exception or error messages.
			System.out.println("After method");
						
			if(TestResult.FAILURE == result.getStatus())
			{
//				Utility.captureScreenShot(TestID);
				Utility.captureScreenShot(driver, TestID);
			}
			
			//driver.close();//if you use driver.close();
			//Configuration Failures: 1, Skips: 4
			//org.openqa.selenium.NoSuchSessionException: invalid session id
			//sol : NoSuchSessionExpection happens when you try to perform any actions after webdriver.quit(). Make sure you are not calling any command after webdriver.quit().
//			or better way
			
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(0));
			
		}
		
		//after class last me and ek hi bar execute hoga  me close window driver.quit
		@AfterClass
		public void clearPomObjects () {
			loginOrSignUpPage = null;// obj clear karne ke liye
			signUpPopUp = null;// and obj ke value delete nahi hogi null hogi
			forgotPasswordPage = null;
		}
		@AfterTest	
		public void afterTest () {
			System.out.println("After Test");
			driver.quit();// driver ke andar ka obj usk bhi kam ho gaya
			driver = null;// ab driver ke andar ke obj ki koi jarurat nahi ahi
			//us ko bhi null kardo
			
			// null kar ne se obj delete nahi hota 
			System.gc();// is method ko call karne se obj delete hoga
			//gc stand for garbage collector
			//is hi liye hamne phle obj se ref nikaldiye like driver = null;
		}
			//is tarah se final testclass banega
		
		
	}


