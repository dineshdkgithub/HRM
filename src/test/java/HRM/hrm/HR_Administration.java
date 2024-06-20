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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuQuickSearch_menuQuickSearch"))).sendKeys((String)mapdata.get("Menu"));
		downenter();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addEmployeeButton"))).click();
	}
	

}
