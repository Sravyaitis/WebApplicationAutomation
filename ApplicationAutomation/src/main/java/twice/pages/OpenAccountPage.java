package twice.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class OpenAccountPage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//button[@type='submit']/span[normalize-space()='Get Started']")
    private WebElement getStartButton;
	
	@FindBy(xpath = "//div[@id='email-2-error']")
	private WebElement invalidEmailErrorMessage;
	  
	@FindBy(xpath = "//div[@id='email-2-error' and normalize-space()='This field is required']")
	private WebElement emptyEmailErrorMessage;
	
	@FindBy(xpath = "//a[normalize-space()='Sign in to get started.']")
	private WebElement signIntoGetStartLink;
	
	public OpenAccountPage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		waitUtils.waitForUrlToBe("https://www.upgrade.com/deposit/apply/account-email?pdc=DEP_CH_03");
		emailTextField.sendKeys(email);	
	}
	
	public void clickGetStartButton() {
		getStartButton.click();
	}
	
	public String getEmailInvaidError() {
		waitUtils.waitForVisibility(invalidEmailErrorMessage);
		return invalidEmailErrorMessage.getText();
	}
	
	public String getEmailEmptyError() {
		waitUtils.waitForVisibility(emptyEmailErrorMessage);
		return emptyEmailErrorMessage.getText();
	}

	public void clickSignIntoGetStartLink(){
        signIntoGetStartLink.click();
    }

}
