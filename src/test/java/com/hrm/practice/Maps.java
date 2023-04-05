package com.hrm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Maps {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Read data from excel using map
		
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\com.hrm.humanresourcemanagement\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("ExpData");
		HashMap<String, String> map= new LinkedHashMap<String, String>();
		for (int i = 0; i <=sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		
		//map----1)hashmap
		//		 2)hashtable
		//		 3)treemap
		
		
		for (Entry<String, String> set : map.entrySet()) {
			String key = set.getKey();
			String val = set.getValue();
			System.out.println(key+"---->"+val);
	
			
		}
		System.out.println("====================================");
		Map<String, String> map1= new TreeMap<String, String>();
		for (int i = 0; i <=sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map1.put(key, value);
			
		}
		
		for (Entry<String, String> set : map1.entrySet()) {
			String key = set.getKey();
			String val = set.getValue();
			System.out.println(key+"---->"+val);
	
			
		}
		

	}

}
