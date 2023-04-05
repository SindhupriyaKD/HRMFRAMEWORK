package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchPage {
	public BranchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[normalize-space()='Add Branches']")
	private WebElement addbranches;
	public void clickOnAddBranch()
	{
		addbranches.click();
	}
}
