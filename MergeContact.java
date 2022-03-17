package week4.day1;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getCurrentUrl());
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow = new LinkedList<String>(windowHandles);
		System.out.println(windowHandles.size());
		driver.switchTo().window(newWindow.get(1));
		System.out.println("First window "+driver.getTitle());
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[3]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> newWindow1 = new LinkedList<String>(windowHandles2);
		driver.switchTo().window(newWindow1.get(0));
		System.out.println("Second window "+driver.getTitle());
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> newWindow2 = new LinkedList<String>(windowHandles3);
		driver.switchTo().window(newWindow2.get(1));
		System.out.println("First Window "+driver.getTitle());
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[8]")).click();
		
		driver.switchTo().window(newWindow2.get(0));
		System.out.println("Second window "+driver.getTitle());
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());

	}

}
