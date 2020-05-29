package com.selenium.practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws AWTException {
		
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_1);
		robo.keyRelease(KeyEvent.VK_1);

	}

}
