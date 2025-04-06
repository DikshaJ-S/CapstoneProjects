package com.adminTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.adminPage.Adminpage;

public class AdminpageTest {
	
	WebDriver driver;

	Adminpage  ap;

	 @BeforeClass
	 public void setup() {
		 WebDriver driver =new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ap=new Adminpage(driver);

		}
	 @Test(priority=1)
	 public void login1()
	 {    
		  ap.Login("Admin", "admin123");
	}
	 @Test(priority=2)
	 public void click() {
		 ap.clickOnButton();
	 }
	 @Test(priority=3)
	 public void leftsideoption()
	 {
		ap.leftsideoptionAdnclickOnAdminOption();

	 }
	 @Test(priority=4)
	 public void pageload()
	 {
		 ap.loadAdminpage();
	 }
	  @Test(priority=5)
	 public void userName() throws InterruptedException
	 {
		 ap.searchUserName();
	 }
	  @Test(priority=6)
	 public void userRole() throws InterruptedException
	 {
		 ap.searchUserRole();
	 }
	 @Test(priority=7)
	  public void searchStatus()
	  {
		  ap.Status();
	  }

}
