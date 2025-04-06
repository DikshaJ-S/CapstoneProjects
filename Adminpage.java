package com.adminPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminpage {
	
	WebDriver driver;
	   public Adminpage(WebDriver driver)
	   {
		  this.driver=driver;
	   }

	public void Login(String id ,String pass ) 
	  {
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(id);
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys(pass);
	  }
		public void clickOnButton() 
		{
		WebElement button1=driver.findElement(By.xpath("//button[@type='submit']"));
		button1.click();
		}

	  public void leftsideoptionAdnclickOnAdminOption()
	  { 
		  List <WebElement> option;
		   option=driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']"));
		   int length=option.size();
		   for(WebElement a:option)
		   {
			   String optionText = a.getText();
			   System.out.println("AllOptions: " + optionText);
			   if(optionText.contains("Admin"))
			   { 
			   a.click();
			   break; 
			  }
		 }
	}


	  public void loadAdminpage()
	  {  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		  System.out.println("Admin page has loaded successfully.");
	  }
	   public void searchUserName() throws InterruptedException 
	   {   
		 //*[@id="app"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input
		WebElement a=   driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
	    a.sendKeys("Admin");
	    WebElement b= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
	    b.click();
	    Thread.sleep(20);
	    List<WebElement>c;
	   c= driver.findElements(By.xpath(" //div[@class='orangehrm-container']"));
	  int data=c.size();
	   System.out.println(data);
	   for(WebElement d : c)
	   {
		   String data1 = d.getText();
		   System.out.println("reachresult: " + data1);
	   }
	    driver.navigate().refresh();
	   }

	   public void searchUserRole() throws InterruptedException
	    {
		   try
		   {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		   WebElement a= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div"));
	       a.click();
	       Select s=new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]")));
	       s.selectByVisibleText("Admin");
	       WebElement search= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
	       search.click();
	       List <WebElement>b;
	       b=driver.findElements(By.className("oxd-table-card-cell-checkbox"));
	       for(WebElement d :b)
	       {
	    	   String data = d.getText();
	    	   System.out.println("rearch result: " + data);
	       }
		   }
		   catch(Exception e)
		   {
			   System.out.println("NA");
		   }
		   driver.navigate().refresh();
	    }
	   public void Status()
	   {
		   try {
		   WebElement a=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i"));
		   a.click();
		   Select s= new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]")));
	       Thread.sleep(20);      
		   s.selectByVisibleText("Enabled"); 
	       List<WebElement>b;
	       b=driver.findElements(By.className("oxd-table-row oxd-table-row--with-border"));
	       for(WebElement data :b)
	       {
	    	   String result = data.getText();
	    	   System.out.println("rearch result: " + result);
	       }
		   }
		   catch(Exception e)
		   {
			  System.out.println("NA"); 
		   }
	   }

}
