package com.hrm.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		driver.findElement(By.id("fromCity")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bengaluru");
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.id("departure")).click();
		Date date= new Date();
		String[] departureDate = date.toString().split(" ");
		String departure = departureDate[0]+" "+departureDate[1] +" "+departureDate[2]+" "+departureDate[5];
		driver.findElement(By.xpath("//div[@aria-label='"+departure+"']")).click();
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='Fri Jun 16 2023']")).click();
				break;
			} catch (Exception e) {
                driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();			}
		}
		
		
		
		
		
		

	}

}
