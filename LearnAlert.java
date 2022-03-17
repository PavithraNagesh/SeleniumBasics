package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//button[text()=\"Alert Box\"]")).click();
		
		//simple alert
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		System.out.println(alertmessage);
		Thread.sleep(3000);
		alert.accept();
		
		//confirmation alert
		driver.findElement(By.xpath("//button[text()=\"Confirm Box\"]")).click();
		Thread.sleep(3000);
		alert.dismiss();
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		
		//prompt alert
		driver.findElement(By.xpath("//button[text()=\"Prompt Box\"]")).click();
		Thread.sleep(3000);
		alert.sendKeys("Test");
		Thread.sleep(3000);
		alert.accept();
		String promptmessage = driver.findElement(By.id("result1")).getText();
		System.out.println(promptmessage);
		
		if(promptmessage.contains("Test")) {
			System.out.println("message entered properly");
		}else {
			System.out.println("not entered properly");
		}
		
		//sweet alert
		driver.findElement(By.xpath("//button[text()=\"Sweet Alert\"]")).click();
		String sweetmessage = driver.findElement(By.xpath("//div[text()=\"Happy Coding!\"]")).getText();
		System.out.println(sweetmessage);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();

	}

}
