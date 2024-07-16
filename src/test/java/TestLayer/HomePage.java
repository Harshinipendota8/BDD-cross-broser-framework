package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import Reusableexcelvalues.Excelpath;
import junit.framework.Assert;

public class HomePage extends BaseClass{
	
	
		@Test(priority = 2)
		public void HomepageTitle() {

			String title = getDriver().getTitle();
			AssertJUnit.assertEquals(title, "OrangeHRM");

		}

//			TC3" validate home page url
		@Test(priority = 3)
		public void HomepageURL() {
			String url = getDriver().getCurrentUrl();
			boolean actualurl = url.contains("orangehrm");
			AssertJUnit.assertEquals(actualurl, true);

		}
		
		@Test(priority = 4)
		public void PIMpage() {
			WebElement wb2 = getDriver().findElement(By.xpath("//span[text()='PIM']"));
			wb2.click();
			String actualPIM = getDriver().getCurrentUrl();
			boolean pimword = actualPIM.contains("pim");
			Assert.assertEquals(pimword, true);

		}
		
		@Test(priority = 5, dataProvider = "UserTestData")
		public void AddEmployee(String firstname, String middlename, String lastname) throws Exception {
			// a[text()="Add Employee"]

			getDriver().findElement(By.xpath("//a[text()='Add Employee']")).click();

			getDriver().findElement(By.name("firstName")).sendKeys(firstname);
			getDriver().findElement(By.name("middleName")).sendKeys(middlename);
			getDriver().findElement(By.name("lastName")).sendKeys(lastname);
	        Thread.sleep(4000);
	        WebElement empid = getDriver().findElement(By.xpath(
					"//div[@class='oxd-form-row']//child::div/label[text()='Employee Id']/parent::div/following-sibling::div/input"));
			String id = empid.getAttribute("value");// 0417
			System.out.println(id);
	        Thread.sleep(4000);

	        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000); 
			getDriver().navigate().refresh();
		}

		@DataProvider(name="UserTestData")
			public Object[][] getTestData() throws Exception
			{
			Excelpath objk = new Excelpath("C:\\Users\\HARSHINI PENDOTA\\OneDrive\\Documents\\new today\\Book2.xlsx");
			Object[][] data = objk.getAllSheetTestData(0);
			return data;
			}
		
		@AfterTest
		public void quittheapp()
		{
			getDriver().quit();
		}
		    
		



}
