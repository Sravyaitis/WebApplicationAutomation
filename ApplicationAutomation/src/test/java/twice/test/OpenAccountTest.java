package twice.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.HomePage;
import twice.pages.OpenAccountPage;

public class OpenAccountTest extends DriverManager{
	
	private OpenAccountPage openAccountPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		openAccountPage = new OpenAccountPage(driver);
		homePage=new HomePage(driver);
	}
	
	@Test
	public void testOpenAccount() {
		
		try {
			homePage.clickOpenNewAccountButton();
			openAccountPage.enterEmail("test@gmail.com");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	
	@DataProvider(name="invalidEmailTests")
	public Object[][] invalidEmailData(){
		return new Object[][] {
			{"testemail"},
			{".com"},
			{"test@testcom"}
		};
	}
	
	
	@Test(dataProvider="invalidEmailTests")
	public void testInvalidEmailFormats(String invalidEmail) {
		
		homePage.clickOpenNewAccountButton();
		
		try {
			openAccountPage.enterEmail(invalidEmail);
			openAccountPage.clickGetStartButton();
			
			String errorMessage=openAccountPage.getEmailInvaidError();
			Assert.assertEquals(errorMessage, "Please enter a valid email.");
			
			
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testEmptyEmail() {
		
		homePage.clickOpenNewAccountButton();
		
		try {
			openAccountPage.enterEmail("");
			openAccountPage.clickGetStartButton();
			
			String errorMessage = openAccountPage.getEmailEmptyError();
			
			Assert.assertEquals(errorMessage, "This field is required");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testRedirectSignInPage() {
		
		homePage.clickOpenNewAccountButton();
		
		try {
			
			openAccountPage.clickSignIntoGetStartLink();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.urlToBe("https://www.upgrade.com/portal/login-deposit-user?pdc=DEP_CH_03"));
			
			Assert.assertEquals(driver.getCurrentUrl(),"https://www.upgrade.com/portal/login-deposit-user?pdc=DEP_CH_03");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}

	
}
