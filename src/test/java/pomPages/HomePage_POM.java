package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_POM {
	
	@FindBy(linkText ="Sign In")
	public WebElement signButton;
	
	@FindBy(xpath = "//h5[contains(text(),'Login To Hirekar')]")
	public WebElement popupText;
	
	@FindBy(linkText ="Join Now")
	public WebElement signup;
	
	@FindBy(xpath="//h5[contains(text(),'Join Hirekar')]")
	public WebElement singupText;
	
	
	//h5[contains(text(),'Join Hirekar')]
		
	public HomePage_POM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkOpen() throws InterruptedException
	{
		signButton.click();
		Thread.sleep(2000);
		String text = popupText.getText();
		
		return text;
	}
	
	public String checkSignUP() throws InterruptedException
	{
		signup.click();
		Thread.sleep(2000);
		String text = singupText.getText();		
		return text;
	}
}

