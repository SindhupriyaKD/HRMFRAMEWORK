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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

//User should be able to create Admin
public class CreateAdminLogout extends BaseClass {

	@Test(groups = "Smoke")
	public void createadminLogout() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		DashBoardPage db = new DashBoardPage(driver);
		AdminPage adminpage = new AdminPage(driver);

		String actTitle = driver.getTitle();
//		if (actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle"))) {
//			System.out.println("Login page is displayed and verified upon the title");
//
//		} else {
//			System.out.println("Login page is not displayed and verified upon the title");
//
//		}

		assertTrue(actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle")),
				"Login page is not displayed and verified upon the title");
		Reporter.log("Login page is displayed and verified upon the title", true);

		// Login Page
		lp.SignInToAppUsingHrHead();

		// Validate Login Popup
//		if (lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert"))) {
//			System.out.println("Popup is verified");
//		} else {
//			System.out.println("popup is not verified");
//		}

		assertTrue(lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert")),
				"Login successfully popup is not verified");
		Reporter.log("Login successfully Popup is verified", true);

		wLib.waitUntilAlertIsPresent(driver);

		// Create admin

		db.gotoAdminPage();
		adminpage.clickOnAddAdminButton();
		HashMap<String, String> map = ElIb.readMultipleDataFromExcel("Admin");
		adminpage.fillAdminForm(map);
		adminpage.clickOnSaveButton();
//		if (adminpage.validateAdminPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"))) {
//			System.out.println("admin created popup is verified");
//		} else
//			System.out.println("admin created popup is not verified");

		assertTrue(adminpage.validateAdminPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup")),
				"admin created popup is not verified");
		Reporter.log("admin created popup is verified", true);

		wLib.waitUntilAlertIsPresent(driver);

		// Logout of application
		db.logoutOfAccount();
//		if (db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup"))) {
//			System.out.println("Logout Successfully popup is correct");
//		} else
//			System.out.println("Logout Successfully popup is not correct");

		assertTrue(db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup")),
				"Logout Successfully popup is correct");
		Reporter.log("Logout Successfully popup is correct");

		wLib.waitUntilAlertIsPresent(driver);

	}
}
