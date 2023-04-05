package com.hrm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.IPathConstants;

public class DPusingExcelUtility {
	@DataProvider
	public Object[][] readDataFromExcel() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.readMultiplSetOfDataUsingDataProvider(IPathConstants.ExcelFilePath, "Expdata");
		return value;

	}
	
	
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Expdata");
		int lastRowNum = sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= lastRowNum; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		Object[][] obj = new Object[2][1];
		obj[0][0] = map;
		obj[1][0]=  map;

		return obj;
	}

	@Test(dataProvider = "data")
	public void mapdata(HashMap<String, String> mapp) {

		for (Entry<String, String> entry : mapp.entrySet()) {
			String key = entry.getKey(); 
			String val = entry.getValue();
			System.out.println(key + "   " + val);
		}

		System.out.println(mapp.get("ExpTitle"));

	}

	@Test(dataProvider = "readDataFromExcel")
	public void getData(String emp, String det) {
		System.out.println(emp + "    " + det);
	}
}
