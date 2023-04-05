package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class AddCorporatePage {
	public AddCorporatePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Corporate Name']")
	private WebElement CorporateName;
	
	public void enterCorporateName(String corpname)
	{
		CorporateName.sendKeys(corpname);
	}
	
	@FindBy(name="corp")
	private WebElement saveButton;
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public boolean validateCorportaePagePopup(WebDriverUtility wlib, String expPopupText, WebDriver driver) throws Throwable
	{
		String actPopup = wlib.getAlertText(driver);
		if (actPopup.equals(expPopupText)) {
			return true;
		} else {
			return false;
		}
	}
	
}
