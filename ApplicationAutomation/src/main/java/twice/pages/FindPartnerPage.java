package twice.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WaitUtils;

public class FindPartnerPage {

	private WebDriver driver;
	private WaitUtils waitUtils;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//div[@class='sc-cPiKLX czKZZk']/div")
	private List<WebElement> partnerList;
	
	public FindPartnerPage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils= new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterPartnerName(String partnerName) {
		waitForLoad();
		WebElement searchBox=searchTextBox;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", searchBox);
		waitUtils.waitForElementToBeClickable(searchBox);
		searchBox.sendKeys(partnerName);
		
	}

	private void waitForLoad() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		waitUtils.waitUntil(driver -> {
		String readyState=js.executeScript("return document.readyState").toString();
		return readyState.equals("complete");
	});

	}
	
	
	public void clickSearchedPartner(String partnerName) {
		
		for(WebElement partner : partnerList) {
			
			String partnerImageXPath="//div[@class='sc-cPiKLX czKZZk']/div/a/div/img[normalize-space(@alt)='"+partnerName+"']";
			
			try {
				//find the partner image
				WebElement partnerImage=partner.findElement(By.xpath(partnerImageXPath));
				partnerImage.click();
				break;
				
			} catch(NoSuchElementException e) {
				System.out.println("Partner Image not found: "+partnerName);
			}
		
		}
	}
		
}
