package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Courses extends AbstractComponents{
	WebDriver driver;
	public Courses(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (linkText=("ALL COURSES"))
	WebElement courseTab;

	@FindBy (linkText=("Load more"))
	WebElement loadContent;
	
	@FindBy (xpath=("//div[@id='heatmap-player']/div/div[3]"))
	WebElement clickMap;
	
	@FindBy (xpath=("//iframe[@id='heatmap-iframe']"))
	WebElement footerFrame;

	@FindBy (xpath=("//iframe[@id='vwo-mobile-iframe']"))
	 WebElement headerFrame;
	
	@FindBy (xpath=("//select[@name='categories']"))
	WebElement courseCategory;
	
@FindBy(id="course-list")
List<WebElement> courseNumber;

@FindBy(xpath=("//input[@id='search']"))
WebElement searchBar;

@FindBy(css=(".find-course.search-course"))
WebElement searchEnter;

@FindBy(id="course-list")
WebElement noListText;
	
public void numberOfCourses() {
	 int courseListSize= courseNumber.size();
	System.out.println(courseListSize);
	
	
}
public void loadCourses() throws InterruptedException {
	
	frame(footerFrame);
	clickMap.click();
	defaultContent();
	frame(headerFrame);
	courseTab.click();
	//numberOfCourses();
	waitElementToClickable(loadContent);
 loadContent.click();

}


public selectingCourse searchCourse(String course) throws InterruptedException {
	
	//waitElementToAppear(courseCategory);
	Select selectCategory= new Select(courseCategory);
	selectCategory.selectByVisibleText(course);
	Thread.sleep(2000);
	//numberOfCourses();
	//waitElementToClickable(searchBar);
	//searchBar.sendKeys("selenium");
	//searchEnter.click();
	//System.out.println(noListText.getText());
	selectingCourse selectcourse = new selectingCourse(driver);
	return selectcourse;
}
}