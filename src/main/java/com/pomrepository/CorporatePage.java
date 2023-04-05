package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporatePage {
	public CorporatePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[normalize-space()='Add Corporate']")
	private WebElement addCorporateButton;
	 public void clickOnAddCorporateButton()
	 {
		 addCorporateButton.click();
	 }

}
