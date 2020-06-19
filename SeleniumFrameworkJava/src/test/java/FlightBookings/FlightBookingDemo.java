package FlightBookings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlightBookingDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://phptravels.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//li[@class='yx-njv js-mega-nav__item']//button[contains(text(),'Links')]"))).build().perform();
		driver.findElement(By.xpath("//li[@class='yx-njv js-mega-nav__item']//button[contains(text(),'Links')]")).click();
		driver.findElement(By.xpath("//a[text()='Flight Booking Engine']")).click();
		String titlename=driver.getTitle();
		System.out.println(titlename);
		String textname=driver.findElement(By.xpath("//a[text()='Android']")).getText();
		System.out.println(textname);
		driver.quit();
	}

}
