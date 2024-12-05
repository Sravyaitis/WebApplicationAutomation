package twice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class SignInPage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	
	 @FindBy(xpath = "//input[@name='username']")
	    private WebElement emailTextField;

	    @FindBy(xpath = "//input[@name='password']")
	    private WebElement passwordTextField;
	    
	    @FindBy(xpath = "//button[@aria-label='Sign into your Upgrade Account']")
	    private WebElement signInButton;
	    
	    @FindBy(xpath = "//div[@id='username-2-error' and text()='This field is required']")
	    private WebElement emptyUserNameError;

	    @FindBy(xpath = "//div[@id='password-3-error' and text()='This field is required']")
	    private WebElement emptyPasswordError;
	    
	    @FindBy(xpath = "//div[@id='username-2-error' and normalize-space()='Please enter a valid email.']")	
	    private WebElement invalidUserNameError;

	    @FindBy(xpath = "//div[@class='sc-fmKFGs erczEI']")
	    private WebElement invalidCredentialsError;

	    @FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
	    private WebElement forgotPasswordLink;
	    
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils=new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		emailTextField.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}

	public void ClickSignInButton() {
		signInButton.click();
	}
	
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	
	public String getEmptyUserNameErrorText() {
		waitUtils.waitForVisibility(emptyUserNameError);
		return emptyUserNameError.getText();
	}


	public String getEmptyPasswordErrorText() {
		waitUtils.waitForVisibility(emptyPasswordError);
		return emptyPasswordError.getText();
	}
	
	public String getInvalidUserNameErrorText() {
		waitUtils.waitForVisibility(invalidUserNameError);
		return invalidUserNameError.getText();
	}
	
	public String getInvalidCredentialsErrorText() {
		waitUtils.waitForVisibility(invalidCredentialsError);
		return invalidCredentialsError.getText();
	}
	

}
