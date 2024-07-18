package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectingCourse {
	WebDriver driver;
	
public selectingCourse(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

@FindBy (className="dynamic-heading")
List<WebElement> courseText;

@FindBy (xpath="(//div[@class='form-group'])[1]")
WebElement enroll;

public void selectcourse(String courseToSelect) {
	System.out.println(courseText.size());
	int k=0;
// String courseName=	courseText.getText();
	for(int i=0; i<courseText.size(); i++) {
		
		
 if (courseText.get(i).getText().contains(courseToSelect)) {
	 k++;
	 System.out.println("No of courses contains" + courseToSelect + "is" +k);
	 courseText.get(i).click();
	// enrollInCourse();
 }	 
 }

}
//public void enrollInCourse() {
	//enroll.click();
//}
}
