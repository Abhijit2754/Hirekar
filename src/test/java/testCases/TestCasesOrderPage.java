package testCases;

import org.testng.annotations.*;

import config.Setup;
import junit.framework.Assert;
import pomPages.OrderPage_POM;

public class TestCasesOrderPage extends Setup {

	@Test
	public void checkOrderPage() throws InterruptedException
	{
		login();
		OrderPage_POM order = new OrderPage_POM(driver);
		Boolean res =  order.verifyOrderButton();
		
		Assert.assertTrue(res);
	}
}
