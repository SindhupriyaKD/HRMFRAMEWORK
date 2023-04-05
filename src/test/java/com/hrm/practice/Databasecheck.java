package com.hrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.LinkedMap;

import com.mysql.jdbc.Driver;

public class Databasecheck {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
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
		 for(Entry <String,String> set :map.entrySet())
		 {
			 System.out.println(set.getKey()+"\t\t:"+set.getValue());		
			 
		 }
		  
		 
		 con.close();
		 
	}

}
