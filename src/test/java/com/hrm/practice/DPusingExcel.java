package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.IPathConstants;

public class DPusingExcel {
	@DataProvider
	public Object[][] getdatafromexcel() throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Expdata");
		int lastRowNum = sh.getLastRowNum()+1;
		int lastCellNum = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][lastCellNum];
		for (int i = 0; i <lastRowNum ; i++) {
			for (int j = 0; j <lastCellNum; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
	@Test(dataProvider = "getdatafromexcel")
	public void readData(String emp,String det)
	{
		System.out.println(emp+"   "+det);
	}
}
