package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		readDataFromExcel(".\\src\\test\\resources\\plyroctestdata.xlsx","testdata",1);
		writeDtaFromExcel(".\\src\\test\\resources\\plyroctestdata.xlsx","testdata",1);
	}
	
		// TODO Auto-generated method stub
		public static void readDataFromExcel(String filepath,String sheetname,int rownum) throws EncryptedDocumentException, IOException
		{
		FileInputStream fis= new FileInputStream(filepath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);	
		Row row = sheet.getRow(rownum);
		
		for (int i = 0; i <row.getLastCellNum(); i++) {
			Cell cell=row.getCell(i);
			System.out.println(cell.getStringCellValue());
		}
		workbook.close();
		}
		public static void writeDtaFromExcel(String filepath, String sheetname, int rownum) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis= new FileInputStream(filepath);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetname);	
		Row row1 = sheet.createRow(rownum);	
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("sindhu");
		FileOutputStream fos= new FileOutputStream(filepath);
		workbook.write(fos);
		workbook.close();

		}
		
	

}
