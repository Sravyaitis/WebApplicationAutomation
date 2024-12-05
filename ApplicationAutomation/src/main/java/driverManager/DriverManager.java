package driverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverManager {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	Properties prop;
	
	public WebDriver initialize_browser() throws IOException {
		
		prop=new Properties();
		
		String path=System.getProperty("user.dir")+"//src//main//resources//Global.properties";
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
	
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			driver= new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void open_app() throws IOException {
		driver=initialize_browser();
		driver.get(prop.getProperty("url"));
		
		
		DriverHolder.setDriver(driver);

        DriverHolder.getDriver().manage().window().maximize();
        DriverHolder.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverHolder.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        wait = new WebDriverWait(DriverHolder.getDriver(),Duration.ofSeconds(10));
       // test = extent.createTest(method.getName());
	}
	
//	public void tearDown() {
//		if(DriverHolder.getDriver() != null){
//    		DriverHolder.getDriver().quit();
//		}
//	}

}
