package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;

public class ExcelUtility {
	/**
	 * This method is used to read the data from excel.
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return String cell value.
	 * @throws Throwable
	 * @throws IOException
	 * @author Sindhu
	 */

	public String readDataFromExcel(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * This method is used to write the data into excel
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 * @throws IOException
	 * @author Sindhu
	 */
	public void writeDataIntoExce(String sheetname, int rownum, int cellnum, String value)
			throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelFilePath);
		wb.write(fos);
		wb.close();

	}

	/**
	 * This methos is used to get the last row number of the sheet.
	 * 
	 * @param sheetname
	 * @return int lastrownum
	 * @throws Throwable
	 * @author Sindhu
	 */
	public int getLastRowNum(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return lastRowNum;

	}

	/**
	 * This method is used to get the last cell num
	 * 
	 * @param sheetname
	 * @param rownum
	 * @return int lastcell number
	 * @throws Throwable
	 * @author sindhu
	 */
	public int getLastCellNum(String sheetname, int rownum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastCellNum = wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
		wb.close();
		return lastCellNum;

	}

	/**
	 * This method is used to read multiple data from excel using HashMap.
	 * 
	 * @param sheetname
	 * @return map (key, value)
	 * @throws Throwable
	 * @author Sindhu
	 */

	public HashMap<String, String> readMultipleDataFromExcel(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRowNum = sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= lastRowNum; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		// wb.close();
		return map;
	}

	public String readExpDataFromExcel(String sheetname, String expDataKey) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRowNum = sh.getLastRowNum();
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= lastRowNum; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}

		wb.close();
		return map.get(expDataKey);
	}

	public Object[][] readMultiplSetOfDataUsingDataProvider(String filepath, String sheetname) throws Throwable, IOException
	{
		FileInputStream fis= new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj= new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
