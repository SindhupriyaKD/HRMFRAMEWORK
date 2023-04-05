package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriverUtility;

public class LoginPage extends FileUtility  {
	
	WebDriver driver;
	WebDriverWait wait=null;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);;
	}
	
	
	//private By hr_EmailTextField = By.name("hr_email");
	@FindBy(name = "hr_email")
	private WebElement hr_EmailTextField;
	
	public void hrEmailText(String hrEmail) {
		hr_EmailTextField.sendKeys(hrEmail);
	}
	
	//private By hr_PasswordTextField = By.name("hr_password");
	@FindBy(name = "hr_password")
	private WebElement hr_PasswordTextField;
	
	public void hrPasswordText(String hrPassword) {
		hr_PasswordTextField.sendKeys(hrPassword);
	}
	
	//private By selectTypeDropDown = By.id("hr_type");
	//go with value 
	//"HR Head"
	//"HR Officer"
	//"HR Officer"
	@FindBy(id = "hr_type")
	private WebElement selectTypeDropDown;
	
	public void selectType(String position) {
		Select select = new Select(selectTypeDropDown);
		select.selectByValue(position);
	}
	
	public void selectByVisibleText(String position) {
		Select select = new Select(selectTypeDropDown);
		select.selectByVisibleText(position);
	}
	
	//private By rememberMeCheckBox = By.id("remember");
	@FindBy(id = "remember")
	private WebElement rememberMeCheckBox;
	
	public void markCheckbox() {
		if (rememberMeCheckBox.isSelected()) {
			
		}else
		rememberMeCheckBox.click();
	}
	
	//private By rememberMeText = By.className("icheck-primary");
	@FindBy(className = "icheck-primary")
	private WebElement rememberMeText;
	
	public String checkboxName() {
		return rememberMeText.getText();
	}
	
	//private By signInSubmit = By.name("login_hr");
	@FindBy(name = "login_hr")
	private WebElement signInSubmit;
	
	public void signInToDashboardpage() {
		wait= new WebDriverWait(driver, 10);
		signInSubmit.click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
		//return the dashboard page object here
	}
	
	public void SignInToAppUsingHrHead() throws Throwable
	{
		hrEmailText(readCommonData("hremail"));
      	hrPasswordText(readCommonData("hrpassword"));
      	selectType(readCommonData("hrtype"));
      	if(rememberMeCheckBox.isSelected())
      	{
      	}
      	else
          	markCheckbox();
      	signInSubmit.click();
      	//signInToDashboardpage();

	}
	
	public void SignInToAppUsingHrAss() throws Throwable
	{
		hrEmailText(readCommonData("hrassistantemail"));
      	hrPasswordText(readCommonData("hrassistantpassword"));
      	selectType(readCommonData("hrtypeass"));
      	if(rememberMeCheckBox.isSelected())
      	{
      	}
      	else
          	markCheckbox();
      	signInToDashboardpage();

	}
	
	public void loginToApp(ExcelUtility Elib, String sheetname, String email, String pass, String type) throws Throwable
	{
		hrEmailText((Elib.readExpDataFromExcel(sheetname, email)));
		hrPasswordText(Elib.readExpDataFromExcel(sheetname, pass));
		selectByVisibleText(Elib.readExpDataFromExcel(sheetname, type));
      	signInSubmit.click();

	}
	
	
	public boolean validateLoginPagePopup(WebDriverUtility wlib, String expPopupText) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}


}
