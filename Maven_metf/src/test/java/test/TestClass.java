package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClasses.ForgotPasswordPage;
import PomClasses.LoginOrSignUpPage;

public class TestClass {
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.sendUserName();
		loginOrSignUpPage.sendPassword();
		//loginOrSignUpPage.clilckOnLoginButton();
		loginOrSignUpPage.clickOnForgotPasswordLink();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver); 
		forgotPasswordPage.getTextMessage();
		forgotPasswordPage.sendEmailOrPhoneNumber();
		forgotPasswordPage.clickOnSerachButton();
		
		//ye navigation steps is hi sequence me hona chahiye
		
		// ye ek test case , dusra testcase ke liye new testclass creat karo
		
		// dusre test class me agar loginOrSignUpPage ka obj banya to wo totaly different hoga
		//is liye waha pe new testcase use kar sakte hai
		
		
	}
}
