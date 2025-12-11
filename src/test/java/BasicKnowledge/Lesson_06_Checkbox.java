package BasicKnowledge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lesson_06_Checkbox {

	@Test
	public void test6() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		System.out.println("Total Checkboxes : "+ driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.quit();
		
	}

}
