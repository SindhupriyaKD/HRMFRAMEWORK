package com.pomrepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.WebDriverUtility;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//button[normalize-space()='Add Admin']")
	private WebElement addAdminPopupButton;
	public void clickOnAddAdminButton()
	{
		addAdminPopupButton.click();
	}
	
	@FindBy(xpath = "//div[@class='row mb-2']//h1")
	private WebElement dashBoardTitle;
	
	@FindBy(xpath = "//h4[text()='Add Admin']")
	private WebElement addAdminFormPopupTitle;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveAdminFormButton;
	
	public void clickOnSaveButton()
	{
		saveAdminFormButton.click();
	}
	
	@FindBy(css = "tbody tr td:nth-child(2)")
	private List<WebElement> adminNames;
	
	@FindBy(xpath = "//b[text()='Welcome!,']")
	private WebElement profileLink;
	
	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement logout;
	
	@FindBy(xpath="//h4[text()='Edit Admin']/../..//input[@name='hr_email']")
	private WebElement editemail;
	
	@FindBy(xpath="//h4[text()='Edit Admin']/../..//input[@name='hr_password']")
	private WebElement editpass;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchbutton;
	
	public boolean clickOnSearchButtonAndSearch(String adminName, String checkname)
	{
		searchbutton.click();
		searchbutton.sendKeys(adminName);
		WebElement createdAdmin = driver.findElement(By.xpath("//tbody/tr/td[text()='"+checkname+"']"));
		if (createdAdmin.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void clickOnsaveedit(String name)
	{
		String acName=name;
		driver.findElement(By.xpath("//input[@value='"+acName+"']/../../../../..//button[text()='Save']")).click();
	}
	public void clickOnEditButton(String name)
	{
		String acName=name;
		driver.findElement(By.xpath("//td[text()='"+acName+"']/../td[9]/i[1]")).click();
	}
	
	public void EditAdminUnAndPass(String email, String pass)
	{
		editemail.clear();
		editemail.sendKeys(email);
		editpass.clear();
		editpass.sendKeys(pass);
	}

	public boolean validateAdminPagePopup(WebDriverUtility wlib, String expPopupText) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void fillAdminForm(HashMap<String,String> map) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (Entry<String, String> set : map.entrySet()) {
			
			if(set.getKey().equals("hr_type")) {
				WebElement selectType_dropdown = driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//select[@name='"+set.getKey()+"']"));
				Select selectType_DD = new Select(selectType_dropdown);
				selectType_DD.selectByVisibleText(set.getValue());	
			}else {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='"+set.getKey()+"']")))).sendKeys(set.getValue());
			}
		}
	}
	
	
	
	public boolean validateAddedAdminWithFirstName(String expAdminName) {
		boolean flag = false;
		for (WebElement adminName : adminNames) {
			if (adminName.getText().equals(expAdminName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public boolean validateAdminPagePopup1(WebDriverUtility wlib, String expPopupText) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
}
