package testNgPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Automation {
	SoftAssert soft;
	@BeforeSuite  
	public void beforeSuite() {
		System.out.println("Before Suite - Automation");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - Automation");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - Automation");
		 soft = new SoftAssert();
	}
	@BeforeMethod
	public void beforeMehtod() {
		System.out.println("Before Method - Automation");
		
		
	}
	
	@Test
	public void test1() {
		//SoftAssert soft = new SoftAssert();
		String actualsTItle = "Facebook - log in or sign up";
		String expectedTItle = "Facebook - log in or sign up";
		

		
		
		soft.assertEquals(actualsTItle,expectedTItle,"Title is wrong");
		
		
		soft.assertAll(); 
	}
	
	@Test
	public void test2() throws InterruptedException {
			//SoftAssert soft = new SoftAssert();
			System.out.println("Test -2 - Automation"); 
			
			String actualUrl = "https://www.facebook.com/";
			String expactedUrl ="https://www.facebook.com/";
						
			
			
			soft.assertEquals(actualUrl, expactedUrl,"URL is wrong");
			
			soft.assertAll();
	}
	
	@Test
	public void test3() {
			//SoftAssert soft = new SoftAssert();
			System.out.println("Test -3 - Automation"); 
			
			String actualButtonText = "Cancel";
			String expactedButtonText ="Cancell";
			
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualButtonText, expactedButtonText,"Cancel Button text is wrong");
			soft.assertAll();
	}
	
//	@Test
//	public void test4() throws InterruptedException {
//			System.out.println("Test -4 - Automation"); 
//	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method - Automation");
		
	}
	
	@AfterClass
	public void afterClass () {
		System.out.println("After Class - Automation");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Automation");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Test - Automation");
	}
	
//  Suite-tagname   class- annoatation
//  parameter
//	suite		-> @BeforeSuite @AfterSuitd
//	test		-> @BeforeTest @AfterTest
//	class 		-> @BeforeClass @AfterClass
//	include		-> @BeforeMethod @Test @AfterMethod
//	 
//	
	
}
