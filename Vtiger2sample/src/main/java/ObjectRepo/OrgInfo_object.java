package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class OrgInfo_object {
 public WebDriver driver;
 public OrgInfo_object(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
  @FindBy(xpath = "//span[@class='dvHeaderText']")
  private WebElement Headermsg;
  
  @FindBy(xpath = "//img[contains(@src,'user.PNG')]")
  private WebElement signOutImg;
  
  @FindBy(xpath = "//a[@id='_my_preferences_']/ancestor::tr/following-sibling::tr//a")
  private WebElement signOut;
  
  public WebElement getHeadermsg() 
    {
	  return Headermsg;
    }  
  public WebElement getSignOutImg()
	  {
		return signOutImg;
	  }
  public WebElement getSignOut()
    {
	   return signOut;  
    }
  
  public void signOutAction()
  {   
	  WebdriverUtility wlib=new WebdriverUtility();
	  wlib.moveToElement(driver, signOutImg);
	  
	  signOut.click();
  }
 
}
