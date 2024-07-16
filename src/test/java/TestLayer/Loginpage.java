package TestLayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class Loginpage extends BaseClass{
	@Parameters({"browsername"})
	@BeforeTest
	public void setUp(String browsername) 
	{
		BaseClass.Initialization(browsername);
	}

	@Test
	public void loginFunctionality() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().findElement(By.name("username")).sendKeys("Admin");
		getDriver().findElement(By.name("password")).sendKeys("admin123");
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		getDriver().quit();
	}

	


}
