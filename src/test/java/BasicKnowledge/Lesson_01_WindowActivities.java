package BasicKnowledge;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lesson_01_WindowActivities {

	@Test
	public void test1() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//BasicKnowledge//GlobalData.properties");
		prop.load(fis);
		//Used ternary operator : check if browser name is coming from outside like mvn command else use properties file
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.navigate().to("https://google.com");
			driver.navigate().back();
			driver.navigate().forward();
			driver.quit();
		}
	}

}
