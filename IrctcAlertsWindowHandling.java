package week4.day1;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcAlertsWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notification")	;
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//span[@class=\"allcircle circleone\"]")).click();
		
		Set<String> window = driver.getWindowHandles();
		List<String> flight = new LinkedList<String>(window);
		System.out.println(window);
		System.out.println(window.size());
		driver.switchTo().window(flight.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//button[text()='Later']")).click();
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		String mail = driver.findElement(By.xpath("//a[text()=' flights@irctc.co.in']")).getText();
		System.out.println(mail);
		
		driver.switchTo().window(flight.get(0));
		driver.close();
		driver.quit();

	}

}
