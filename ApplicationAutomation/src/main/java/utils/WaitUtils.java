package utils;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Boolean waitForUrlToBe(String url) {
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public List<WebElement> waitForAllElementsPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public boolean waitUntil(Function<WebDriver, Boolean> condition) {
		return wait.until(condition);
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

}
