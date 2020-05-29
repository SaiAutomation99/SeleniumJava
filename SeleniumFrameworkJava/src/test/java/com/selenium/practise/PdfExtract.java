package com.selenium.practise;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfExtract {

	public static void main(String[] args) {
		
		try {
			
			
	//	PDFRenderer reader=new PDFRenderer(null);
			
			
			URL url=new URL("file:///C:/Users/Sai/Downloads/Resume.pdf");
			
			InputStream stream=url.openStream();
			
			BufferedInputStream in=new BufferedInputStream(stream);
			
			PDDocument pd=new PDDocument().load(in);
			PDFTextStripper test=new PDFTextStripper();
			String name=test.getText(pd);			
		String[] sp=name.split("\\r?\\n");
		
		for (String string : sp) {
			//System.out.println(string);
		}
		
		File f=new File("C:\\Users\\Sai\\Downloads");
		File[] files=f.listFiles();
		for (File file : files) {
			//System.out.println(file.getName());
			//System.out.println(file.getAbsoluteFile());
			
			if(file.getAbsoluteFile().toString().contains("Delivery")) {
				//System.out.println("enter if loop");
				//String filepath=file.getName().replaceAll("\\", "\\\\");
			//	System.out.println("filepath---------"+filepath);
				
				
				
				System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
				
				WebDriver driver=new ChromeDriver();
				driver.get(file.getAbsoluteFile().toString());
				//driver.get(filepath);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				String url1=driver.getCurrentUrl();
				//System.out.println(url1);
				
				try {
					
					//Thread.sleep(3000);
					driver.quit();
					break;
				}catch(Exception e) {
					System.out.println("comes to catch");
				}
			}
			//System.out.println(file.getAbsoluteFile());
			
		}
		
		
		}catch(Exception e) {
			
			
		}
		

	}

}
