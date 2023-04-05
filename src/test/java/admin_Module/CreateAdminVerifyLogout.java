package admin_Module;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.pomrepository.AdminPage;
import com.pomrepository.DashBoardPage;
import com.pomrepository.LoginPage;

public class CreateAdminVerifyLogout extends BaseClass {
	@Test(groups ="Smoke")
	public void createadminverlog() throws Throwable {

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
		
		assertTrue(actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle")), "Login page is not displayed and verified upon the title");
		Reporter.log("Login page is displayed and verified upon the title", true);

		// Login Page
		lp.SignInToAppUsingHrHead();

		// Validate Login Popup
//		if (lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert"))) {
//			System.out.println("Popup is verified");
//		} else {
//			System.out.println("popup is not verified");
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
//			System.out.println("admin created popup is verified");
//		} else
//			System.out.println("admin created popup is not verified");
		
		assertTrue(adminpage.validateAdminPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup")), "admin created popup is not verified");
		Reporter.log("admin created popup is verified", true);
		
		wLib.waitUntilAlertIsPresent(driver);

		// verify created admin

		boolean flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement empName : EmployeeNames) {
			if (empName.getText().equals("QSP")) {
				flag = true;
				System.out.println("The Admin is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Admin is not created");
		}

		// Logout of application
		db.logoutOfAccount();
//		if (db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup"))) {
//			System.out.println("Logout Successfully popup is correct");
//		} else
//			System.out.println("Logout Successfully popup is not correct");
		
		assertTrue(db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup")), "Logout Successfully popup is correct");
		Reporter.log("Logout Successfully popup is correct");

		wLib.waitUntilAlertIsPresent(driver);

	}
}
