package com.GenericUtility;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public FileUtility Flib = new FileUtility();
	public ExcelUtility ElIb = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DatabaseUtility dlib = new DatabaseUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void configBeforeSuite() throws SQLException {
		dlib.connectToDatabase();
		Reporter.log("connect to db", true);
	}

	//@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	//public void configBeforeClass(String browserName) throws Throwable {
	public void configBeforeClass() throws Throwable {
		String browserName = System.getProperty("browserName").equals(null)?Flib.readCommonData("browser"):System.getProperty("browserName");
		
		//String browserName = Flib.readCommonData("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

		}
		else
			Reporter.log("invalid browser", true);
		sdriver=driver;
		driver.get(Flib.readCommonData("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod(alwaysRun = true)
	public void configAfterCalss()
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAfterSuite() throws SQLException
	{
		dlib.closeDatabaseConnection();
		Reporter.log("close db connection", true);
	}

}
