package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="Featurefiles/AdminLogin.feature", glue = "Test_Definitions", dryRun = false, plugin = {"pretty", "html:reports/result.html"} )
public class AdminLogin extends AbstractTestNGCucumberTests
{
	
	

}
