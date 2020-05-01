package org.iit.mmp.adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLoginMMP {

	@Parameters({"U1","P1","url"})
	@Test
	public void login(String U1 , String P1 , String url)
	{   
		//Launch Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Enter Valid Username,Password
		driver.findElement(By.id("username")).sendKeys(U1);
		driver.findElement(By.id("password")).sendKeys(P1);
		driver.findElement(By.name("admin")).click();
		
		
		//Validate Login
		String actual = driver.findElement(By.xpath("//div[contains(@class,'left-sidebar')]//li[5]")).getText();
		System.out.println("The submenu found is " +actual);
		String expected = "Patients";
	    Assert.assertEquals(actual, expected);
		System.out.println("Login successful");
		driver.close();
}
}
//Admin Login VerifyTitle
		//driver.findElement(By.xpath("//ul[@id='navigation']//li//a[contains(text(),'Office Login')]"));
		//driver.findElement(By.xpath("//section[@id='features']//a[1]"));
		//String actual = driver.getTitle();
		//String expected = "Login1";
		//Assert.assertEquals(actual,expected);
		//System.out.println("Title Verified");