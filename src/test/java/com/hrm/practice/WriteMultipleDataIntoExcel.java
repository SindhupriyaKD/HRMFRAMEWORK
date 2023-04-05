package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\plyroctestdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("testdata");
		for (int i = 5; i <= 10; i++) {
			Row ro = sheet.createRow(i);
			for (int j = 0; j <=1; j++) {
				sheet.getRow(i).createCell(j).setCellValue("dhivakar");
				FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\plyroctestdata.xlsx");
				workbook.write(fos);
				
			}
			
		}
		workbook.close();
		

	}

}
