package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class DashBoardPage {
	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = "span.brand-text.font-weight-light")
	private WebElement brandNameAndDashBoardLink;
	
	public String getBrandName() {
		return brandNameAndDashBoardLink.getText();
	}
	
	@FindBy(className = "d-block")
	private WebElement loginUserMail;
	
	public String getLoginUserMailId() {
		return loginUserMail.getText();
	}
	
	@FindBy(xpath = "//p[text()='Dashboard']/../..")
	private WebElement dashboard;
	
	public void gotoDashboard() {
		dashboard.click();
	}
	
	@FindBy(xpath = "//p[contains(text(),'CORPORATE')]")
	private WebElement CorporateModule;
	
	@FindBy(xpath = "//p[contains(text(),'Add Corporate')]")
	private WebElement addCorporateLink;
	
	public void gotoCorporatePage() {
		CorporateModule.click();
		addCorporateLink.click();
	}
	
	@FindBy(xpath = "//p[contains(text(),'BRANCHES')]")
	private WebElement branchModule;
	
	@FindBy(xpath = "//p[contains(text(),'Add Braches')]")
	private WebElement addBranchLink;
	
	public void gotoBranchPage() {
		branchModule.click();
		addBranchLink.click();
	}
	
	@FindBy(xpath = "//p[contains(text(),'EMPLOYEE')]")
	private WebElement employeeModule;
	
	@FindBy(xpath = "//p[contains(text(),'Add Employee')]")
	private WebElement addemployeeLink;
	
	public void gotoEmployeePage() {
		employeeModule.click();
		addemployeeLink.click();
	}
	
	@FindBy(xpath = "//p[contains(text(),'ADMIN')]")
	private WebElement adminModule;
	
	@FindBy(xpath = "//p[contains(text(),'Add Admin')]")
	private WebElement addAdminLink;
	
	public void gotoAdminPage() {
		adminModule.click();
		addAdminLink.click();
	}
	
	@FindBy(css = ".fa.fa-user")
	private WebElement profileLink;
	
	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement logout;
	
	public void logoutOfAccount() {
		profileLink.click();
		logout.click();
		//driver.switchTo().alert().accept();
	}
	
	public boolean validateDashboardPagePopup(WebDriverUtility wlib, String expPopupText) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}
}
