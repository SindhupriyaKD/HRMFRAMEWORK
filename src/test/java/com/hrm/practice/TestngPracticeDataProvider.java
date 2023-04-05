package com.hrm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngPracticeDataProvider {
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]="Animal";
		obj[0][1]="Cow";
		obj[1][0]="Forest";
		obj[1][1]="Lion";
		obj[2][0]="Humans";
		obj[2][1]="Living Animals";
		return obj;
	}
	
	@Test(dataProvider = "data")
	public void getData(String parent, String child)
	{
		System.out.println("Parent--->" +parent+ "Child--->"+child);
	}

}
