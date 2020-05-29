package com.selenium.practise;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFile {
	
	static String filepath=null;

	public static void main(String[] args) throws IOException {
		
		
		
		try {
			 filepath="C:\\Users\\Sai\\Downloads\\Komarika Naresh.xlsx";
			
			if(filepath.contains(".xlsx")||filepath.contains(".xlx")) {
				
				m1(filepath);
				
				
			}

		}catch(Exception e) {
			System.out.println("enter catch");
			
		}
		
	}
		public static void m1(String filepath) {
			
			XSSFCell cell=null;
			XSSFWorkbook workbook=null;
		try {
		
		 workbook=new XSSFWorkbook(filepath);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int row=sheet.getLastRowNum();
		
		for(int i=0;i<row;i++) {
			
			XSSFRow rowname=sheet.getRow(i);
			
			for(int j=0;j<rowname.getLastCellNum();j++) {
				
				 cell=rowname.getCell(j);
				
				CellType celltype=cell.getCellType();
				
				if(celltype==CellType.STRING) {
					System.out.println(cell);
					
				}else if(celltype==CellType.NUMERIC) {
					
					System.out.println(cell);
					
				}
				else if(celltype==CellType.BLANK) {
					System.out.println("blank");
				}else if(celltype==CellType.BOOLEAN) {
					
					System.out.println("print boolean cell value"+cell);
				}
			}
		}
		
	}catch(Exception e) {
		
		
		if(cell==null) {
			System.out.println("cell");
			
		}
		
	}finally {
		try {
		workbook.close();
		}catch(Exception e) {
			
		}
		
	}
		}	
}
