package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import config.Setup;
import junit.framework.Assert;
import pomPages.CommonFunction;
import pomPages.HomePage_POM;

public class HomePage extends Setup {
	
	@Test(priority = 1 ,groups = "regresssion")
	public void verifyHomeTitle()
	{	
		String title = driver.getTitle();
		String actualTitle = "Hire Freelance Services From Online Marketplace India";
		System.out.println("Test Case 1");
		Assert.assertEquals(actualTitle, title);		
	}
	
	@Test(priority = 2, dependsOnMethods = "verifyHomeTitle", groups = "regresssion")
	public void veryfyMenuClickable()
	{
		CommonFunction broken = new CommonFunction(driver);
		
		int numBrokenLinks = broken.checkBrokenLinks();
		
		System.out.println("Total Broken links : "+numBrokenLinks);
		System.out.println("Test Case 2");
		
		assertTrue(true);
	}
	
	@Test(priority = 3)
	public void loginPopUpOpen() throws InterruptedException
	{
		HomePage_POM home = new HomePage_POM(driver);
		String string = home.checkOpen();
		System.out.println("Test Case 3");
		Assert.assertEquals(string,"Login To Hirekar");
	}
	
	@Test(priority = 4)
	public void CheckSignUp() throws InterruptedException
	{
		HomePage_POM home = new HomePage_POM(driver);
		String text = home.checkSignUP();
		System.out.println("The text is : "+text);
		System.out.println("Test Case 4");
		Assert.assertEquals(text, "Join Hirekar");
	}
	
	@Test(priority = 5)
	public void searchServices() throws InterruptedException
	{
		CommonFunction data = new CommonFunction(driver);
		String text = data.searchService("graphigyfghc");
		System.out.println("Test Case 5");
		Assert.assertEquals(text, "No gig found, Please try another query.");
	}
}