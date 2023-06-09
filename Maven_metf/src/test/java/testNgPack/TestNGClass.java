package testNgPack;

import org.testng.Assert;
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

public class TestNGClass {
	SoftAssert soft;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - TestNGClass");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - TestNGClass");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - TestNGClass");
		 soft = new SoftAssert();
	}
	
	
	@BeforeMethod
	public void beforeMehtod() {
		System.out.println("Before Method - TestNGClass");
	}
	
	
	@Test
	public void testA() {
			System.out.println("Test - A - TestNGClass");
			
			String actualsTItle = "Facebook - log in or sign up";
			String expectedTItle = "Facebook - log in or sign up";
			
			SoftAssert soft = new SoftAssert();
			
			
			//1. To compare the actual & Result
			//2. To decide the test result ie. PASSED/FAILED
			//if ActualResult is EQUALS To ExpectedResut then test case is PASSED
			// if Actual Result is NOT EQUALS To Expected Result then test case is FAILED
			
			
			soft.assertEquals(actualsTItle, expectedTItle, "Login page title id wrong");
			
			//1. To compare the actual & Result
			//2. To decide the test result ie. PASSED/FAILED
			//if ActualResult is EQUALS To ExpectedResut then test case is FAILED
			// if Actual Result is NOT EQUALS To Expected Result then test case is PASSED
		
			
			soft.assertNotEquals(actualsTItle, expectedTItle);//equal nahi hona chahiye
			
			//1. To decide the test result ie. PASSED/FAILED
			// if result = true then test method ->  PASSED
			// if result = false then test method ->  FAILED
			//jo ham Testclass me if me if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
			//is ko boolean me dal ke wo result ham pass kar sakte hai
			boolean result = actualsTItle.equals(expectedTItle);
			soft.assertTrue(result);
			
			//1. To decide the test result ie. PASSED/FAILED
			// if result = true then test method ->  FAILED
			// if result = false then test method ->  PASSED
			
			soft.assertFalse(result); 
			
			
			// To failed the test method 
			Assert.fail();
			if(actualsTItle.equals(expectedTItle))
			// do no same hai and test cass pass kar wani hai 
			//	to if ememe kuch math likho
			{
				
			}
			else
			// dono diff hai and test case fail karna hai to 
			// ya ha pe likho Assert.fail();	
			{
				Assert.fail();
			}
			
			//or
			soft.fail();
			if(actualsTItle.equals(expectedTItle))
			// jab dono same hai to test case fail hoga 
				
			{
				soft.fail();
			}
			else
			// dono diff hai and test case pass hoga 
			// 	
			{
				
			}
			//no prob is ko use hi nahi karte
			//or
			// dono do no same hai to result true hai lekin
			//!ke baje se fails hoga
			
			// ab do no diff hai to result false 
			//! ke bajese pass
			if(!actualsTItle.equals(expectedTItle))
			{
				soft.fail();
			}
			
//			Soft me ek extram method
			// to apply the result of (soft) assertion on test method
			soft.assertAll();
			
	}
			
	@Test
	public void testB() { 
			System.out.println("Test - B - TestNGClass");
	}
	
	@Test
	public void testC() {  
			System.out.println("Test - C - TestNGClass");
	}
	
	@Test
	public void testD() {
			System.out.println("Test - D - TestNGClass");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method - TestNGClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class - TestNGClass");
	}
	
	@AfterTest
	public void afterTest () {
		System.out.println("After Test - TestNGClass");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - TestNGClass");
	}
}
