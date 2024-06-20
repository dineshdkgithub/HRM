package HRM.hrm;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HR_Administration extends Common_files{
	
	@Test(dataProvider = excel,testName = "Login",priority=1)
	public void Login(Map mapdata) throws InterruptedException{
		//Open Driver
		chromedriver();
		//Login
		login(driver,mapdata);
	}
	@Test(dataProvider = excel,testName = "Add",priority=2)
	public void Add_Employee(Map mapdata) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Click Employee List
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuQuickSearch_menuQuickSearch"))).sendKeys((String)mapdata.get("Menu"));
		downenter();
		//Add Employee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addEmployeeButton"))).click();
		//First Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box"))).sendKeys((String)mapdata.get("First Name"));
		//Middle Name
		driver.findElement(By.id("middle-name-box")).sendKeys((String)mapdata.get("Middle Name"));
		//Last Name
		driver.findElement(By.id("last-name-box")).sendKeys((String)mapdata.get("Last Name"));
		//Joining Date
		driver.findElement(By.xpath("//button[@class='btn date-picker-button']")).click();
		//Month Dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#P80850337_root > div > div > div > div > div.picker__calendar-container > div > div.dropdown.bootstrap-select.picker__select--month > button"))).click();
		//Select Month
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Month")+"']")).click();

	}
	

}
