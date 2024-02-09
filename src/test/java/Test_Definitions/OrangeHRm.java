package Test_Definitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRm {
	 public static WebDriver driver;
	 public static String val;

	@Given("i open with  the url {string}")
	public void i_open_with_the_url(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@Then("i should see the login page")
	public void i_should_see_the_login_page() {
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) {
			System.out.println("pass");

		}
	}

	@When("i entered the username {string}")
	public void i_entered_the_username(String uid) {

		driver.findElement(By.id("txtUsername")).sendKeys(uid);
	}

	@When("i entered the password {string}")
	public void i_entered_the_password(String pwd) {
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@When("i click on login button")
	public void i_click_on_login_button() {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("i should see the Admin module")
	public void i_should_see_the_admin_module() {
		if (driver.findElement(By.linkText("Admin")).isDisplayed()) {
			System.out.println("Admin module Displayed");
		}

	}

	@When("i click on Logout")
	public void i_click_on_logout() {
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("i close the browser")
	public void i_close_the_browser() {
		driver.close();
	}
	
	@When("i entered pwd as {string}")
	public void i_entered_pwd_as(String pword) {
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}
	@Then("i should see th error message")
	public void i_should_see_th_error_message() {
		
		String ermsg;
		ermsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		if (ermsg.contains("invalid")|| ermsg.contains("empty"))
		{
			System.out.println("Error message displayed");
			
		}	
	}
	
	@When("i goto add employee page")
	public void i_goto_add_employee_page() {
	   
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	}
	@When("i entered first name as {string}")
	public void i_entered_first_name_as(String fname) 
	{
	  driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	@When("i entered last name as {string}")
	public void i_entered_last_name_as(String lname) {
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	    val=driver.findElement(By.id("employeeId")).getAttribute("value");
	    
	}
	@When("i click on save button")
	public void i_click_on_save_button() {
		
	    driver.findElement(By.id("btnSave")).click();
	}
	@Then("i should the registered employee in Employee List")
	public void i_should_the_registered_employee_in_employee_list() {
	    driver.findElement(By.linkText("Employee List")).click();
	    driver.findElement(By.id("empsearch_id")).sendKeys(val);
	    driver.findElement(By.id("searchBtn")).click();
	    WebElement element=driver.findElement(By.id("resultTable"));
		List<WebElement> row =element.findElements(By.tagName("tr"));
		for(int i=1;i<row.size();i++) {
			List<WebElement> tcol =row.get(i).findElements(By.tagName("td"));
			if (tcol.get(1).getText().equals(val)) 
			{
				System.out.println("Registered Employee displayed");
				
			}
		}
	
	}
	@When("i click logout")
	public void i_click_logout() {
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@When("i goto add user page")
	public void i_goto_add_user_page() {

		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("btnAdd")).click();

	}
	
	

@When("i input all the valid data {string} and {string} and {string}")
public void i_input_all_the_valid_data_and_and(String empname, String uname, String password) throws InterruptedException {
   
	 Select role= new Select(driver.findElement(By.id("systemUser_userType")));
	 role.selectByVisibleText("Admin");
	 driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
	 driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
//	 Select status = new Select(driver.findElement(By.id("systemUser_status")));
//	 status.selectByVisibleText("Enabled");
	 driver.findElement(By.id("systemUser_password")).sendKeys(password);
	driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
	Thread.sleep(2000);
	 
	
}

@Then("i should see the registered user in the list {string}")
public void i_should_see_the_registered_user_in_the_list(String uname) {
    
	driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
	driver.findElement(By.id("searchBtn")).click();
	WebElement utbl =driver.findElement(By.id("resultTable"));
	List<WebElement> tbrows =utbl.findElements(By.tagName("tr"));
		for(int i=1;i<tbrows.size();i++) {
			List<WebElement> tbco =tbrows.get(i).findElements(By.tagName("td"));
			if (tbco.get(i).getText().contains(uname)) {
				
				System.out.println("Username displayed");
			}
		}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
