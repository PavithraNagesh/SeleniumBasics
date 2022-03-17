package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryitFrameAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);

	}

}
