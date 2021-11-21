package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonObjects {

	static WebElement element = null;

	public static WebElement mastersButton(WebDriver driver) {

		WebElement element = driver
				.findElement(By.xpath("//a[@href='/college-finder/masters'] //*[contains(text(),'Masters')]"));
		return element;

	}

	public static WebElement selectCountry(WebDriver driver) {

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));

		return element;

	}

	public static WebElement selectCourse(WebDriver driver, String Course) {

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select Major']"));

		
		element.sendKeys(Course);

		
		return element;

	}

}
