package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_object {

	WebDriver driver;
	public Contact_object(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@title,'Create Contact')]")
	private WebElement createContactButton;
	
	public WebElement getCreateContactButton()
	{
		return createContactButton;
	}
	
}
