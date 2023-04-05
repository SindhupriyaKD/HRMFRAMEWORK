package admin_Module;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriverUtility;
import com.pomrepository.AddBranchesPage;
import com.pomrepository.AddCorporatePage;
import com.pomrepository.AdminPage;
import com.pomrepository.BranchPage;
import com.pomrepository.CorporatePage;
import com.pomrepository.CreateEmployeePage;
import com.pomrepository.DashBoardPage;
import com.pomrepository.EmployeePage;
import com.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAdminAndValidateWithLogin extends BaseClass {
	@Test
	public void createAdminValidateWithLogin() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		DashBoardPage db = new DashBoardPage(driver);
		AdminPage adminpage = new AdminPage(driver);

		String actTitle = driver.getTitle();
//		if (actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle"))) {
//			Reporter.log("Login page is displayed and verified upon the title",true);
//
//		} else {
//			Reporter.log("Login page is not displayed and verified upon the title",true);
//
//		}
		
		assertTrue(actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle")), "Login page is not displayed and verified upon the title");
		Reporter.log("Login page is displayed and verified upon the title", true);

		// Login Page
		lp.SignInToAppUsingHrHead();

		// Validate Login Popup
//		if (lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert"))) {
//			Reporter.log("Popup is verified",true);
//		} else {
//			Reporter.log("popup is not verified",true);
//		}
		
		assertTrue(lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert")), "Login successfully popup is not verified");
		Reporter.log("Login successfully Popup is verified", true);

		wLib.waitUntilAlertIsPresent(driver);

		// Create admin

		db.gotoAdminPage();
		adminpage.clickOnAddAdminButton();
		HashMap<String, String> map = ElIb.readMultipleDataFromExcel("Admin");
		adminpage.fillAdminForm(map);
		adminpage.clickOnSaveButton();
//		if (adminpage.validateAdminPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"))) {
//			Reporter.log("admin created popup is verified",true);
//		} else
//			Reporter.log("admin created popup is not verified",true);
		
		assertTrue(adminpage.validateAdminPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup")), "admin created popup is not verified");
		Reporter.log("admin created popup is verified", true);
		
		wLib.waitUntilAlertIsPresent(driver);

		// validate admin
		boolean flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement empName : EmployeeNames) {
			if (empName.getText().equals("QSP")) {
				flag = true;
				Reporter.log("The Admin is sucessfully created",true);
				break;
			}
		}
		if (!flag) {
			Reporter.log("The Admin is not created",true);
		}

		// logout
		db.logoutOfAccount();
//		if (db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup"))) {
//			Reporter.log("Logout Successfully popup is correct",true);
//		} else
//			Reporter.log("Logout Successfully popup is not correct",true);
		
		assertTrue(db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup")), "Logout Successfully popup is correct");
		Reporter.log("Logout Successfully popup is correct");

		wLib.waitUntilAlertIsPresent(driver);

		lp.loginToApp(ElIb, "Admin", "hr_email", "hr_password", "hr_type");
//		if (lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert"))) {
//			Reporter.log("Popup is verified",true);
//			Reporter.log("User is able to login with the created credential",true);
//		} else {
//			Reporter.log("popup is not verified",true);
//			Reporter.log("User is not able to login with the created credential",true);
//
//		}
		
		assertTrue(lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert")), "popup is not verified, User is not able to login with the created credential");
		Reporter.log("Popup is verified",true);
		Reporter.log("User is able to login with the created credential",true);
		wLib.waitUntilAlertIsPresent(driver);

		// logout

		db.logoutOfAccount();

	}
}
