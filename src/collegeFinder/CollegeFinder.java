package collegeFinder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.commonObjects;
import pageObjects.stepTwo;

public class CollegeFinder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://yocket.com/college-finder");

		commonObjects.mastersButton(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select Country']")));

		commonObjects.selectCountry(driver).sendKeys("Canada", Keys.ENTER);

		commonObjects.selectCourse(driver, "Electrical");

		Thread.sleep(5000);

		List<WebElement> courses = driver.findElements(By.cssSelector("#vs2__listbox .vs__dropdown-option"));

		for (int i = 0; i <= courses.size() - 1; i++) {
			if (courses.get(i).getText().contains("Electrical Engineering")) {
				System.out.println("success");
				courses.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
		
		stepTwo.selectCollege(driver, "Uttaranchal");

		Thread.sleep(5000);

		List<WebElement> collegeName = driver.findElements(By.xpath("//ul[@id='vs4__listbox'] //li"));

		for (int i = 0; i <= collegeName.size() - 1; i++) {

			if (collegeName.get(i).getText().contains("Uttaranchal university")) {

				System.out.println("success");
				collegeName.get(i).click();
				break;
			}
		}

		stepTwo.selectMajor(driver, "Computer");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#vs6__listbox .vs__dropdown-option")));

		List<WebElement> majorCourse = driver.findElements(By.cssSelector("#vs6__listbox .vs__dropdown-option"));

		for (int i = 0; i <= majorCourse.size() - 1; i++) {
			if (majorCourse.get(i).getText().contains("Computer Science")) {
				System.out.println("success");
				majorCourse.get(i).click();
				break;
			}
		}

		stepTwo.grade(driver);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		stepTwo.getscore(driver);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
