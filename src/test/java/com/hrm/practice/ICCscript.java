package com.hrm.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCscript {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		WebDriver driver= WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
		//xpath to fetch team names
		List<WebElement> teamNames = driver.findElements(By.xpath("//tbody/tr/td[2]"));
//		for (int i = 0; i < teamNames.size(); i++) {
//			String names = teamNames.get(i).getText();
//			System.out.println(names);
//		}
		//to fetch both position and names.
		//xpath to fetch position
		List<WebElement> position = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		for (int i = 0; i < teamNames.size(); i++) {
			String namesAndPosition = teamNames.get(i).getText()+"  "+ position.get(i).getText();
			System.out.println(namesAndPosition);
		}
		//to check the particular team is present or not
		String checkname="India";
		Boolean flag=false;
		for (WebElement ele : teamNames) {
			if (ele.getText().equals(checkname)) {
				System.out.println("is present");
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("not present");
		}
		checkTeamRatings();
	}
	

	public static void checkTeamRatings()
	{
		WebDriver driver= WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");

        List<WebElement> teamNames = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        ArrayList<String> list= new ArrayList<String>();
        for (int i = 0; i <teamNames.size(); i++) {
			list.add(teamNames.get(i).getText());
		}
        for (String myTeams : list) {
        	//xpath to find particular team rating by passing team names as reference.
			String rating="//span[text()='"+myTeams+"']/../../td[5]";
			String teamRating = driver.findElement(By.xpath(rating)).getText();
			System.out.println("Teams-->" +myTeams+ "-->(rating is) " + teamRating);
		}
	}

}
