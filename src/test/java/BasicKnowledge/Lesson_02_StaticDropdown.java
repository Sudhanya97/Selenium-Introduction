package BasicKnowledge;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Lesson_02_StaticDropdown {

	@Test
	public void test2() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//BasicKnowledge//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

			WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByIndex(3);
			// when only one value is selected then we need to mention
			// getFirstSelectedOption() method to get one item only
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByVisibleText("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByValue("AED");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			driver.quit();
		}
	}

}
