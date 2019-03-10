package Webdriver_API;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBox {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://pay.zing.vn/wplogin/mobile/jxm");
		driver.manage().window().maximize();

	}

//	@Test
//	public void testCase01() {
//		driver.get("http://demo.guru99.com/v4/");
//		driver.get("http://demo.guru99.com/insurance/v1/index.php");
//	}

	@Test
	public void testCase02() throws Exception {

		driver.findElement(By.xpath("//input[@id='u']")).sendKeys("giinboo2");
		driver.findElement(By.xpath("//input[@id='p']")).sendKeys("Aa123456!");
		driver.findElement(By.xpath("//button[@id='login_submit_btn']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//
//		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Chọn cụm máy chủ')]/parent::button"));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		element.click();

		Thread.sleep(5000);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//span[contains(text(),'Chọn cụm máy chủ')]/parent::button")).click();
//		executor.executeScript("$('span:contains(\"Chọn cụm máy chủ\")').parents('button').click()");
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.xpath("//li[@data-value]/span"));
		for (WebElement elementList : list) {
			if (elementList.getText().equals("Cụm máy chủ 11 - 20")) {
				elementList.click();
				break;

			}
//
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
