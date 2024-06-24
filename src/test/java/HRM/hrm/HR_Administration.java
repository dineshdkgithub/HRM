package HRM.hrm;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		WebElement date =driver.findElement(By.id("joinedDate"));
		date.clear();
		date.sendKeys((String)mapdata.get("Joining Date"));
		//Select Location
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		//Location
		downenter();
		//next 
		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
		//Other ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otherId"))).sendKeys((String)mapdata.get("Other Id"));//S202112345
		//SSN/AADHAAR/ID NO
		driver.findElement(By.id("ssn")).sendKeys((String)mapdata.get("SSN"));//K12345678 
		//Date of Birth
		driver.findElement(By.cssSelector("#pimPersonalDetailsForm > materializecss-decorator:nth-child(4) > div > sf-decorator:nth-child(1) > div > span.hidden-date-widget > span:nth-child(1) > i")).click();
		//Month
		driver.findElement(By.cssSelector("#P736179699_root > div > div > div > div > div.picker__calendar-container > div > div.select-wrapper.picker__select--month > input")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Month")+"']")).click();
		//Year
		driver.findElement(By.cssSelector("#P736179699_root > div > div > div > div > div.picker__calendar-container > div > div.select-wrapper.picker__select--year > input")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Year")+"']")).click();
		//Date
		driver.findElement(By.xpath("//div[@aria-label='2000-07-21']")).click();
	}

}
