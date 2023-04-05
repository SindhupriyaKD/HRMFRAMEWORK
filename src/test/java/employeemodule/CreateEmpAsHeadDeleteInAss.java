package employeemodule;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.DatabaseUtility;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmpAsHeadDeleteInAss {
	

	public static void main(String[] args) throws  Throwable {
		// TODO Auto-generated method stub
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility webLib=new WebDriverUtility();
		DatabaseUtility dLib= new DatabaseUtility();
		
		WebDriver driver=null;

     
        // Read data from excel using HashMap.
		HashMap<String, String> map= eLib.readMultipleDataFromExcel("Emp_loc");

		String browsername="chrome";
		if(browsername.equals(fLib.readCommonData("browser")))
		{
		driver=WebDriverManager.chromedriver().create();
		// driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.get(fLib.readCommonData("url"));
		String actualTitle = driver.getTitle();
		//String ExpTitle="Admin Log in";
		if (actualTitle.equals(eLib.readExpDataFromExcel("ExpData", "ExpTitle"))) {
			System.out.println("Login page is displayed and verified upon the title");
		} else {
			System.out.println("Login page is not displayed and verified upon the title");

        }
		driver.findElement(By.name("hr_email")).sendKeys(fLib.readCommonData("hremail"));
		driver.findElement(By.name("hr_password")).sendKeys(fLib.readCommonData("hrpassword"));
		WebElement selectTypeDD = driver.findElement(By.id("hr_type"));
		webLib.selectByValue(selectTypeDD, "HR Head");
 
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("login_hr")).click();
		String loginSuccessfullyAlert = driver.switchTo().alert().getText();
		System.out.println(loginSuccessfullyAlert);
		//String exploginSuccesfullyAlert="Login Successfully!!";
		if (loginSuccessfullyAlert.equals(eLib.readExpDataFromExcel("ExpData", "exploginSuccesfullyAlert"))) {
			System.out.println("Login Successfully!! popup is displayed and verified upon its title");
		} else {
			System.out.println("Login Successfully!! popup is not displayed and verified upon its title");

		}
		driver.switchTo().alert().accept();
		String actualDashboardTitle = driver.getTitle();
		//String expDashboardTitle="Admin | Dashboard";
		if (actualDashboardTitle.equals(eLib.readExpDataFromExcel("ExpData", "expDashboardTitle"))) {
			System.out.println("Dashboard page is displayed and verified");
		} else {
			System.out.println("Dashboard page is not displayed and verified");

		}
		driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
		driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//p[text()='Add Corporate']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add Corporate']")).click();
		String actualaddCorporatePopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header']/h4[text()='Add Corporate']"))).getText();
		//String expectedAddCorporatePopupTitle="Add Corporate";
		if (actualaddCorporatePopup.equals(eLib.readExpDataFromExcel("ExpData", "expectedAddCorporatePopupTitle"))) {
			System.out.println("Add Corporate popup is displayed and verified upon title");

		} else {
			System.out.println("Add Corporate popup is not displayed and verified upon title");

		}
		
		
		driver.findElement(By.xpath("//input[@placeholder='Corporate Name']")).sendKeys("department");
		driver.findElement(By.name("corp")).click();
		String actualinsertsuccessPopup = driver.switchTo().alert().getText();
		System.out.println(actualinsertsuccessPopup);
		if (actualinsertsuccessPopup.equals(eLib.readExpDataFromExcel("ExpData", "ExpinsertsuccessPopup"))) {
			System.out.println("Insert Successfully!!! popup is displayed and verified");
		} else {
			System.out.println("Insert Successfully!!! popup is not displayed and verified");

        }
		driver.switchTo().alert().accept();
		String deptCreated = "department";
		String ActualDeptNameCreated = driver.findElement(By.xpath("//tbody/tr/td[text()='"+deptCreated+"']")).getText();
		//String Expdeptname="department";
		if (ActualDeptNameCreated.equals(eLib.readExpDataFromExcel("ExpData", "Expdeptname"))) {
			System.out.println("department is created successfully");
		} else {
			System.out.println("department is not created and verified");

		}
		driver.findElement(By.xpath("//li[@class='nav-item has-treeview']//p[normalize-space()='BRANCHES']")).click();
		driver.findElement(By.xpath("//li[@class='nav-item']//p[normalize-space()='Add Braches']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add Branches']")).click();
		//String expectedAddBranchesPopupTitle="Add Branches";
		String actualAddBranchesPopupTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Branches']"))).getText();
		
		if(actualAddBranchesPopupTitle.equals(eLib.readExpDataFromExcel("ExpData", "expectedAddBranchesPopupTitle"))) {
			System.out.println("Add Braches popup is displayed and verified upon title");
		}else {
			System.err.println("Add Braches popup is not displayed and verified upon title");
		}	
		
		driver.findElement(By.xpath("//input[@placeholder='Branches Name']")).sendKeys("basavanagudi");
		driver.findElement(By.name("bran")).click();
		String actualinsertBranchPopup= driver.switchTo().alert().getText();
		
		if (actualinsertBranchPopup.equals(eLib.readExpDataFromExcel("ExpData", "expinsertBranchPopup"))) {
			System.out.println("Insert Successfully!!! popup is displayed and verified");
		} else {
			System.out.println("Insert Successfully!!! popup is not displayed and verified");

		}
		driver.switchTo().alert().accept();
		String verifybranchcreated="basavanagudi";
		String actualBranchNameCreated = driver.findElement(By.xpath("//tbody/tr//td[text()='"+verifybranchcreated+"']")).getText();
		//String expBranchNameCreated="Basavanagudi";
		if (actualBranchNameCreated.equals(eLib.readExpDataFromExcel("ExpData", "expBranchNameCreated"))) {
			System.out.println("Branch is created successfully");
		} else {
			System.out.println("Branch is not created");

		}
		
		driver.findElement(By.xpath("//li[@class='nav-item has-treeview']//p[normalize-space()='EMPLOYEE']")).click();
		driver.findElement(By.xpath("//ul[@class='nav nav-treeview']//p[normalize-space()='Add Employee']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]")).click();
		
		for (Entry<String, String> set : map.entrySet()) { 
			if(set.getKey().equals("employee_department"))
			{
			WebElement selectDept = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+set.getKey()+"']"));
			Select sel= new Select(selectDept);
			sel.selectByValue(set.getValue());
			}
			else if(set.getKey().equals("employee_branches"))
			{
				WebElement selectDept = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//select[@name='"+set.getKey()+"']"));
				Select sel= new Select(selectDept);
				sel.selectByValue(set.getValue());

			}
			else
			{
				WebElement key = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='"+set.getKey()+"']"))));
				key.sendKeys(set.getValue());
				//driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='"+set.getKey()+"']")).sendKeys(set.getValue());
			}
				
		}
	
		
		driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_file201']")).sendKeys("C:\\Users\\DELL\\Downloads/SQL_DDl_DML_TCL_DCL.pdf");
		driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_image']")).sendKeys("C:\\Users\\DELL\\Downloads\\image.jpeg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actualempCreatedPopup = driver.switchTo().alert().getText();
		//String expempCreatedPopup="Insert Successfully!!!";
		if (actualempCreatedPopup.equals(eLib.readExpDataFromExcel("ExpData", "expempCreatedPopup"))) {
			System.out.println("Insert Successfully!!! popup is displayed successfully");
		} else {
			System.out.println("Insert Successfully!!! popup is not displayed");

		}
		driver.switchTo().alert().accept();
		List<WebElement> allEmpNames = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		Boolean flag=false;
		
		for (WebElement names : allEmpNames) {
			if(names.getText().equals("Sindhu"))
			{
				
				System.out.println("Employee detail is created");
				flag=true;
				break;
			}
			if (!flag) {
				System.out.println("Employee detail is not created");
			}
		}
		driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[text()='Welcome!,']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
		String actualLogoutPopup = driver.switchTo().alert().getText();
		//String expLogoutPopup="Successfully Logout!";
		if (actualLogoutPopup.equals(eLib.readExpDataFromExcel("ExpData", "expLogoutPopup"))) {
			System.out.println("Successfully Logout! popup is displayed successfully");
		} else {
			System.out.println("Successfully Logout! popup is not displayed ");

		}
		driver.switchTo().alert().accept();
		String actualloginpagetitle = driver.getTitle();
		//String exploginpagetitle="Admin Log in";
		if (actualloginpagetitle.equals(eLib.readExpDataFromExcel("ExpData", "exploginpagetitle"))) {
			System.out.println("Login page is displayed and verified upon the title");
		} else {
			System.out.println("Login page is not displayed and verified upon the title");

        }
		driver.findElement(By.name("hr_email")).sendKeys(fLib.readCommonData("hrassistantemail"));
		driver.findElement(By.name("hr_password")).sendKeys(fLib.readCommonData("hrassistantpassword"));
		WebElement selectType = driver.findElement(By.id("hr_type"));
		Select select11= new Select(selectType);
		select11.selectByValue("HR Assistant");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("login_hr")).click();
		String loginSuccessfulyAlert = driver.switchTo().alert().getText();
		System.out.println(loginSuccessfulyAlert);
		//String exploginSuccesfulyAlert="Login Successfully!!";
		if (loginSuccessfulyAlert.equals(eLib.readExpDataFromExcel("ExpData", "exploginSuccesfulyAlert"))) {
			System.out.println("Login Successfully!! popup is displayed and verified upon its title");
		} else {
			System.out.println("Login Successfully!! popup is not displayed and verified upon its title");

		}
		driver.switchTo().alert().accept();
		String actualDashboardTitl = driver.getTitle();
		//String expDashboardTitl="Admin | Dashboard";
		if (actualDashboardTitl.equals(eLib.readExpDataFromExcel("ExpData", "expDashboardTitl"))) {
			System.out.println("Dashboard page is displayed and verified");
		} else {
			System.out.println("Dashboard page is not displayed and verified");

		}
		driver.findElement(By.xpath("//li[@class='nav-item has-treeview']")).click();
		driver.findElement(By.xpath("//li[@class='nav-item']/a[@href='Add_employee.php']")).click();
		String name="Sindhu";
		driver.findElement(By.xpath("//td[text()='"+name+"']/../td[9]/i[3]")).click();
		driver.findElement(By.xpath("//h4[text()='Delete Employee']/../..//button[text()='Delete']")).click();
		String delpopup = driver.switchTo().alert().getText();
		if (delpopup.equals(eLib.readExpDataFromExcel("ExpData", "expdelpopup"))) {
			System.out.println("Delete Successfully!!! popup is displayed");
		} else {
			System.out.println("Delete Successfully!!! popup is not displayed");

		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//li[@class='nav-item dropdown']//b[text()='Welcome!,']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
		String actLogoutPopup = driver.switchTo().alert().getText();
		//String exploutPopup="Successfully Logout!";
		if (actLogoutPopup.equals(eLib.readExpDataFromExcel("ExpData", "exploutPopup"))) {
			System.out.println("Successfully Logout! popup is displayed successfully");
		} else {
			System.out.println("Successfully Logout! popup is not displayed ");

		}
		driver.switchTo().alert().accept();
		String actualoginpagetitle = driver.getTitle();
		//String exploginpagetitl="Admin Log in";
		if (actualoginpagetitle.equals(eLib.readExpDataFromExcel("ExpData", "exploginpagetitl"))) {
			System.out.println("Login page is displayed and verified upon the title");
		} else {
			System.out.println("Login page is not displayed and verified upon the title");

        }
		driver.quit();
		

	}

}
