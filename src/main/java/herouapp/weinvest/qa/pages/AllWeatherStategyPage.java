package herouapp.weinvest.qa.pages;

import herouapp.weinvest.qa.base.TestBase;
import herouapp.weinvest.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWeatherStategyPage extends TestBase{
	
	//Page Factory 
	
	@FindBy(xpath = "(//div[text()='All Weather Strategy']/following::a[text()='Explore Investment Ideas'])[1]")
	public WebElement expInvIdeas;

	@FindBy(xpath = "(//a[text()='Customize Portfolio'])[1]")
	public WebElement cusProt;

	@FindBy(xpath = "(//a[text()='Customise'])[1]")
	public WebElement customise;

	@FindBy(xpath = "(//a[text()='Reset'])[1]")
	public WebElement reset;

	@FindBy(xpath = "//input[@data-isin='SPY']")
	public WebElement sPYSlider;

	@FindBy(xpath = "//a[text()='Rebalance']")
	public WebElement reBalance;

	@FindBy(xpath = "//a[text()='Invest Now']")
	public WebElement investnow;

	@FindBy(xpath = "(//div[text()='US EQUITIES']/following::a[text()='+ Add Stock'])[1]")
	public WebElement addStocks;

	@FindBy(xpath = "(//a[text()='BT Group plc']/following::button[text()='Add Stock'])[1]")
	public WebElement btGrpAddStocks;

	@FindBy(xpath = "(//button[text()='Done'])[1]")
	public WebElement done;

	@FindBy(xpath = "(//input[@data-isin='BT']/following::a[text()='BT Group plc'])[1]")
	public WebElement verifyBT;
	
	@FindBy(xpath = "(//span[text()='SPDR S&P500 ETF Trust']/following::div/span)[1]")
	public WebElement ele;
	
	//Initializing the Page Objects:
	public AllWeatherStategyPage(){
		PageFactory.initElements(driver, this);
	}
	Actions move = new Actions(driver);
	//Actions:
		
	public void clickOnExpInvIdeas() throws InterruptedException {
		waitForElement(10);
		move.moveToElement(expInvIdeas);
		expInvIdeas.click();
	}

	public void clickOncusProt() throws InterruptedException {
		waitForWebElementVisible(cusProt, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(cusProt);
		cusProt.click();
	}

	public void clickOncustomise() throws InterruptedException {
		waitForWebElementVisible(customise, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(customise);
		customise.click();
	}

	public void clickOnreBalance() throws InterruptedException {
		waitForWebElementVisible(reBalance, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(reBalance);
		reBalance.click();
	}

	public void clickOninvestnow() throws InterruptedException {
		waitForWebElementVisible(investnow, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(investnow);
		investnow.click();
	}

	public void moveSlider() throws InterruptedException {
		waitForWebElementVisible(sPYSlider, TestUtil.EXPLICIT_WAIT);
		new Actions(driver).dragAndDropBy(sPYSlider, 1, 0).build().perform();
		waitForElement(5);
		
	}

	public boolean verifySPDRpercentage(String percent) throws InterruptedException {
		waitForElement(8);
		boolean res = false;
		String value = ele.getText();
		if (value.equalsIgnoreCase(percent)) {
			res = true;
		}
		return res;
	}

	public void clickOnaddStocks() throws InterruptedException {
		waitForWebElementVisible(addStocks, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(addStocks);
		addStocks.click();
	}

	public void clickOnbtGrpAddStocks() throws InterruptedException {
		waitForWebElementVisible(btGrpAddStocks, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(btGrpAddStocks);
		btGrpAddStocks.click();
	}

	public void clickOnDone() throws InterruptedException {
		waitForWebElementVisible(done, TestUtil.EXPLICIT_WAIT);
		move.moveToElement(done);
		done.click();
	}

	public boolean verifyResetButton() throws InterruptedException {
		waitForElement(5);
		boolean res = false;
		if (reset.isDisplayed()) {
			res = true;
		}
		return res;
	}
	
	public boolean verifyBT() throws InterruptedException {
		waitForElement(5);
		boolean res = false;
		if (verifyBT.isDisplayed()) {
			res = true;
		}
		return res;
	}
	public void waitForElement(int iSeconds) {
		try {
			Thread.sleep(iSeconds * TestUtil.SLEEP_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean waitForWebElementVisible(WebElement element,long timeout){
		try{
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e){
			System.out.println("----- Element is not Visible -------");
			return false;
		}
		return true;
	}
}
