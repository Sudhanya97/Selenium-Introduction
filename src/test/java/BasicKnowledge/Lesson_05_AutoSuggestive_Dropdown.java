package BasicKnowledge;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lesson_05_AutoSuggestive_Dropdown {

	@Test
	public void test5() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//BasicKnowledge//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
		
		driver.quit();
		
	}
	}
}
