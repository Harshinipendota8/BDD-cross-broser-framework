package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	
	private static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return td.get();
	}
	

	public static void Initialization(String browsername) {
		
	 WebDriver driver=null;

		if (browsername.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
			td.set(driver);
		} 
		else if (browsername.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
			td.set(driver);
		}

		else if (browsername.equalsIgnoreCase("incognito"))
		{
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);

		}
       Dimension d = new Dimension(900,900);
       driver.manage().window().setSize(d);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
