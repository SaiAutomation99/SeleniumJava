package Dropdown;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownHandling {
	
	public static WebDriver driver=null;

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		WebElement elem=driver.findElement(By.xpath("//div[@class='information closable']//following::select"));
//		
//		Select select=new Select(elem);
//		
//		select.selectByVisibleText("Algeria");
		
		//driver.findElement(By.xpath("))
		
		
		
		
		List<WebElement> elements=driver.findElements(By.xpath("//div[@class='information closable']//following::select//option"));
		
		listElements(elements);
		System.out.println(elements.size());
		
		try {
			
			Thread.sleep(3000);
			
			driver.quit();
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	private static void listElements(List<WebElement> elements) {
for(int i=1;i<elements.size();i++) {
			
			String name=driver.findElement(By.xpath("(//div[@class='information closable']//following::select//option)"+"["+i+"]")).getText();
			System.out.println(name);
			
		}
				
	}

}
