package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Footer extends AbstractComponents{
	WebDriver driver;
public Footer(WebDriver driver) {
	super(driver);
		
	this.driver=driver;
}

public void switchFrame() throws InterruptedException {
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='heatmap-iframe']")));
	WebElement slider=	driver.findElement(By.cssSelector(".slider-handle.js-slider-handle"));
	Actions slide=new Actions(driver);
System.out.println(slider.getLocation());	
	slide.dragAndDropBy(slider, -10,0).perform();
	System.out.println(slider.getLocation());
	driver.findElement(By.id("platform-box")).click();
	
	driver.findElement(By.xpath("//a[@title='Mobile']")).click();
	//Thread.sleep(7000);
	//slide.moveByOffset(150, 150);
	//slide.build().perform();
	//System.out.println(driver.findElements(By.tagName("iframe")).size());
	//or driver.findElement(By.xpath("//div[@id='heatmap-player']/div/div[1]/following-sibling::div[2]")).click()
	WebElement clickMap=driver.findElement(By.xpath("//div[@id='heatmap-player']/div/div[3]"));
	//waitElementToAppear(clickMap);
clickMap.click();
	//driver.switchTo().defaultContent();
//driver.findElement(By.xpath("//div[@id='mobile-selection-container']")).click();
//List<WebElement> screenSize= driver.findElements(By.className("Pos(r)"));
//for(int i=0; i<screenSize.size();i++) {
//	System.out.println(screenSize.get(i));
//}


}
public void screenSize(String chooseScreenSize) throws InterruptedException {
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("a[class='btn']")).click();
	
	List<WebElement> differentScreenSize= driver.findElements(By.className("Pos(r)"));
	for(int i=0; i<differentScreenSize.size();i++) {
		if (differentScreenSize.get(i).getText().contains(chooseScreenSize)) {
			differentScreenSize.get(i).click();
	System.out.println(differentScreenSize.get(i).getText());
	System.out.println("Screen width:"+(driver.findElement(By.id("device_width")).getAttribute("value")));
	System.out.println("Screen height:" +(driver.findElement(By.id("device_height")).getAttribute("value")));
	driver.findElement(By.xpath("(//a[@title='click to rotate'])[2]")).click();
	System.out.println("Screen width:"+(driver.findElement(By.id("device_width")).getAttribute("value")));
	System.out.println("Screen height:" +(driver.findElement(By.id("device_height")).getAttribute("value")));
	//a[@title='click to rotate'])[2]
}}
}
public Courses ipad(String tab) throws InterruptedException {
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='heatmap-iframe']")));
	driver.findElement(By.id("platform-box")).click();
	driver.findElement(By.xpath("//a[@title='iPad']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
driver.findElement(By.cssSelector("a[class='btn']")).click();
	
	List<WebElement> ipadScreenSize= driver.findElements(By.className("Pos(r)"));
	for(int i=0; i<ipadScreenSize.size();i++) {
		if (ipadScreenSize.get(i).getText().equals(tab)) {
			ipadScreenSize.get(i).click();
	System.out.println(ipadScreenSize.get(i).getText());
	System.out.println("Screen width:"+(driver.findElement(By.id("device_width")).getAttribute("value")));
	System.out.println("Screen height:" +(driver.findElement(By.id("device_height")).getAttribute("value")));
	driver.findElement(By.xpath("(//a[@title='click to rotate'])[2]")).click();
	System.out.println("Screen width:"+(driver.findElement(By.id("device_width")).getAttribute("value")));
	System.out.println("Screen height:" +(driver.findElement(By.id("device_height")).getAttribute("value")));
	
	//a[@title='ipad']
	
}
}
	Courses courses= new Courses(driver);
	return courses;
}
}                      