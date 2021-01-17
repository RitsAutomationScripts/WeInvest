package herouapp.weinvest.qa.testcases;

import herouapp.weinvest.qa.base.TestBase;
import herouapp.weinvest.qa.pages.AllWeatherStategyPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllWeatherStategyTest extends TestBase{
	AllWeatherStategyPage allWeatherStategy;
	
	public AllWeatherStategyTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		allWeatherStategy = new AllWeatherStategyPage();
		
	}
	 @Test(priority=1)
		public void Test_A() throws InterruptedException
		{
		 allWeatherStategy.clickOnExpInvIdeas();
		 allWeatherStategy.clickOncusProt();
		 allWeatherStategy.clickOncustomise();
		 allWeatherStategy.moveSlider();
		 allWeatherStategy.clickOnreBalance();
		 allWeatherStategy.clickOninvestnow();
		String percent = prop.getProperty("percent");
		Assert.assertTrue(allWeatherStategy.verifySPDRpercentage(percent));
			
		}
	    
	    @Test(priority=2)
		public void Test_B() throws InterruptedException
		{
	    	allWeatherStategy.clickOnExpInvIdeas();
	    	allWeatherStategy.clickOncusProt();
	    	allWeatherStategy.clickOncustomise();
			Assert.assertTrue(allWeatherStategy.verifyResetButton());
			allWeatherStategy.clickOnaddStocks();
			allWeatherStategy.clickOnbtGrpAddStocks();
			allWeatherStategy.clickOnDone();
			Assert.assertTrue(allWeatherStategy.verifyBT());
			
		}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
