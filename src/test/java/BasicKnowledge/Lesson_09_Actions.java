package BasicKnowledge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lesson_09_Actions {

	@Test
	public void test9() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().keyDown(Keys.SHIFT).sendKeys("hello");
		Thread.sleep(2000);
		WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
		Thread.sleep(2000);
		act.moveToElement(move).build().perform();
		driver.quit();
		
	}
	
}
