package HeatmapClickmap.HandC;

import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.Courses;
import pageobjects.Footer;
import pageobjects.selectingCourse;

public class HomePage1 extends BaseTest {
	@Test
	public void testCase() throws InterruptedException {
		String chooseScreenSize="iPhone 12"; 
		String ipadScreenSize="Ipad Pro";
		String course="Software Testing";
		String selectToCourse = "Software Tester";
			homepage.hoverAndClick();
Footer	testingacadmey=	homepage.switchWindow();
testingacadmey.switchFrame();
testingacadmey.screenSize(chooseScreenSize);
Courses courses=testingacadmey.ipad(ipadScreenSize);
courses.loadCourses();
selectingCourse coursetoselect=courses.searchCourse(course);
coursetoselect.selectcourse(selectToCourse);
	}
	
	
	

}
