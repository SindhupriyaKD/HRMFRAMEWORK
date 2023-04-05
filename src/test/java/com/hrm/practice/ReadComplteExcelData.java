package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadComplteExcelData {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\plyroctestdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("testdata");
		
		//getLastRowNum will give till last data row num in sheet
		for (int i = 1; i <=sheet.getLastRowNum() ; i++) {
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
		}

	}

}
