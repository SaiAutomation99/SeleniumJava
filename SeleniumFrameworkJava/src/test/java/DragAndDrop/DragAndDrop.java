package DragAndDrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
	Actions action=new Actions(driver);
	action.dragAndDrop(driver.findElement(By.xpath("//h5[text()='High Tatras']")), driver.findElement(By.xpath("//div[@id='trash']"))).build().perform();
		
		
		try {
			
			Thread.sleep(3000);
			
			driver.quit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	

	}

}
