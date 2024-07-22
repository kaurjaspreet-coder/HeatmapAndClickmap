package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends AbstractComponents{
	WebDriver driver;
public Footer(WebDriver driver) {
	super(driver);
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//iframe[@id='heatmap-iframe']")
WebElement heatMapFrame;

@FindBy (css=".slider-handle.js-slider-handle")
WebElement slideBar;

@FindBy(id="platform-box")
WebElement screenView;
 
@FindBy(xpath="//a[@title='Mobile']")
WebElement mobileView;

@FindBy(xpath="//div[@id='heatmap-player']/div/div[3]")
WebElement clickMap;

@FindBy(css="a[class='btn']")
WebElement screenSizeDropDown;

@FindBy (className="Pos(r)")
List<WebElement> differentScreenSize;

@FindBy (xpath="(//a[@title='click to rotate'])[2]")
WebElement rotateScreen;

@FindBy(xpath="//a[@title='iPad']")
WebElement ipadView;

@FindBy(id="device_width")
WebElement width;

@FindBy(id="device_height")
WebElement height;



public void switchFrame() throws InterruptedException {
	
	frame(heatMapFrame);
	Actions slide=new Actions(driver);	
	slide.dragAndDropBy(slideBar, -10,0).perform();
	//System.out.println(slideBar.getLocation());
	screenView.click();
	mobileView.click();
	//or driver.findElement(By.xpath("//div[@id='heatmap-player']/div/div[1]/following-sibling::div[2]")).click()
clickMap.click();
}

public void screenSize(String chooseScreenSize) throws InterruptedException {
	defaultContent();
	Thread.sleep(3000);
	screenSizeDropDown.click();
	getScreenSize(chooseScreenSize);
}

public Courses ipad(String tab) throws InterruptedException {
	frame(heatMapFrame);
	screenView.click();
	ipadView.click();
	defaultContent();
	Thread.sleep(3000);
	screenSizeDropDown.click();
	getScreenSize(tab);
	Courses courses= new Courses(driver);
	return courses;
	
}

public void getScreenSize(String screenSize) {
	for(int i=0; i<differentScreenSize.size();i++) {
		if (differentScreenSize.get(i).getText().equals(screenSize)) {
			differentScreenSize.get(i).click();
	System.out.println("Screen width:"+(width).getAttribute("value"));
	System.out.println("Screen height:" +(height).getAttribute("value"));
	rotateScreen.click();
	System.out.println("Screen width:"+(width).getAttribute("value"));
	System.out.println("Screen height:" +(height).getAttribute("value"));
		}}	
}
}                      