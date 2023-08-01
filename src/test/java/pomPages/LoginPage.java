package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Setup;

public class LoginPage extends Setup {
	
	@FindBy(xpath="//div[@class='top-nav']//a[normalize-space()='Sign In']")
	public WebElement signBtn;
	
	@FindBy(name="login")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//form[@id='modal-login-form']//button[@type='submit'][normalize-space()='Continue']")
	public WebElement signupBtn;
	
	@FindBy(xpath="//a[normalize-space()='Notifications']")
	public WebElement notification;
	
	@FindBy(xpath = "//button[@class=\"dropdown-toggle\"]//img")
	public WebElement profile;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	public WebElement logoutBtn;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLogin(String usernmae, String passwordd) throws InterruptedException
	{
		signBtn.click();
		Thread.sleep(3000);
		username.sendKeys(usernmae);
		password.sendKeys(passwordd);
		signupBtn.click();
		Thread.sleep(3000);
		try {
			String dtext = notification.getText();
			return dtext;
		} catch (Exception e) {
			String dtext ="";
			return dtext;
		}
		
	}
	
	public void checkLogout()
	{
		profile.click();
		logoutBtn.click();
	}
	
	public String checkNavigateBackToLogin()
	{
		return signBtn.getText();
	}
}