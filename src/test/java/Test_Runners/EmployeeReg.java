package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Featurefiles/Emp.feature", glue = "Test_Definitions", dryRun = false, plugin = {"pretty","html:reports/employee.html"})
public class EmployeeReg 
{
	
}
