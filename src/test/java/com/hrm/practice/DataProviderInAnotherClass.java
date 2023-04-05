package com.hrm.practice;

import org.testng.annotations.Test;

public class DataProviderInAnotherClass {

	@Test(dataProviderClass = DataProviderr.class,dataProvider = "takedata")
	public void readData(String parent, String child)
	{
		System.out.println("Parent--->" +parent+ "Child--->"+child);;
	}
}
