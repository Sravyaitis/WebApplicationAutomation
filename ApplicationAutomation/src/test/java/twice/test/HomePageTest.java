package twice.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.HomePage;

public class HomePageTest extends DriverManager{

	private HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(driver);
	}
	
	@Test
	public void testClickOnOpenNewAccount() {
		
		try {
			homePage.clickOpenNewAccountButton();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.upgrade.com/personal-loans/");
			
		} catch(Exception e) {
			System.out.println("current url after redirect: "+driver.getCurrentUrl());
			Assert.fail();
		}
	}
	
	
	@Test
	public void testClickSeeAllCardTabRedirectToTheUpgradeCardPage() {
		
		try {
			homePage.clickSeeAllUpgradeCardTab();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.upgrade.com/upgrade-card/");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void countLinksOnHomePage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	}

}
