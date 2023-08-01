package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import config.Setup;
import pomPages.LoginPage;

public class TestLoginPage extends Setup {	
	
	@Test
	public void loginData() throws InterruptedException
	{
		String text = login();
		
		if(!text.isEmpty())
		{
			System.out.println("Here Test will be failed");
			Assert.assertFalse(false);
		}
		
		login.checkLogout();
		
		driver.navigate().back();
		String checkSignInStatus = login.checkNavigateBackToLogin();
		
		Assert.assertEquals(checkSignInStatus, "Sign In");
	}
}
