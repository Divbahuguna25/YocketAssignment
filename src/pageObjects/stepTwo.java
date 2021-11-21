package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class stepTwo {

	static WebElement element = null;

	static By majorName = By.xpath("//input[@placeholder='Select Major']");

	static By collegeMarks = By.id("marks");

	static By collegeName = By.xpath("//input[@placeholder='Select College']");

	public static WebElement selectCollege(WebDriver driver, String course) {

		WebElement element = driver.findElement(collegeName);

		element.sendKeys(course);

		return element;

	}

	public static WebElement selectMajor(WebDriver driver, String course) {

		WebElement element = driver.findElement(majorName);

		element.sendKeys(course);

		return element;

	}

	public static WebElement grade(WebDriver driver) {
		WebElement gradeDrpDwn = driver.findElement(By.cssSelector("#marks_type"));

		gradeDrpDwn.submit();

		Select select = new Select(gradeDrpDwn);

		select.selectByValue("100");

		driver.findElement(collegeMarks).sendKeys("74");

		return element;
	}

	public static WebElement getscore(WebDriver driver) {

		driver.findElement(By.xpath("//*[contains(text(),'IELTS')]")).click();

		driver.findElement(By.id("ielts_overall_score")).sendKeys("7.5", Keys.ENTER);

		driver.findElement(By.xpath("//*[contains(text(),'GRE')]")).click();

		driver.findElement(By.id("verbal_score")).sendKeys("150", Keys.ENTER);

		driver.findElement(By.id("quant_score")).sendKeys("150", Keys.ENTER);

		driver.findElement(By.id("awa_score")).sendKeys("5", Keys.ENTER);

		driver.findElement(By.id("work_exp")).sendKeys("24");

		driver.findElement(By.xpath("//*[contains(text(),'National')]")).click();

		return element;

	}
}
