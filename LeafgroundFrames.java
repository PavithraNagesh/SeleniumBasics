package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(frame1);
		WebElement click1 = driver.findElement(By.id("Click"));
		Thread.sleep(3000);
		click1.click();
		System.out.println(click1.getText());
		driver.switchTo().defaultContent();
		
		WebElement nestedframe = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]"));
		driver.switchTo().frame(nestedframe);
		driver.switchTo().frame(0);
		WebElement click2 = driver.findElement(By.id("Click1"));
		Thread.sleep(3000);
		click2.click();
		System.out.println(click2.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		List<WebElement> find = driver.findElements(By.tagName("iframe"));
		int size = find.size();
		System.out.println("Total no of frames : " +size);

	}

}
