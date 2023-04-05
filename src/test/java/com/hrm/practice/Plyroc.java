package com.hrm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Plyroc {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String expProj="Amsini12";
		WebDriverManager.chromedriver().setup();
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataPlyroc.properties");
		 Properties pobj=new Properties();
		 pobj.load(fis);
		if(pobj.getProperty("browser").equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		 driver.get(pobj.getProperty("url"));
		 driver.findElement(By.id("usernmae")).sendKeys(pobj.getProperty("username"));
		 driver.findElement(By.id("inputPassword")).sendKeys(pobj.getProperty("password"));
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 driver.findElement(By.linkText("Projects")).click();
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 driver.findElement(By.name("projectName")).sendKeys("Amsini12");
		 driver.findElement(By.name("createdBy")).sendKeys("Sindhu");
		 WebElement selectvalue = driver.findElement(By.xpath("//select[@name='status' and not (@class)]"));
		 Select select= new Select(selectvalue);
		 select.selectByValue("Created");
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 
		 Driver driver1= new Driver();
		 DriverManager.registerDriver(driver1);
		 Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		 Statement stmt = con.createStatement();
		 String query= "select * from project;";
		ResultSet result = stmt.executeQuery(query);
		boolean flag=false;
		while (result.next()) {
			String actproj = result.getString(4);
			System.out.println(actproj);
			if (actproj.equals(expProj)) {
				flag=true;
				break;
			}
			
		}
		if (flag) {
			System.out.println("project is created");
		}
		 
		con.close();
		

	}

}
