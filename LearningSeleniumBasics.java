package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningSeleniumBasics {

	public static void main(String[] args) throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeDriver driver = new ChromeDriver();
      driver.get("http://leaftaps.com/opentaps/control/login");
		 driver.manage().window().maximize();
		 driver.findElement(By.name("USERNAME")).sendKeys("demoSalesManager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 String title = driver.getTitle();
		 System.out.println(title); 
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 String title2 = driver.getTitle();
		 System.out.println(title2);
		 driver.findElement(By.linkText("Leads")).click();
		 String leadpage = driver.getTitle();
		 System.out.println(leadpage);
		
		 // to click create lead
		 driver.findElement(By.linkText("Create Lead")).click();
		 //Enter CompanyName Field Using id Locator
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		 //Enter FirstName Field Using id Locator
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pavithra");
		//Enter LastName Field Using id Locator
		 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Nagesh");
        //Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pavi");
		 //Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.className("inputBox")).sendKeys("CSE");
		 //Enter Description Field Using any Locator of your choice
		 driver.findElement(By.name("description")).sendKeys("Creating Lead");
		 //Enter your email in the E-mail address Field using the locator of your choice
		 driver.findElement(By.className("inputBox")).sendKeys("pavithra18n@gmail.com");
		 //Select State/Province as NewYork Using Visible Text
		 WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		 Select state = new Select(stateProvince);
		 state.selectByVisibleText("New York");
		 //Click on Create Button
		 driver.findElement(By.name("submitButton")).click();
		 //Get the Title of Resulting Page
		 String result = driver.getTitle();
		 System.out.println(result);
		 
		 //Click on edit button
		 driver.findElement(By.linkText("Edit")).click();
		 //Clear the Description Field using .clear()
		 driver.findElement(By.id("updateLeadForm_description")).clear();
		 //Fill ImportantNote Field with Any text
		 driver.findElement(By.name("importantNote")).sendKeys("wrong description");
		 //Click on update button 
		 driver.findElement(By.name("submitButton")).click();
		 //Get the Title of Resulting Page
		 String editpage = driver.getTitle();
		 System.out.println(editpage);
		 
		 //Click on Duplicate button
		 driver.findElement(By.linkText("Duplicate Lead")).click();
		 //Clear the CompanyName Field using .clear() And Enter new CompanyName
		 driver.findElement(By.id("createLeadForm_companyName")).clear();
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test");
		 //Clear the FirstName Field using .clear() And Enter new FirstName
		 driver.findElement(By.id("createLeadForm_firstName")).clear();
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kiran");
		 //Click on Create Lead Button
		 driver.findElement(By.name("submitButton")).click();
		 //Get the Title of Resulting Page
		 String duplicatepage = driver.getTitle();
		 System.out.println(duplicatepage);
		 driver.findElement(By.linkText("Delete")).click();
		
	   
	}

}
