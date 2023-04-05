package com.hrm.practice;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.annotations.Test;

public class TestngPractice {

	@Test(priority = 2)
	public void eat()
	{
		System.out.println("eating");
	}
	@Test(priority = 4,dependsOnMethods = "jump")
	public void dance()
	{
		System.out.println("dancing");
	}
	@Test(priority = 1)
	public void sing()
	{
		System.out.println("singing");
	}
	@Test(priority = 3)
	public void jump()
	{
		System.out.println("jumping");
	}
}
