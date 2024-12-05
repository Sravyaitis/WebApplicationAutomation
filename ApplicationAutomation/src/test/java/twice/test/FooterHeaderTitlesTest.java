package twice.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.HomePage;
import utils.WaitUtils;

public class FooterHeaderTitlesTest extends DriverManager{
	
	private HomePage homePage;
	private WaitUtils waitUtils;
	
	@BeforeMethod
	public void setUp() {
		homePage= new HomePage(driver);
		this.waitUtils=new WaitUtils(driver);
	}
	
	
	@Test
	public void getFooterHearTitles() {
		homePage.scrollToFooter();
		waitUtils.waitForElementsToBeVisible(By.cssSelector("footer"));
		
		List<WebElement> footerHeaders=driver.findElements(By.cssSelector("footer ul li span"));
		
		for(WebElement header : footerHeaders) {
			System.out.println(header.getText());
		}
	}

}
