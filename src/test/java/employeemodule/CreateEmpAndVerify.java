package employeemodule;

import static org.testng.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.pomrepository.AddBranchesPage;
import com.pomrepository.AddCorporatePage;
import com.pomrepository.BranchPage;
import com.pomrepository.CorporatePage;
import com.pomrepository.CreateEmployeePage;
import com.pomrepository.DashBoardPage;
import com.pomrepository.EmployeePage;
import com.pomrepository.LoginPage;

public class CreateEmpAndVerify extends BaseClass {
	@Test
	public void createEmployee() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		DashBoardPage db = new DashBoardPage(driver);
		CorporatePage corpage = new CorporatePage(driver);
		AddCorporatePage addcorpage = new AddCorporatePage(driver);
		BranchPage bp = new BranchPage(driver);
		AddBranchesPage addbranch = new AddBranchesPage(driver);
		CreateEmployeePage createemp = new CreateEmployeePage(driver);
		EmployeePage empPage = new EmployeePage(driver);

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
//			System.out.println(" Login Successfully Popup is verified");
//		} else {
//			System.out.println("Login Successfully popup is not verified");
//		}
		
		assertTrue(lp.validateLoginPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploginSuccesfullyAlert")), "Login Successfully popup is not verified");
		Reporter.log(" Login Successfully Popup is verified", true);

		wLib.waitUntilAlertIsPresent(driver);

		// Create Corporate
		db.gotoCorporatePage();
		corpage.clickOnAddCorporateButton();
		addcorpage.enterCorporateName(ElIb.readDataFromExcel("Corp", 0, 1));
		addcorpage.clickOnSaveButton();
//		if (addcorpage.validateCorportaePagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "ExpinsertsuccessPopup"),
//				driver)) {
//			System.out.println("Insert Successfully popup is verified");
//		} else
//			System.out.println("Insert Successfully popup is not verified");
		assertTrue(addcorpage.validateCorportaePagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "ExpinsertsuccessPopup"),driver), "Insert Successfully popup is not verified");
		Reporter.log("Insert Successfully popup is verified", true);
		wLib.waitUntilAlertIsPresent(driver);

		// Create Branch
		db.gotoBranchPage();
		bp.clickOnAddBranch();
		addbranch.enterbranchesname(ElIb.readDataFromExcel("Branch", 0, 1));
		addbranch.clickOnSaveButton();
//		if (addbranch.validateBranchPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"),
//				driver)) {
//			System.out.println("Branch insert successfully popup is verified");
//		} else
//			System.out.println("Branch insert successfully popup is not verified");
		assertTrue(addbranch.validateBranchPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"),driver), "Branch insert successfully popup is not verified");
		Reporter.log("Branch insert successfully popup is verified", true);
		
		wLib.waitUntilAlertIsPresent(driver);

		// Create Employee

		db.gotoEmployeePage();
		empPage.clickOnAddEmp();
		HashMap<String, String> map = ElIb.readMultipleDataFromExcel("Emp_loc");
		createemp.fillEmpForm(map, driver);
		createemp.uploadFileAndImg("C:\\Users\\DELL\\Downloads/SQL_DDl_DML_TCL_DCL.pdf",
				"C:\\Users\\DELL\\Downloads\\image.jpeg");
//		if (createemp.validateEmpPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"),
//				driver)) {
//			System.out.println("Employee insery successfully popup is verified");
//		} else
//			System.out.println("Employee insery successfully popup is not verified");
		assertTrue(createemp.validateEmpPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "expinsertBranchPopup"),driver), "Employee insery successfully popup is not verified");
		Reporter.log("Employee insery successfully popup is verified", true);
		wLib.waitUntilAlertIsPresent(driver);

		// verify created emp
		List<WebElement> allEmpNames = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		Boolean flag = false;

		for (WebElement names : allEmpNames) {
			if (names.getText().equals("Sindhu")) {

				System.out.println("Employee detail is created");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Employee detail is not created");
		}
		// logout
		db.logoutOfAccount();
//		if (db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup"))) {
//			System.out.println("Logout Successfully popup is correct");
//		} else
//			System.out.println("Logout Successfully popup is not correct");
		
		assertTrue(db.validateDashboardPagePopup(wLib, ElIb.readExpDataFromExcel("Expdata", "exploutPopup")), "Logout Successfully popup is not correct");
		Reporter.log("Logout Successfully popup is correct", true);
		wLib.waitUntilAlertIsPresent(driver);
//		if (actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle"))) {
//			System.out.println("Login page is displayed and verified upon the title");
//
//		} else {
//			System.out.println("Login page is not displayed and verified upon the title");
//
//		}
		
		assertTrue(actTitle.equals(ElIb.readExpDataFromExcel("ExpData", "ExpTitle")), "Login page is not displayed and verified upon the title");
		Reporter.log("Login page is displayed and verified upon the title", true);

	}
}
