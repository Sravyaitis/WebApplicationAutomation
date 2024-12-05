package twice.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.SignInPage;

public class SignInTest extends DriverManager{
	
	private SignInPage signInPage;
	
	
	@BeforeMethod
	public void setUp() {
		driver.get("https://www.upgrade.com/auth/login?clientId=portal-ui-web&realm=BORROWER");
		signInPage = new SignInPage(driver);
	}
	
	@DataProvider(name="EmptyTextFieldTest")
	public Object[][] emptyTextFieldData() {
		return new Object[][] {
			{"","123"},
			{"test@test.com",""},
			{"",""}
		};
	}
	
	@Test (dataProvider="EmptyTextFieldTest")
	public void testEmptyFields(String username, String password) {
		
		try {
			signInPage.enterUserName(username);
			signInPage.enterPassword(password);
			signInPage.ClickSignInButton();
			
			if(username.isEmpty() && password.isEmpty()) {
				
				try {
					String emptyUsernameErrortext=signInPage.getEmptyUserNameErrorText();
					String emptyPasswordErrorText=signInPage.getEmptyPasswordErrorText();
					
					Assert.assertEquals(emptyUsernameErrortext, "This field is required");
					Assert.assertEquals(emptyPasswordErrorText, "This field is required");
					
				} catch(Exception e) {
					Assert.fail();
				}
			} else if(username.isEmpty()) {
				String emptyUsernameErrortext=signInPage.getEmptyUserNameErrorText();
				Assert.assertEquals(emptyUsernameErrortext, "This field is required");
			} else if(password.isEmpty()) {
				String emptyPasswordErrorText=signInPage.getEmptyPasswordErrorText();
				Assert.assertEquals(emptyPasswordErrorText, "This field is required");
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testForgotPasswordLink() {
		try {
			signInPage.clickForgotPasswordLink();
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.upgrade.com/auth/reset-password?clientId=portal-ui-web&realm=BORROWER");
			
		} catch(Exception e) {
			Assert.fail();
		}
	}

}
