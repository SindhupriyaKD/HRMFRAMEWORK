package com.hrm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		//Connection con;
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		 Properties pobj=new Properties();
		 pobj.load(fis);
		 System.out.println(pobj.getProperty("browser"));
		 System.out.println(pobj.getProperty("url"));
		 System.out.println(pobj.getProperty("hremail"));
		 System.out.println(pobj.getProperty("hrpassword"));
		 
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sindhu", "root", "root");
		Statement stmt = con.createStatement();
		String query= "update employee set manager_name='dhiva' where empid=101;";
		int result = stmt.executeUpdate(query);
		if(result==1)
		{
			System.out.println("updated");
		}
		else
			System.out.println("not updated");
		
		String query1="select * from employee where empid=101;";
		 ResultSet result1 = stmt.executeQuery(query1);
		 while (result1.next()) {
			System.out.println(result1.getString(1)+" "+result1.getString(2)+ " "+result1.getString(3)+" "+result1.getString(4)+" "+result1.getString(5)+" "+result1.getString(6)+" "+ result1.getString(7)); 
		}
		
		
		
		 
		 

	}

}
