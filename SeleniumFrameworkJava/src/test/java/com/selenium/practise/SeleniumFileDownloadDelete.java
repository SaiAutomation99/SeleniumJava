package com.selenium.practise;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFileDownloadDelete {

	public static void main(String[] args) throws IOException {
		
		
		
		String filepath="sai";
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[text()='junit_files.txt']")).click();
		try {
		Thread.sleep(3000);
		
		}catch(Exception e) {
			
		}
		String filenamepath="";
		File filename=new File("C:\\Users\\Sai\\Downloads");
		File[] f=filename.listFiles();
		for (File file : f) {
			if(file.getName().contains(".txt")) {
				 filenamepath=file.getAbsolutePath();
				 System.out.println(file.getCanonicalPath());
				 System.out.println(filenamepath);
				 break;
			}
			
		}
		
		//String filereplace=filenamepath.replace("\",);
		
		FileReader filereader=new FileReader(filenamepath);
		System.out.println(filereader.read());
		int i=filereader.read();
		if(i==0) {
			System.out.println("no lines");
		}else {
			System.out.println("line present");
		}
		for (File file : f) {
			if(file.getName().contains(".txt")) {
				// filenamepath=file.getAbsolutePath();
				boolean status=file.delete();
				System.out.println(status);
				 break;
			}
			
		}
		
		
		String s="ddddd";
		String replace=s.replace("d", "e");
		System.out.println(replace);
		
		

	}

}
