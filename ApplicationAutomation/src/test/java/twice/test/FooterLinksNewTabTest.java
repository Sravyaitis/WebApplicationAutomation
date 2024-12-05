package twice.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverManager.DriverManager;
import twice.pages.HomePage;
import utils.WaitUtils;

public class FooterLinksNewTabTest extends DriverManager{
	
	private HomePage homePage;
    private WaitUtils waitUtils;

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.upgrade.com/");
        homePage = new HomePage(driver);
        waitUtils = new WaitUtils(driver);
    }
    @Test
    public void checkFooterLinksOpenInNewTabs(){

        Object[][] linkTextsAndExpectedUrls = {
                {"Personal Loans", "https://www.upgrade.com/personal-loans/"},
                {"Upgrade Cards", "https://www.upgrade.com/upgrade-card/"},
                {"Upgrade OneCard", "https://www.upgrade.com/one-card/"},
                {"Premier Savings", "https://www.upgrade.com/premier-savings/"},
                {"Auto Refinance", "https://www.upgrade.com/auto-refi/"},
                {"Auto Finance: Customers", "https://www.upgrade.com/auto-finance/"},
        };

        for (Object[] linkTextAndExpectedUrl : linkTextsAndExpectedUrls) {
            String link = (String) linkTextAndExpectedUrl[0];
            String expectedUrl = (String) linkTextAndExpectedUrl[1];


            homePage.clickFooterLinks(link);

            homePage.waitForPageToLoad();

            waitUtils.waitForUrlToBe(expectedUrl);
            String currentUrl = driver.getCurrentUrl();

            waitUtils.waitForUrlToBe(expectedUrl);

            Assert.assertEquals(currentUrl, expectedUrl, "Footer link did not redirect to the correct URL for: " + link);
        }
    }
}
