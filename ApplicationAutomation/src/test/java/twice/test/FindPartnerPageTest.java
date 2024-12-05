package twice.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.FindPartnerPage;

public class FindPartnerPageTest extends DriverManager{

	private FindPartnerPage findPartnerPage;
	Properties prop;
	
	@BeforeMethod
	public void setUp() {
		findPartnerPage = new FindPartnerPage(driver);
		driver.get("https://www.upgrade.com/flex-pay/find-partners/");
	}
	
	@Test
	public void testSearchPartner() {
		
		try {
			String partnerName = "Air Canada";
			
			findPartnerPage.enterPartnerName(partnerName);
			findPartnerPage.clickSearchedPartner(partnerName);
			
			waitForNewTab();
			
			Set<String> wh=driver.getWindowHandles();
			Iterator<String> it=wh.iterator();
			String parent=it.next();
			String child=it.next();
						
			driver.switchTo().window(child);
			String expectedUrl="https://www.aircanada.com/ca/en/aco/home.html#/";
			
			Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl));
			driver.switchTo().window(parent);
			
		} catch(Exception e) {
			Assert.fail();
		}
	
		
		
	}

	private void waitForNewTab() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size()>1);
		
	}
}
