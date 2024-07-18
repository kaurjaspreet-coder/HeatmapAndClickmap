package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponents {
	 public WebDriver driver;
	
	
	public HomePage(WebDriver driver ) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="(//div[@class='screenshot-thumb ng-isolate-scope'])[1]")
	WebElement firstYoutubeLink;

public void goTo() throws InterruptedException {
	driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
	waitElementToAppear(firstYoutubeLink);
}

public void hoverAndClick() throws InterruptedException {
Actions cursor=new Actions(driver);
cursor.moveToElement(firstYoutubeLink).build().perform();
firstYoutubeLink.click();
Thread.sleep(5000);
//System.out.println(driver.getTitle());
//driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@id='heatmap-iframe'])[1]")));

}

public Footer switchWindow() {
	Set<String> windows= driver.getWindowHandles();
Iterator<String> it=	windows.iterator();
String	parentWindow=it.next();
String childWindow= it.next();
driver.switchTo().window(childWindow);
Footer testingacademy= new Footer(driver);
return testingacademy;
}
}