package com.selenium.practise;

import java.awt.AWTException;

public class DownloadFileSelenium {
	
	int i=10;
	public void m1() {
		
		if(i==9) {
			
		}else {
			i=9;
			this.m1();
			System.out.println("j");
		}
	}
	
	public  void m2(String name){
		
			System.out.println(name);
	
		
	}

	public static void main(String[] args) throws AWTException {
		
		
		DownloadFileSelenium k=new DownloadFileSelenium();
		try {
		k.m1();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally block will execute normally");
		}
		String name="h";
		k.m2("hai"+name);
	}

}
