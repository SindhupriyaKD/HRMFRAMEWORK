package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class AddBranchesPage {
	public AddBranchesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Branches Name']")
	private WebElement branchesname;
	public void enterbranchesname(String branchname)
	{
		branchesname.sendKeys(branchname);
	}
	
	@FindBy(name="bran")
	private WebElement save;
	public void clickOnSaveButton()
	{
		save.click();
	}
	
	public boolean validateBranchPagePopup(WebDriverUtility wlib, String expPopupText, WebDriver driver) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}
}
