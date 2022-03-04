package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.name("USERNAME")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title); 
		driver.findElement(By.linkText("CRM/SFA")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		driver.findElement(By.linkText("Leads")).click();

		//to click create lead
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pavithra");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Nagesh");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pavi");
		driver.findElement(By.className("inputBox")).sendKeys("CSE");
		driver.findElement(By.name("description")).sendKeys("Creating Lead");
		driver.findElement(By.className("inputBox")).sendKeys("pavithra18n@gmail.com");
		WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(stateProvince);
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);
		//Click on edit button
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("wrong description");
		driver.findElement(By.name("submitButton")).click();
		String editpage = driver.getTitle();
		 System.out.println(editpage);
	}

}
