package org.iit.mmp.patientmodule;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class InvalidLoginMMP {
    @Test(description = "invalidLogin") 
    @Parameters({"UN2","PWD2","url"})
	public void invalidLogin(String UN2 , String PWD2 , String url) {
	
		//Launch Browser with url
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Enter invalid login details
		driver.findElement(By.id("username")).sendKeys(UN2);
		driver.findElement(By.id("password")).sendKeys(PWD2);
		driver.findElement(By.name("submit")).click();
		
		//Handling alert and validating response
		
		Alert alrt = driver.switchTo().alert();
		String txt = alrt.getText();
	    System.out.println("Alert message received is :: " + txt);
		alrt.accept();
		
		if(txt == "Wrong username and password");
		  System.out.println("The pop-up message is validated.");
			
		//Logout
		driver.close();
		
		
		
		
		//Admin Login VerifyTitle
		//driver.findElement(By.xpath("//ul[@id='navigation']//li//a[contains(text(),'Office Login')]"));
		//driver.findElement(By.xpath("//section[@id='features']//a[1]"));
		//String actual = driver.getTitle();
		//String expected = "Login1";
		//Assert.assertEquals(actual,expected);
		//System.out.println("Title Verified");
		
		//Enter Valid Login Details
		
	}
}
