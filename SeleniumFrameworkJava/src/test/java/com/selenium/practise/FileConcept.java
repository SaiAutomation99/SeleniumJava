package com.selenium.practise;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

public class FileConcept {

	public static void main(String[] args) throws IOException {
		
		
		File directory=new File("D:\\prasanth");
		boolean flag=directory.mkdir();
		if(flag) {
			System.out.println("directory created successfully");
		}else {
			System.out.println("not created");
		}
		File file=new File("C:\\Users\\Sai\\Downloads");
		File filecreate=new File("text.txt");
		boolean b=filecreate.createNewFile();
		if(b) {
			System.out.println("file created success");
		}else {
			System.out.println("file not created");
		}
		File[] reader=file.listFiles();
		for (File file2 : reader) {
			System.out.println(file2.getName());
			if(file2.getName().contains("text")) {
				file2.delete();
				String h=file2.getAbsolutePath();
				System.out.println(h);
			}
			
		}
		
	}

}
