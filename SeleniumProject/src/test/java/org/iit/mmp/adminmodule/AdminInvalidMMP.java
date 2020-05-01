package org.iit.mmp.adminmodule;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminInvalidMMP {

	@Parameters({"U2","P2","url"})
	@Test
	public void login(String U2 , String P2 , String url)
	{   
		//Launch Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Enter Valid Username ,Password
		driver.findElement(By.id("username")).sendKeys(U2);
		driver.findElement(By.id("password")).sendKeys(P2);
		driver.findElement(By.name("admin")).click();
		
		//Handling alert and validating response
		
		Alert alrt = driver.switchTo().alert();
		String txt = alrt.getText();
	    System.out.println("Alert message received is :: " + txt);
		alrt.accept();
		if(txt == "Wrong username and password");
		  System.out.println("The pop-up message is validated.");
		
		  driver.close();
		  
	}	
}
