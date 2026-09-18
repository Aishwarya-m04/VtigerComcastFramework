package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_object {
 
	WebDriver driver;
	public Organization_object(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//img[contains(@title,'Create Organization')]"))
	private WebElement CreateOrgButton;
	
	@FindBy(xpath=("//input[@name='submit']"))
	private WebElement searchButton;
	
	@FindBy(xpath=("//img[@title='Search in Organizations...']"))
	private WebElement SearchInOrg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateOrgButton() {
		return CreateOrgButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchInOrg() {
		return SearchInOrg;
	}
	
}
