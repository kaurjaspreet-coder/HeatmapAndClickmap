package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void waitElementToAppear(WebElement firstYoutubeLink) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(firstYoutubeLink));
	}
	//ExpectedCondition < WebElement > elementToBeClickable(By locator)
	
	public void waitElementToClickable(WebElement clickable) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(clickable));
	}
	public void frame(WebElement iframe) {
		driver.switchTo().frame(iframe);
		
	}
	
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}
}
