package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con= null;
	/**
	 * This methos is used to connect our program with the database.
	 * @throws SQLException
	 * @author Sindhu
	 */
	public void connectToDatabase() throws SQLException
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.DBurl,IPathConstants.DBusername , IPathConstants.DBpassword);
	}
	
	/**
	 * This methos is used to execute and return the data from the database
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 * @author Sindhu
	 */
	public String executeQueryAndReturnData(String query, int colIndex, String expData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		String actData=null;
		while (result.next()) {
			 actData = result.getString(colIndex);
			if (actData.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
			
		}
		if (flag) {
			System.out.println("data is correct");
			return actData;
		}
		else {
			System.out.println("data is incorrect");
			return null;
		}
		
	}
	
	/**
	 * This methos is used to close the database connection
	 * @throws SQLException
	 * @author Sindhu
	 */
	
	public void closeDatabaseConnection() throws SQLException
	{
		con.close();
	}
	
	public Map<String, String> readDataUsingDatabase() throws SQLException
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sindhu", "root", "root");
		 Statement stmt = con.createStatement();
		 String query="select * from emp;";
		 ResultSet result = stmt.executeQuery(query);
		 Map<String, String> map = new LinkedMap<String, String>();
		 while (result.next()) {
			String key=result.getString(1);
			String value= result.getString(2);
			 
			 map.put(key, value);
		}
		 return map;
	}
	

}
