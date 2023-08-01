package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonFunction {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Find Services']")
	public WebElement searchText;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	public WebElement serchbtn;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public WebElement gigstatus;
	
	
	
	public CommonFunction(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public int checkBrokenLinks()
	{
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		
		int count = 0;
		
		for(WebElement element : ele)
		{
			String str = element.getAttribute("href");			
			if(str == null)
					count++;
			
		}		
		return count;
	}
	
	public String searchService(String text) throws InterruptedException
	{
		searchText.sendKeys(text);
		serchbtn.click();
		Thread.sleep(3000);
		String textgig = gigstatus.getText();
		
		return textgig;
	}
}