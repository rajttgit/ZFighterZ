package com.runners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions
(
	features	= "Features/02login.feature",
	
	glue		= {"com.test.login" , "com.utility"},
	
	plugin 		=	{ 
					"pretty",
					"html:target/cucumber-htmlreport", 
					"json:target/cucumber-report.json",
					"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" 
					} 
	
	//tags={"@login"}
)

@Test
public class LoginRunner extends AbstractTestNGCucumberTests
{
	@AfterClass
	public static void writeExtentReport() 
	{
		Reporter.loadXMLConfig(new File("config/loginreport.xml"));
	}
}