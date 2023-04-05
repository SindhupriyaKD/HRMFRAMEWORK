package com.hrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Sindhu", "root", "root");
	       Statement stmt = conn.createStatement();
	       String query = "select * from employee;";
	       ResultSet result = stmt.executeQuery(query);
	       while(result.next())
	       {
	    	   System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6) );
	       }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally { 
			conn.close();
		}
		enterData();
	}
		
		public static void enterData() throws SQLException 
		{
			Connection con=null;
			try {
				
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Sindhu", "root", "root");
		       Statement stmt = con.createStatement();
		       String query = "alter table employee add manager_name varchar(20)";
		       String query1="insert into employee values(101,'sindhu','test engineer','sindhu@gmail.com',50000,1234567890,'dhiva');";
		       int result = stmt.executeUpdate(query1);
		       System.out.println(result);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				con.close();
			}
		}
	       

	

}
