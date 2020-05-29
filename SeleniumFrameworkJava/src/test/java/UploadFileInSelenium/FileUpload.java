package UploadFileInSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver_latest.exe");
		driver=new ChromeDriver();

		driver.get("https://www.monsterindia.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		action=new Actions(driver);
		String window1=driver.getWindowHandle();
		System.out.println(window1);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Upload Resume']"))).click().build().perform();
		Set<String> windoww2=driver.getWindowHandles();
		System.out.println(windoww2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='or select file to upload']"))));
		action.moveToElement(driver.findElement(By.xpath("//form[@name='parsingResponseForm']//div//button"))).click().build().perform();
		Thread.sleep(3000);

		String h=driver.findElement(By.xpath("//p[text()='Drag and drop file here']")).getText();

		System.out.println(h);
		StringSelection selection=new StringSelection("C:\\Users\\Sai\\Desktop\\statucode.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		String w=driver.findElement(By.xpath("(//div[@class=' uploadBtnCont']//p)[1]")).getText();

		System.out.println(w);
		if(w.contains("pdf")) {

			System.out.println("uploaded success");
		}
		else {
			System.out.println("not");
			System.out.println();
			System.out.println();
						System.out.println();

		}
		driver.quit();  //comment added

	}

}
