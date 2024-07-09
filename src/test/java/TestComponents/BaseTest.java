package TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
public	WebDriver driver;
	public HomePage homepage;
	public WebDriver initialize() throws IOException {
		Properties prop= new Properties();
		FileInputStream file=new FileInputStream("C:/Users/jaspr/eclipse-workspace/BookAppt/src/main/java/resources/global.properties");
		prop.load(file);
	String browserName=	prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
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
