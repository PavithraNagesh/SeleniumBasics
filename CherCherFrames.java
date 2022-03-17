package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		Thread.sleep(3000);
		driver.findElement(By.tagName("input")).sendKeys("Testing");
		
		WebElement frame2 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame2);
		Thread.sleep(3000);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame3);
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Baby Cat");
		driver.switchTo().defaultContent();

	}

}
