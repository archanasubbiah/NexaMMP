package org.iit.mmp.adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotLogin{
	String url = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
 public void forgotusername(String url) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
    driver.findElement(By.linkText("forgot Username / Password")).click();
    String actual = driver.findElement(By.xpath("//div[@id='container_demo']//h1[contains(text(),'Forget Password')]")).getText();
    String expected = "Forget Password";
    Assert.assertEquals(actual, expected);
    
    
    
	
}	
}
