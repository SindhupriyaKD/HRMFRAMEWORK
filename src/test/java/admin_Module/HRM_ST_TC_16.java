package admin_Module;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


//User should be able to create an Admin and user should be able to login with that credentials 
public class HRM_ST_TC_16 {

static WebDriver driver =null;
	
	static WebDriverWait wait;
	public static void main(String[] args) throws Throwable {
		//Launching the browser
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility webLib=new WebDriverUtility();
		DatabaseUtility dLib= new DatabaseUtility();
		HashMap<String, String> map= eLib.readMultipleDataFromExcel("Emp_loc");

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
		driver.findElement(By.name("login_hr")).click();
		
		//validating the popup
		String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		
		driver.switchTo().alert().accept();
		
		//validating the Homepage/Dashboard
		String expectedTabName = "Dashboard";
		String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();
		
		if (actualTabName.equals(expectedTabName)) {
			System.out.println("Dashboard is displayed and varified on board name");
		}else {
			System.err.println("Dashboard is not displayed and varified on board name");
		}
		
		//creating the admin credentials
		driver.findElement(By.xpath("//p[normalize-space()='ADMIN']")).click();
		driver.findElement(By.xpath("//p[normalize-space()='Add Admin']")).click();
		WebElement addAdminButton = driver.findElement(By.xpath("//button[normalize-space()='Add Admin']"));
		addAdminButton.click();
		
		String expectedAdminTabName = "Dashboard";
		String actualAdminTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();
		
		if (actualAdminTabName.equals(expectedAdminTabName)) {
			System.out.println("Admin page is displayed and varified on board name");
		}else {
			System.err.println("Admin page is not displayed and varified on board name");
		}
		
		
		String expectedAddAdminPopupTitle="Add Admin";
		String actualAddAdminPopupTitle =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Admin']"))).getText();
		
		if(actualAddAdminPopupTitle.equals(expectedAddAdminPopupTitle)) {
			System.out.println("Add Admin popup is displayed and varified upon title");
		}else {
			System.err.println("Add Admin popup is not displayed and varified upon title");
		}
		
		//fill the form for admin
		/*
		 * Company Id: 123
		 * First Name: QSP
		 * Last Name: Basavangudi
		 * Middle Name: Head Branch
		 * Contact No.: 12345678901
		 * Position: HR Head
		 * Email Address: qsphead@gmail.com
		 * password: qsphead@123
		 */
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_companyid']")))).sendKeys("123");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_firstname']")).sendKeys("QSP");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_lastname']")).sendKeys("Basavangudi");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_middlename']")).sendKeys("Head Branch");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_contactno']")).sendKeys("78912354661");
		WebElement selectType_dropdown = driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//select[@name='hr_type']"));
		Select selectType_DD = new Select(selectType_dropdown);
		selectType_DD.selectByVisibleText("→ HR Head");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_email']")).sendKeys("qsphead@gmail.com");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_password']")).sendKeys("123456907sdr");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//popup for sucessfully
		String expectedAdminInsertPopuptext = "Insert Successfully!!!";//Insert Successfully!!!
		String actualAdminInsertPopuptext = driver.switchTo().alert().getText();
		if (actualAdminInsertPopuptext.equals(expectedAdminInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		
		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement empName : EmployeeNames) {
			if(empName.getText().equals("QSP")) {
				flag=true;
				System.out.println("The Admin is sucessfully created");
				break;
			}
		}
		if(!flag) {
			System.out.println("The Admin is not created");
		}
		
		//Logout of application
		driver.findElement(By.xpath("//b[text()='Welcome!,']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		String expectedLogoutPopuptext = "Successfully Logout!";//Successfully Logout!
		String actualLogoutPopuptext = driver.switchTo().alert().getText();
		if (actualLogoutPopuptext.equals(expectedLogoutPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		
		String actualAftreLogoutTitle = driver.getTitle();
		if (actualAftreLogoutTitle.equals(eLib.readExpDataFromExcel("ExpData", "exploginpagetitl"))) {
			System.out.println("Login Page is Displayed and varified");
		}else {
			System.err.println("Login page is not displayed and varified");
		}
		
		//validate the created credentials
		/*
		 * Position: HR Head
		 * Email Address: qsphead@gmail.com
		 * password: qsphead@123
		 */
		//login to the application
		driver.findElement(By.name("hr_email")).sendKeys("qsphead@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("qsphead@123");
		Select selectType = new Select(driver.findElement(By.id("hr_type")));
		selectType.selectByValue("HR Head");
		driver.findElement(By.name("login_hr")).click();
		
		//validating the popup
		String expectedLoginPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualLoginPopuptext = driver.switchTo().alert().getText();
		if (actualLoginPopuptext.equals(expectedLoginPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		
		driver.switchTo().alert().accept();

		//terminate the browser
		driver.quit();
		
	}
}
