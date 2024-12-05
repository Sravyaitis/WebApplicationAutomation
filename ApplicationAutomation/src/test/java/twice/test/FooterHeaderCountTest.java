package twice.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.HomePage;
import utils.WaitUtils;

public class FooterHeaderCountTest extends DriverManager{
	
	private HomePage homePage;
	private WaitUtils waitUtils;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(driver);
		waitUtils=new WaitUtils(driver);
	}
	
	@Test
	public void countFooterHeaders() {
		List<WebElement> footerHeaders=driver.findElements(By.cssSelector("footer ul li span"));
		System.out.println(footerHeaders.size());
	}
}
