import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.PageObject.HomepageObjects;
import com.guru.PageObject.SetupPage;

import commonMethod.UtilitiesScreenShot;

public class TestCase1 {
	WebDriver driver;
	SetupPage setup;
	HomepageObjects homepage;
	UtilitiesScreenShot util
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeTest
	public void getURL(){
		driver = SetupPage.Setup();
		
	}
	
	@Test
	public void Testcase1(){
		
		String title = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(title);
		
		try {
			Assert.assertEquals("THIS IS DEMO SITE FOR ", title);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		homepage = PageFactory.initElements(driver, HomepageObjects.class);
		homepage.click_mobile();
		homepage.sortBy("Name");
		UtilitiesScreenShot.Capture_Shot(driver, "testcase2");
		System.out.print("This is the title 2 /n"  + driver.getTitle());
		UtilitiesScreenShot.Capture_Shot(driver, "testcase1");
	}
	
	@AfterTest
	public void TearDown(){
		driver.quit();
		System.out.println("Running processes closed");
	}
	

}
