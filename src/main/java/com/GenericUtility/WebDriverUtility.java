package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriverWait wait;
	
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait for and element and submit.
	 * @author Sindhupriya
	 * @param driver
	 * @param elemetToClick
	 */
	public void clickOnElement(WebDriver driver,WebElement elementToClick)
	{
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elementToClick));
		elementToClick.click();
		
	}
	/**
	 * This method is used to wait for and element and submit.
	 * @author Sindhupriya
	 * @param driver
	 * @param elementToSubmit
	 */
	public void submitAnElement(WebDriver driver, WebElement elementToSubmit) {
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elementToSubmit));
		elementToSubmit.submit();
	}

	/**
	 * This method is used to wait for and element and send data.
	 * @author Sindhupriya
	 * @param driver
	 * @param elementToSendKeys
	 * @param keys
	 */
	public void sendKeysToElement(WebDriver driver, WebElement elementToSendKeys, String keys) {
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elementToSendKeys));
		elementToSendKeys.clear();
		elementToSendKeys.sendKeys(keys);
	}
	
	public void frameAsIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch the driver control to the frame using its name or id attribute value.
	 * @author Sindhupriya
	 * @param driver
	 * @param idOrName
	 */
	public void frameAsIdOrName(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	/**
	 * This method is used to switch the driver control to the frame by using frameElement reference
	 * @author Sindhupriya
	 * @param driver
	 * @param frameElement
	 */
	public void frameAsWebElement(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method provides the time delay for the expected conditions to be successful
	 * @author Sindhupriya
	 * @param driver
	 */
	public Boolean expliciteWaitForCompleteTitle(WebDriver driver, String completeTitle)
	{
		wait=new WebDriverWait(driver, 5);
		Boolean ref = wait.until(ExpectedConditions.titleIs(completeTitle));
		return ref;
	}
	
	public Boolean explicitWaitForPartialTitle(WebDriver driver, String partialTitle)
	{
		wait=new WebDriverWait(driver, 5);
		Boolean ref = wait.until(ExpectedConditions.titleContains(partialTitle));
		return ref;

	}
	
	public Boolean explicitWaitForDomToLoad(WebDriver driver, WebElement elementForWait, String attName, String attValue  )
	{
		wait=new WebDriverWait(driver, 5);
		Boolean ref = wait.until(ExpectedConditions.attributeToBe(elementForWait, attName, attValue));
		return ref;

	}
	public  WebElement explicitWaitForElementVisibility(WebDriver driver,WebElement elementToVisible)
	{
		wait=new WebDriverWait(driver, 5);
		 WebElement ref = wait.until(ExpectedConditions.visibilityOf(elementToVisible));
		 return ref;
		
	}
	
	public void selectByIndex(WebElement element, int indexnum)
	{
		Select select= new Select(element);
		select.selectByIndex(indexnum);
	}
	public void selectByValue(WebElement element, String value)
	{
		Select select= new Select(element);
		select.selectByValue(value);
	}
	public void selectByVisibleText(WebElement element, String text)
	{
		Select select= new Select(element);
		select.selectByVisibleText(text);

	}
	
	public File takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".errorshots"+LocalDateTime.now().toString().replace(':', '-'));
		FileUtils.copyFile(tempFile, destFile);
		return destFile;
	}
	
	public void robotToZoomOut() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);   
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	
	public void robotToZoomIn() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	
	public void javaScriptScrolling(WebDriver driver, int xaxis,int yaxis)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+");");
	}
	
	public void waitUntilAlertIsPresent(WebDriver driver)
	{
		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	public String getTagTextOfElement(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
		return ele.getText();
	}
	
	public String getAlertText(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
	    return	wait.until(ExpectedConditions.alertIsPresent()).getText();
		
	}

}
