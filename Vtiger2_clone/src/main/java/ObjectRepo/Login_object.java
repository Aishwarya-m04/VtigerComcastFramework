package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_object {

	WebDriver driver;
	public Login_object(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//input[@name='user_name']"))
	private WebElement Username;
	
	@FindBy(xpath=("//input[@name='user_password']"))
	private WebElement UserPassword;
	
	@FindBy(id=("submitButton"))
	private WebElement Login;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getUserPassword() {
		return UserPassword;
	}

	public WebElement getLogin() {
		return Login;
	}
	
	public void loginAction(String un,String pd)
	{
		Username.clear();
		Username.sendKeys(un);
		
		UserPassword.clear();
		UserPassword.sendKeys(pd);
		
		Login.click();
	}
	
	
	
}
