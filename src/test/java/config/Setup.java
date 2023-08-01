package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pomPages.LoginPage;

public class Setup {
	
	public WebDriver driver;
	String baseUrl = "https://hirekar.in/";
	public LoginPage login;
	
	@BeforeMethod
	public void init()
	{
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	public String login() throws InterruptedException
	{
		login = new LoginPage(driver);
		String text = login.verifyLogin("abhijitpaithane93@gmail.com", "Promote123*");
		return text;
	}
}
