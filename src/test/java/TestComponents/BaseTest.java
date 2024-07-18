package TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
public	WebDriver driver;
	public HomePage homepage;
	public WebDriver initialize() throws IOException {
		Properties prop= new Properties();
		FileInputStream file=new FileInputStream("C:/Users/jaspr/eclipse-workspace/BookAppt/src/main/java/resources/global.properties");
		prop.load(file);
		String browserName=System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
	//String browserName=	prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webDriver.gecko.driver", "/Users/jaspr/Downloads/geckodriver");
driver= new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

		}     
		return driver;
	}

	@BeforeMethod
	public void launchWebsite() throws IOException, InterruptedException {
		initialize();
		 homepage= new HomePage(driver);
		homepage.goTo();
	}
	public String screenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
	File source=	screenshot.getScreenshotAs(OutputType.FILE);
	File destination = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
	FileUtils.copyFile(source, destination);
	return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png"; 
	}
}
