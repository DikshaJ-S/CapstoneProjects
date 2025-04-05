package com.ecommerce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Registration.RegistrationFunc;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class Registration_Test {
	WebDriver driver;
	RegistrationFunc rp;
	  ExtentReports extent;
	    ExtentTest test;
	  //  String screenshotPath;

@BeforeClass
public void setup() {
	   driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.demoblaze.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
	   rp=new RegistrationFunc(driver);
	   ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports/ExtentReportEcommercePage.html"); // Report will be saved here
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
      test = extent.createTest("E-commerce Test", "End to End Testing");
     // String screenshotPath;

}
private void takeScreenshot() throws IOException {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String timestamp = String.valueOf(System.currentTimeMillis());
    String screenshotPath = "C:\\Selenium\\SeleniumModule\\Capstone_E-Commerce\\Screenshots" + timestamp + ".png";
    File destinationFile = new File(screenshotPath);
    Files.copy(screenshot, destinationFile);
    test.addScreenCaptureFromPath(screenshotPath);
}

@Test(enabled=false)
public void newregister() throws IOException
{
	  try {
	  test.info("Starting new registration...");
	  rp.newregisrter("newautomation", "test01");
	  takeScreenshot();
	  test.pass("New registration successful.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("New registration failed: " + e.getMessage());
    }
}
@Test(priority=1)
public void logintest() throws IOException
{   
	  try {
	 test.info("Testing login functionality...");
	  rp.login("newautomation", "test01");
	  takeScreenshot();
	  test.pass("Login successful.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("Login failed: " + e.getMessage());
    }
}
@Test(priority=2)
public void productbrowsing() throws IOException
{
	  try {
    test.info("Testing product browsing...");
	  rp.productbrowsing();
	  takeScreenshot();
	  test.pass("Product browsing successful.");
	  }
	  catch (Exception e) {
		  takeScreenshot(); 
        test.fail("Product browsing failed: " + e.getMessage());
        throw new RuntimeException("Product browsing failed", e);
    }
}

@Test(priority=3)
public void pro_detailpage() throws InterruptedException, IOException
{
	  try {
    test.info("Testing product detail page...");
    takeScreenshot();
	  rp.ProductDetailPage();
	  test.pass("Product detail page opened.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
    test.fail("Failed to open product detail page: " + e.getMessage());
    }
}
@Test(priority=4)
public void shoppingcart() throws IOException
{ 
	  try {
    test.info("Testing shopping cart...");
	  rp.shoppingCart();
	  takeScreenshot();
	  test.pass("Shopping cart accessed successfully.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("Shopping cart access failed: " + e.getMessage());
    }
}
@Test(priority=5)
public void checkout() throws IOException
{ 
	  try {
        test.info("Testing checkout process...");
	  rp.checkoutprocess_Name("ABC","India","Pune","123 456 789","06","2025");
	  takeScreenshot();
	  test.pass("Checkout process completed successfully.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("Checkout process failed: " + e.getMessage());
    }

}
@Test(priority=6)
public void orderconfirmationmessage() throws IOException
 {
	  try {
    test.info("Testing order confirmation message...");
	  rp.OrderConfirmation();
	  takeScreenshot();
	  test.pass("Order confirmation successful.");
	  }
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("Order confirmation failed: " + e.getMessage());
    }

 }
@Test(priority=7)
public void clickOnOk() throws IOException
{
	  try {
    test.info("Clicking on OK button...");
	  rp.clickOnOk();
	  takeScreenshot();
	  test.pass("Successfully clicked on OK button.");
}
	  catch (Exception e) {
		  takeScreenshot();
        test.fail("Failed to click OK button: " + e.getMessage());
    }
}

@AfterMethod
public void afterMethod() {
    extent.flush();
}

}
