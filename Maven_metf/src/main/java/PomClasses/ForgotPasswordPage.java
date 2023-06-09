package PomClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
	
	
	private WebDriver driver; //global driver dec karna hai
	private Actions act; 
	//mouse action perform kar ne ke liye hame global driver dec karna padega
	// ab har bar action class ka obj banane ki jarurat nahi
	WebDriverWait wait;// for explicit wati we can dec this and
	// and in side constructor
	@FindBy(xpath = "//div[contains(text(),'Please enter your email')]")
	private WebElement textMsg;
	
	@FindBy(xpath = "//input[@id='identify_email']")
	private WebElement emailAddrOrPhoneNumber;
	
	@FindBy(xpath = "//button[@id='did_submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[text() ='Cancel']")
	private WebElement cancellButton;
	
	@FindBy (xpath = "//a")
	private List<WebElement>links;  
	
	public ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;//global driver dec karna hai  
		act = new Actions(driver);//mouseaction ko globaly dec karte hai
		wait = new WebDriverWait(driver,20);
	}
//	public String getLink(int index) {
//		String attributeValues = links.get(index).getAttribute("href");
//		return attributeValues;
//	}
	
	public void getTextMessage() {		// selenium -3.141.59
			//driver,long
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollIntoView(true)",textMsg);
		 
		String text = textMsg.getText();
		System.out.println(text);
	}
	
	public void sendEmailOrPhoneNumber() {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(emailAddrOrPhoneNumber));
		emailAddrOrPhoneNumber.sendKeys("kingofbeast@kaido");
	}
	
	public void clickOnSerachButton() {
//		Actions act = new Actions(driver);
		act.moveToElement(searchButton).click().perform();
	}
	
	public void clickOnCancelButton() {
//		Actions act = new Actions(driver);
		act.moveToElement(cancellButton).click().perform();
	}
//		it is just an ex that how should you handle dropdown		
//		public void sendEmailOrPhoneNumberr() {
//		Select s = new Select(emailAddrOrPhoneNumber);
//				s.selectByIndex(0);
//	}
	
	public boolean getStatusOfCancelButton() {
		//boolean result = cancellButton.isDisplayed();
		boolean result = cancellButton.isEnabled();
		return result;
	}
	
	
}
