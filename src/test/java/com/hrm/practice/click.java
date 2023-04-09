package com.hrm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class click {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= null;
		WebDriverWait wait= null;
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility webLib=new WebDriverUtility();
		DatabaseUtility dLib= new DatabaseUtility();
		
		
		
		
	
	String browserNmae = "chrome";
	if(browserNmae.equals(fLib.readCommonData("browser"))) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if (browserNmae.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	//pre-conditions
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	wait=new WebDriverWait(driver, 5);
	
	//Triggering the test url
	driver.get("http://rmgtestingserver/domain/HRM_System/");
	
	//Validating the login page
	//String expectedTitle = "Admin Log in";
	String actualTitle = driver.getTitle();
	if (actualTitle.equals(eLib.readExpDataFromExcel("ExpData", "ExpTitle"))) {
		System.out.println("Login Page is Displayed and varified");
	}else {
		System.err.println("Login page is not displayed and varified");
	}
	
	
	//login to the application
	driver.findElement(By.name("hr_email")).sendKeys(fLib.readCommonData("hremail"));
	driver.findElement(By.name("hr_password")).sendKeys(fLib.readCommonData("hrpassword"));
	Select select = new Select(driver.findElement(By.id("hr_type")));
	select.selectByValue("HR Head");
	WebElement click = driver.findElement(By.name("login_hr"));
	webLib.clickOnElement(driver, click);
}
}
