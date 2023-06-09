package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrSignUpPage {
	private WebDriver driver; //global driver dec karna hai
	private Actions act; 
	//mouse action perform kar ne ke liye hame global driver dec karna padega
	// ab har bar action class ka obj banane ki jarurat nahi
	WebDriverWait wait;// for explicit wati we can dec this and
	// and in side constructor
	
	// variable - private - WebElement
	@FindBy (xpath = "//input[@id='email']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text() = 'Log in']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[text() = 'Create new account']")
	private WebElement creatNewAccount;
	
	@FindBy (xpath = "//a[text() = 'Forgotten password?']")
	private WebElement forgotPasswordLink;
	
	//Constructor - public - WebElement Initialization(Find)
	public LoginOrSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;//global driver dec karna hai  
		act = new Actions(driver);//mouseaction ko globaly dec karte hai
		wait = new WebDriverWait(driver,20);
	}
	
	public void sendUserName()
	{
		userName.sendKeys("jonas");
	}
	public void sendPassword()
	{
		password.sendKeys("addam");
	}
	public void clilckOnLoginButton() {
		loginButton.click();
	}
	public void openSignUpForm()
	{
		creatNewAccount.click();
	}
	public void clickOnForgotPasswordLink(){
		forgotPasswordLink.click();
	}
	public void clickoncreatNewAccount()
	{
		creatNewAccount.click();
	}
	
}
	


