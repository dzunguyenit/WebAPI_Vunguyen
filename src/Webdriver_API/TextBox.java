package Webdriver_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBox {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dropdown");

	}

//	@Test
//	public void testCase01() {
//		driver.get("http://demo.guru99.com/v4/");
//		driver.get("http://demo.guru99.com/insurance/v1/index.php");
//	}

	@Test
	public void testCase02() throws Exception {
		Select combobox = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
//		combobox.selectByIndex(1);
//		combobox.selectByValue("2");
		combobox.selectByVisibleText("Option 2");
		Thread.sleep(2000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
