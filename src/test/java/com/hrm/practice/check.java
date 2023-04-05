package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class check {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		Date date= new Date();
//		String[] ddate = date.toString().split(" ");
//		System.out.println(date);
		//Tue Mar 14 10:23:29 IST 2023
		//Tue Mar 28 2023
		
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat sd=new SimpleDateFormat("mm/dd/yyyy");
//		System.out.println(sd.format(calendar.getTime()));
//		
//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		//Workbook workbook = WorkbookFactory.create(fis);

		//get the commondata
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		System.out.println(pobj.getProperty("browser"));
		
//		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
//		Date dt= new Date();
//		String dateAndTime = dateFormat.format(dt);
//		System.out.println(dateAndTime);
//		
//		Date date= new Date();
//		String dt1 = date.toString();
//		System.out.println(dt1);
//		
		System.out.println(System.getProperty("username"));
		
		

	}

}
