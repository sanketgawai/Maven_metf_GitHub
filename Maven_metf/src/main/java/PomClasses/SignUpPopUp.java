package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPopUp {
	private WebDriver driver;
	private Actions act;
	WebDriverWait wait;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement firstname;
	
	@FindBy (xpath = "//input[@id='u_2_d_qv']")
	private WebElement surname;
	
	@FindBy (xpath = "//input[@id='u_2_g_YU']")
	private WebElement emailaddress;
	
	@FindBy (xpath = "//input[@id='password_step_input']")
	private WebElement newpass;
	
	@FindBy (xpath = "//div[@id='u_2_p_q6']//select")
	private WebElement selectpronoun;
	
	@FindBy (xpath = "//a[@id='terms-link']")
	private WebElement termlink;
	
	@FindBy (xpath = "//a[@id='privacy-link']")
	private WebElement privacylink;
	
	@FindBy (xpath = "//a[@id='cookie-use-link']")
	private WebElement cookieslink;
	
	public SignUpPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver,20);
	}
	
	public void sendfirstname() {
		firstname.sendKeys("gold D");
	}
	
	public void sendsurname() {
		surname.sendKeys("Roger");
	}
	
	public void sendemailaddress() {
		emailaddress.sendKeys("East Blue");
	}
	
	public void sendnewpass() {
		newpass.sendKeys("Pirate King");
	}
	
	public void clickselectpronoun() {
		selectpronoun.click();
	}
	
	public void clickOnTermLink() {
		termlink.click();
	}
	
	public void clickOnPrivacyLink() {
		privacylink.click();
	}
	
	public void clickOnCookiesLink() {
		cookieslink.click();
	}
	
	
}
	 
	

