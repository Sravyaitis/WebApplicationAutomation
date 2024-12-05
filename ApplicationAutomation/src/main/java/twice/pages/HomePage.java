package twice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class HomePage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	
//	@FindBy(xpath="//a[@aria-label='Open a Rewards']")
//	private WebElement openAccountButton;
//	
//	@FindBy(xpath="//a[@class='' and normalize-space()='Sign In']")
//	private WebElement signInButton;
//	
//	@FindBy(xpath="//tagname[@attribute='value' and @href='/upgrade/' ]")
//	private WebElement personalLoanTab;
//	
//	@FindBy(xpath="//tagname[contains(@href,'/upgrade/') and contains(.,'cash back')]")
//	private WebElement seeAllUpgradeCardTab;
//	
//	@FindBy(xpath="//span[@class=''][normalize-space()='cash back'] ")	
//	private WebElement oneCardTab;
//	
//	@FindBy(xpath="//span[contains(text(),'')]")
//	
//	@FindBy(xpath="//")
	
	
	 	@FindBy(xpath = "//a[@aria-label='Open a Rewards Checking Plus account']")
	    private WebElement openAccountButton;

	    @FindBy(xpath = "//a[@class='sc-aXZVg gNjRYj header-nav-menu__btn' and normalize-space()='Sign In']")
	    private WebElement signInButton;

	    @FindBy(xpath = "//a[@class='styles__StyledLink-sc-1fivs3v-10 fkPwnw sc-aXZVg gNjRYj' and @href='/personal-loans/']")
	    private WebElement personalLoanTab;

	    @FindBy(xpath = "//a[contains(@href, '/upgrade-card/') and contains(., 'EARN UP TO 3% CASH BACK')]")
	    private WebElement seeAllUpgradeCardTab;

	    @FindBy(xpath = "//span[@class='styles__StyledText-sc-1hgzk9e-0 styles__CategoryText-sc-c16oa6-4 jwdbRc bCzeVf'][normalize-space()='OneCard']")
	    private WebElement oneCardTab;

	    @FindBy(xpath = "//span[contains(text(),'Premier Savings')]")
	    private WebElement premierSavingTab;

	    @FindBy(xpath = "//span[@class='styles__StyledText-sc-1hgzk9e-0 styles__CategoryText-sc-c16oa6-4 jwdbRc bCzeVf'][normalize-space()='Rewards Checking Plus']")
	    private WebElement rewardCheckingTab;

	    @FindBy(xpath = "//p[@class='styles__StyledText-sc-1hgzk9e-0 ggoqyf'][normalize-space()='Buy Now, Pay Later']")
	    private WebElement flexPayTab;
	    
	    @FindBy(xpath="//footer[@class='sc-dLMFU guiNMQ footer']")
	    private WebElement footer;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils=new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOpenNewAccountButton() {
		waitUtils.waitForElementToBeClickable(openAccountButton);
		openAccountButton.click();
	}
	
	public void clickPersonalLoanTab() {
		waitUtils.waitForVisibility(personalLoanTab);
		personalLoanTab.click();
	}
	
	public void clickSeeAllUpgradeCardTab() {
		waitUtils.waitForVisibility(seeAllUpgradeCardTab);
		seeAllUpgradeCardTab.click();
	}
	
	public void clickOneCardTab() {
		waitUtils.waitForVisibility(oneCardTab);
		oneCardTab.click();
	}
	
	public void clickPremierSavingTab() {
		waitUtils.waitForVisibility(premierSavingTab);
		premierSavingTab.click();
	}

	public void clickRewardCheckingTab() {
		waitUtils.waitForVisibility(rewardCheckingTab);
		rewardCheckingTab.click();
	}
	

	public void clickFlexPayTab() {
		waitUtils.waitForVisibility(flexPayTab);
		flexPayTab.click();
	}
	
	public void scrollToFooter() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",footer);
	}
	
	public void clickFooterLinks(String linkText) {
		waitForPageToLoad();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", footer);
		
		WebElement footerLink = driver.findElement(By.xpath("//a[normalize-space()='"+linkText+"']"));
		waitUtils.waitForElementToBeClickable(footerLink);
		
		footerLink.click();
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitUtils.waitUntil(driver -> {
			String readyState=js.executeScript("return document.readyState").toString();
			return readyState.equals("complete");
		});
	}
}
