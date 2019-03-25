package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonFuntion {

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void click(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	public void input(WebDriver driver, By by, String value) {
		WebElement element = driver.findElement(by);
		element.sendKeys(value);
	}

	public String getText(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

}
