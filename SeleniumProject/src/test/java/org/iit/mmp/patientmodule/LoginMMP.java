package org.iit.mmp.patientmodule;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMMP{
	
	@Parameters({"UN1","PWD1","url"})
	@Test
	public void login(String UN1 , String PWD1 , String url)
	{   
		//Launch Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Enter Valid Username,Password
		driver.findElement(By.id("username")).sendKeys(UN1);
		driver.findElement(By.id("password")).sendKeys(PWD1);
		driver.findElement(By.name("submit")).click();
		//Validate Login
		String actual = driver.findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println("The username on the homepage is " +actual);
		String expected = UN1;
	    Assert.assertEquals(actual, expected);
		System.out.println("Login successful");
		
		//Logout
		driver.close();
		
	}

}



////h3[contains(text(),'ria1')]

//String url = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";

	// @DataProvider(name = "test1")
	  // public static Object[][] loginData() {
	  //    return new Object[][] {{"ria1", "Ria12345"}, {"sample", "sample"}};
