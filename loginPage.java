package com.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	WebDriver driver;
	   public loginPage(WebDriver driver)
	   {
		   this.driver=driver;
	   }
	   
   public void EnterPositiveUsername(String Id ,String pass)
   {
 	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
 	  username.sendKeys(Id);
 	  WebElement Password=driver.findElement(By.name("password"));
 	  Password.sendKeys(pass);
       WebElement click=driver.findElement(By.xpath("//button[@type='submit']"));
		  click.click(); 
		  WebElement logout=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i"));
		  logout.click();
		  driver.findElement(By.partialLinkText("Logout")).click();
	  }

	 public void EnterNegativeusername(String id, String pass)
	 {
	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys(id);
	  WebElement Password=driver.findElement(By.name("password"));
	  Password.sendKeys(pass);
   WebElement click=driver.findElement(By.xpath("//button[@type='submit']"));
	 click.click();  
		/*
		 * WebElement logout=driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i"));
		 * logout.click(); driver.findElement(By.partialLinkText("Logout")).click();
		 */  
	 }
	 public void EnterNegativepassowrd(String id, String pass)
	 {
	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys(id);
	  WebElement Password=driver.findElement(By.name("password"));
	  Password.sendKeys(pass);
   WebElement click=driver.findElement(By.xpath("//button[@type='submit']"));
	 click.click();  
	 }	

}
