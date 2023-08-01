package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class OrderPage_POM {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Orders']")
	public WebElement orderBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Manage Orders']")
	public WebElement checkWordForAssertion;
	
	public OrderPage_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrderButton()
	{
		orderBtn.click();
		String str = checkWordForAssertion.getText();
		
		if(str.equals("Manage Orders"))		
			return true;		
		else		
			return false;		
	}
}
