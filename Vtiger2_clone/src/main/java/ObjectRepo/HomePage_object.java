package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_object {
	WebDriver driver;
	public HomePage_object(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement products;
	
	public WebElement getProducts() {
		return products;
	}

	public void setProducts(WebElement products) {
		this.products = products;
	}

	@FindBy(xpath=("//a[text()='Organizations']"))
	private WebElement Organization;
	
	@FindBy(linkText=("Contacts"))
	private WebElement Contacts;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganization() {
		return Organization;
	}

	public WebElement getContacts() {
		return Contacts;
	}
	
	

}
