package WebTable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		String title=driver.getTitle();
		System.out.println(title);
		List<WebElement> elements=	driver.findElements(By.xpath("//table[@class='dataTable']//tr/td"));
		for (int i = 0; i < elements.size(); i++) {
			
			String name=elements.get(i).getText();
			if(name.equalsIgnoreCase("UCO Bank")) {
				
				System.out.println("conatins");
				break;
			}
			
		}
		
		LinkedHashMap<String, String> link=new LinkedHashMap<String, String>();
		
		List<WebElement> elementnames=	driver.findElements(By.xpath("//table[@class='dataTable']//tr/td/a"));
		
		List<WebElement> values=	driver.findElements(By.xpath("//table[@class='dataTable']//tr/td/font"));
		for (int i = 0; i < elementnames.size(); i++) {
			
			//System.out.println(elementnames.get(i).getText());
			
			//for(int j=i;j<values.size();j++) {
				
				
				link.put(elementnames.get(i).getText(), values.get(i).getText());
				
			}
		List<WebElement> ele=driver.findElements(By.xpath("//div[contains(@class,'tabs')]"));
		for (int i = 0; i < ele.size(); i++) {
			
			ele.get(i).click();
			System.out.println("clicked");
			
		}
		
		
		System.out.println(link);
		
		driver.quit();

	}

}
