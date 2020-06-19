package BlueDartWebSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlueDart {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bluedart.com/tracking");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-remove']")).click();
	WebElement element=	driver.findElement(By.xpath("//label[@id='awbRadioDiv']//input"));
	
	WebDriverWait wait=null;
	if(element.isSelected()) {
		
		
		 wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@id='refRadioDiv']//input"))));
		driver.findElement(By.xpath("//label[@id='refRadioDiv']//input")).click();
		System.out.println("clicked");
		
	}else {
		
		System.out.println("not clicked");
	}
	
	driver.findElement(By.xpath("//textarea[@id='trackingNo']")).sendKeys("79034111166");
	driver.findElement(By.xpath("//input[@id='goBtn']")).click();
	
	try {
	
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='alert alert-danger wrap-track']"))));
	String name=driver.findElement(By.xpath("//div[@class='alert alert-danger wrap-track']")).getText();
	if(name!=null) {
		
		System.out.println(name);
		if(name.contains("Not")) {
			
			
			System.out.println("correct");
		}
	}else{
		System.out.println("not correct");
		
	}
	try {
	
	Thread.sleep(300);
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	


	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		driver.quit();
	}
	
	}

}
