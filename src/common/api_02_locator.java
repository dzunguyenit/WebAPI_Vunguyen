package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class api_02_locator extends commonFuntion {

	WebDriver driver;
	public String pathData = "/driver/";
	String userPath = System.getProperty("user.dir");
	String pathDriver = userPath.concat(pathData).concat("chromedriver.exe");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", pathDriver);
		driver = new ChromeDriver();
//		driver.get("http://live.guru99.com/");
		openUrl(driver, "http://live.guru99.com/");
//		driver.manage().window().maximize();
		maximizeBrowser(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyInformation() {

		click(driver, By.xpath("//div[@class='footer']//a[text()='My Account']"));

//		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
//		driver.findElement(By.id("email")).sendKeys("");

		input(driver, By.xpath("//input[@class='input-text required-entry validate-email']"), "");

//		driver.findElement(By.id("pass")).sendKeys("");

		input(driver, By.xpath("//input[@class ='input-text required-entry validate-password']"), "");
		click(driver, By.cssSelector("button[id='send2']"));

		// Step 03 - Ä�á»ƒ trá»‘ng Username/ Password - Click Login button
//		driver.findElement(By.id("send2")).click();

		String errorEmail = getText(driver, "//div[@id='advice-required-entry-email']");
		Assert.assertEquals("This is a required field.", errorEmail);

		String errorPassword = getText(driver, "//div[@id='advice-required-entry-pass']");
		Assert.assertEquals("This is a required field.", errorPassword);
	}

//	@Test
	public void TC_02_LoginWithEmailInvalid() {

		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		// Nháº­p username khÃ´ng há»£p lá»‡: abc@gmail.com
		// Nháº­p password há»£p lá»‡
		// Click Login button
		driver.findElement(By.id("send2")).click();

		// Verify message thÃ´ng bÃ¡o lá»—i
		String errorEmail = driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText();
		Assert.assertEquals("Invalid login or password.", errorEmail);

	}

	@Test
	public void TC_03_LoginWithPasswordIncorrect() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("dzunguyenit@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		// Nháº­p username há»£p lá»‡: dzunguyenit@gmail.com
		// Nháº­p password khÃ´ng há»£p lá»‡
		// Click Login button
		driver.findElement(By.id("send2")).click();

		String errorPassword = driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText();
		Assert.assertEquals("Invalid login or password.", errorPassword);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
