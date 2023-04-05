package com.pomrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.WebDriverUtility;

public class CreateEmployeePage {
	WebDriver driver;
	public CreateEmployeePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath=("//button[contains(text(),'Add Employee')]"))
	 private WebElement addEmployee;
	 
	 public void clickOnAddEmployee()
	 {
		 addEmployee.click();
	 }
	 @FindBy(xpath=("//h4[text()='Add Employee']/../..//input[@name='employee_companyid']"))
	 private WebElement companyID;
	 
	 public void enterCompanyId(String id)
	 {
		 companyID.sendKeys(id);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_firstname']")
	 private WebElement firstNameTF;
	 
	 public void enterfirstNameTF(String firstname)
	 {
		 firstNameTF.sendKeys(firstname);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_lastname']")
	 private WebElement lastName;
	 
	 public void enterlastName(String lastname)
	 {
		 lastName.sendKeys(lastname);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_middlename']")
	 private WebElement middleName;
	 
	 public void entermiddleName(String midleName)
	 {
		 middleName.sendKeys(midleName);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='branches_datefrom']")
	 private WebElement branchesDateFrom;
	 
	 public void enterbranchesDateFrom(String datefrom)
	 {
		 branchesDateFrom.sendKeys(datefrom);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='branches_recentdate']")
		private WebElement branchesRecentDate;
	 
	 public void enterRecentDate(String recentdate)
	 {
		 branchesRecentDate.sendKeys(recentdate);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//select[@name='employee_department']")
	  private WebElement department;
	 
	 public void selectdepartment(WebDriverUtility wLib, String text)
	 {
		wLib.selectByVisibleText(department, text);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//select[@name='employee_branches']")
	 private WebElement branches;
	 
	 public void selectBranches(WebDriverUtility wLib, String text)
	 {
		 wLib.selectByVisibleText(branches, text);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_position']")
	 private WebElement position; 
	 
	 public void enterPosition(String pos)
	 {
		 position.sendKeys(pos);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_contact']")
		private WebElement contact;
	 
	 public void enterContactNum(String contactnum)
	 {
		 contact.sendKeys(contactnum);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_sss']")
		private WebElement sss;
	 
	 public void entersssNum(String sssnum)
	 {
		 sss.sendKeys(sssnum);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_tin']")
		private WebElement tin;
	 
	 public void enterTinNum(String tinnum)
	 {
		 tin.sendKeys(tinnum);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_hdmf_pagibig']")
		private WebElement hdmf;
	 
	 public void enterHdmfNum(String hdmfnum)
	 {
		 hdmf.sendKeys(hdmfnum);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_gsis']")
		private WebElement gsis;
	 
	 public void entergsisNum(String gsisnum)
	 {
		 gsis.sendKeys(gsisnum);
	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_file201']")
		private WebElement File201;
	 
//	 public void enterFilePath(String filepath)
//	 {
//		 File201.sendKeys(filepath);
//	 }
	 
	 @FindBy(xpath="//h4[text()='Add Employee']/../..//input[@name='employee_image']")
		private WebElement empPic;
	 
//	 public void enteremppic(String imgpath)
//	 {
//		 empPic.sendKeys(imgpath);
//	 }
	 
	 @FindBy(xpath="//button[text()='Save']")
	 private WebElement save;
	 
	 @FindBy(xpath="//h4[text()='Delete Employee']/../..//button[text()='Delete']")
	 private WebElement delEmp;
	 
	 
	 public void uploadFileAndImg(String file, String img)
	 {
		 File201.sendKeys(file);
		 empPic.sendKeys(img);
		 save.click();
	 }
	 
	 public void deleteEmp(DashBoardPage db, String name)
	 {
		db.gotoEmployeePage();
		//String name="Sindhu";
		driver.findElement(By.xpath("//td[text()='"+name+"']/../td[9]/i[3]")).click();
		delEmp.click();
	 }
	 
	 public boolean validateEmpPagePopup(WebDriverUtility wlib, String expPopupText, WebDriver driver) throws Throwable
		{
			String actPopup = wlib.getAlertText(driver);
			if (actPopup.equals(expPopupText)) {
				return true;
			} else {
				return false;
			}
		}
	 public void fillEmpForm(HashMap<String, String> map, WebDriver driver)
	 {
		 WebDriverWait wait= new WebDriverWait(driver, 10); 
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
		 
	 }
	 
	 

}
