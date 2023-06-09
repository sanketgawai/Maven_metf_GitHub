package PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracPom {
	WebDriver driver;
	Actions act ;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@FindBy(xpath = "")
	private WebElement ref1;
	
	@FindBy(xpath = "")
	private WebElement ref2;
	
	public PracPom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver,20);
		js = (JavascriptExecutor)driver;
		
	}
	
	public void sendUserName()
	{
		ref1.sendKeys("kong");
	}
	
	public void clickOnLoginButton()
	{
		act.moveToElement(ref2).click().build().perform();
	}
	
	
	
	
	
	
	
	
}
