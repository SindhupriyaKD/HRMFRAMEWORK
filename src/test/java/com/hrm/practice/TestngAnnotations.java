package com.hrm.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotations {
	@BeforeSuite
	public void beforesuit() {
		System.out.println("Establish database connection");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Parrallel exe");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Launch the browser");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Login to application");

	}
	@Test
	public void test()
	{
		System.out.println("execute script");

	}
	@AfterMethod
	
	public void afterMethod()
	{
		System.out.println("logout from application");

	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("quit the browser");
	}
	
	@AfterSuite
	public void aftersuit() {
		System.out.println("close db");
	}
}
