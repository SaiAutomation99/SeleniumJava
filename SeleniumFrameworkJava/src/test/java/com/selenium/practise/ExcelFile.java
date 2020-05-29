package com.selenium.practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	public void fileReader(String filepath) throws IOException {
		FileInputStream input=null;
		XSSFWorkbook workbook=null;
		String fieldname="";
		boolean b=false;

		FileOutputStream fileout;
		try {


			input=new FileInputStream(filepath);

			workbook = new XSSFWorkbook(input);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int i=  sheet.getLastRowNum();
			System.out.println(i);
			for(int j=0;j<i;j++) {

				XSSFRow row=sheet.getRow(j);
				for(int k=0;k<row.getLastCellNum();k++) {

					XSSFCell cell=row.getCell(k);

					CellType celltype=	cell.getCellType();
					if(celltype==celltype.STRING) {	
						fieldname=cell.getStringCellValue();
						System.out.println(fieldname);
						fileout=new FileOutputStream(filepath,true);
						String anothername="sai";
						byte[] h=anothername.getBytes();
						fileout.write(h);

					}else if(celltype==celltype.NUMERIC) {
						System.out.println("numeric");
					}else if(celltype==celltype.BLANK) {

						System.out.println("blank");
					}
					else {
						System.out.println("not string");
					}

					if(fieldname!=null) {
						b=true;
						System.out.println("out from the second for loop");
						break;
					}
				}
				if(b) {
					System.out.println("out from the first for loop");
					break;
				}
			}

		}catch(Exception e) {

			e.printStackTrace();

		}finally {
			input.close();
		}
	}
	public static void main(String[] args) {
		ExcelFile j=new ExcelFile();
		String filename="";
		try {
			FileInputStream fileinp=new FileInputStream("C:\\Users\\Sai\\eclipse-workspace\\SeleniumFrameworkJava\\src\\test\\resources\\filepath.properties");
			Properties pro=new Properties();
			pro.load(fileinp);
			filename=pro.getProperty("filepath");
			System.out.println("file location"+filename);

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			j.fileReader(filename);
		}catch(Exception e) {
			System.out.println("enters catch");

			e.printStackTrace();
		}

	}


}
