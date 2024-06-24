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
		String month =(String)mapdata.get("Month");
		String year=(String)mapdata.get("Year");
		String bdate=(String)mapdata.get("Date");
		String month1=(String)mapdata.get("month");
		driver.findElement(By.xpath("//span[text()='"+month+"']")).click();
		//Year
		driver.findElement(By.cssSelector("#P736179699_root > div > div > div > div > div.picker__calendar-container > div > div.select-wrapper.picker__select--year > input")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
		String date1=year+"-"+month1+"-"+bdate;
		//Date
		driver.findElement(By.xpath("//div[@aria-label='"+date1+"']")).click();
		//Marital Status
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//input[contains(@class, 'select-dropdown')]")).click();
		//Select Status
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Marital Status")+"']")).click();
		//Gender
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//input[contains(@class, 'select-dropdown')]")).click();
		//select gender
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Gender")+"']")).click();
		//Nationality
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input[contains(@class, 'select-dropdown')]")).click();
		//select nation
		driver.findElement(By.xpath("//span[text()='"+(String)mapdata.get("Nationality")+"']")).click();
		//Driver's License Number
		driver.findElement(By.id("licenseNo")).sendKeys((String)mapdata.get("License No"));
		//License Expiry Date
		driver.findElement(By.id("emp_dri_lice_exp_date")).sendKeys((String)mapdata.get("License Expiry Date"));
		//Next button
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		
		
		//Employment Details
		//Probation End Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).sendKeys((String)mapdata.get("Probation End Date"));
		//Date of Permanency
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).sendKeys((String)mapdata.get("Date of Permanency"));
		//Job Title
		driver.findElement(By.xpath("//div[@id='job_title_id']//input[contains(@class, 'placeholder dropdown-field-focus-element')]")).click();
		//select job
		driver.findElement(By.xpath("")).click();

	}

}
