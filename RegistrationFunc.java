package com.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFunc {
	
	WebDriver driver;
	
		   public RegistrationFunc(WebDriver driver)
		   {
			   this.driver=driver;
		   }
		   
		  private void takeScreenshot(String methodName) throws IOException {
		        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        String timestamp = String.valueOf(System.currentTimeMillis());
		        String screenshotPath = "C:\\Users\\user\\eclipse-workspace\\CpastoneProject_E_commerce\\Screenshots" + methodName + "_" + timestamp + ".png";
		        File destinationFile = new File(screenshotPath);
		        FileHandler.copy(screenshot, destinationFile);
		        System.out.println("Screenshot taken for " + methodName + ": " + screenshotPath);
		    }
			public void newregisrter(String id ,String pass) throws IOException
			{ 

				driver.findElement(By.partialLinkText("Sign up")).click();
				driver.findElement(By.id("sign-username")).sendKeys(id);
				driver.findElement(By.id("sign-password")).sendKeys(pass);
				driver.findElement(By.xpath("//button[@onclick='register()']")).click();
			}
			public void login(String id , String pass) throws IOException
			{   
				driver.findElement(By.partialLinkText("Log in")).click();
				driver.findElement(By.id("loginusername")).sendKeys(id);
				driver.findElement(By.id("loginpassword")).sendKeys(pass);
				driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
				String title=driver.getTitle();
			    if(title.contains("STORE"))
			    {
			    	System.out.println("title match");
			    }
			    else
			    {
			    	System.out.println("title does not match");
			    }
			    takeScreenshot("login");
			}
			public void productbrowsing() throws IOException
			{   
				  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			    WebElement op1=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
				op1.click();
				List <WebElement>l1;
				l1=driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
				int length=l1.size();
			    System.out.println("size of phone :"+length);
				for(WebElement a:l1)
				{
					System.out.println("phoneList:"+ a.getText());
				}
				 takeScreenshot("productbrowsing");
		}
			  public void ProductDetailPage() throws InterruptedException, IOException
			  {
				  Thread.sleep(2000);
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			  try
			  {
			  driver.findElement(By.partialLinkText("Samsung galaxy s6")).click();
			  driver.findElement(By.partialLinkText("Add to cart")).click();
			  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			  System.out.println(alert.getText());
			  alert.accept();  

			  }
			  catch(Exception e)
			  {
				  System.out.println("NA");
			  }
			  takeScreenshot("ProductDetailPage");
		}
			  public void shoppingCart() throws IOException
			  {  		  //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 
				  try {
					  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Cart"))).click();
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalp")));
					 
					 driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
					
				  }
				  catch(Exception e)
				  {
					  System.out.println("NA");
				  }
				  takeScreenshot("shoppingCart");
			  }
			  public void checkoutprocess_Name(String name ,String country ,String city ,String card ,String month ,String year) throws IOException
				{
				  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
				  driver.findElement(By.id("name")).sendKeys(name);
				  driver.findElement(By.id("country")).sendKeys(country);
				  driver.findElement(By.id("city")).sendKeys(city);
				  driver.findElement(By.id("card")).sendKeys(card);
				  driver.findElement(By.id("month")).sendKeys(month);
				  driver.findElement(By.id("year")).sendKeys(year);
				  driver.findElement(By.xpath("//button[text()='Purchase']")).click();
				  takeScreenshot("checkoutprocess_Name");
				}
		 
				  
				  public void OrderConfirmation() throws IOException
				  {
			      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert > h2")));
				  WebElement confirmationMessage = driver.findElement(By.cssSelector(".sweet-alert > h2"));
		          System.out.println("Order Confirmation: " + confirmationMessage.getText());
		          takeScreenshot("OrderConfirmation");
				  }
		          public void clickOnOk() throws IOException
		          {
		        	  try {
		          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		          WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		          JavascriptExecutor js = (JavascriptExecutor) driver;
		          js.executeScript("arguments[0].click();", okButton);
		          System.out.println("Successfully clicked OK button."); 
		        	  }
		        	  catch(Exception e)
		        	  { 
		        		  System.out.println("NA");
		        	  }
		        	  takeScreenshot("clickOnOk");
				  }

}
