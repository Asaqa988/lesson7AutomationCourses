import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void mySetup() throws InterruptedException {
		String myURL = "https://www.saucedemo.com/";
		driver.manage().window().maximize();
		driver.get(myURL);

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		WebElement UserName = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserName.sendKeys("standard_user");
		PasswordInputField.sendKeys("secret_sauce");
		LoginButton.click();

	}

	@Test(priority = 2)
	public void verifiyTheWordProductIsThere() {
		String expectedValue = "Products";

		String ActualValue = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

		Assert.assertEquals(ActualValue, expectedValue);
	}

	@Test(priority = 3)
	public void SortingItems() throws InterruptedException {
		Thread.sleep(1000);
		WebElement soso = driver.findElement(By.className("product_sort_container"));

		Select mySelctor = new Select(soso);

		mySelctor.selectByVisibleText("Price (low to high)");
//		Thread.sleep(3000);
//		driver.navigate().refresh();
//		mySelctor.selectByValue("za");
//		Thread.sleep(3000);
//		driver.navigate().refresh();

//		mySelctor.selectByIndex(1);

		String TheExpectedTheLowestPrice = "$49.99";

		List<WebElement> thePrices = driver.findElements(By.className("inventory_item_price"));

		System.out.println(thePrices.size());

		String ActuallowestPrice = thePrices.get(thePrices.size() - 1).getText();

		Assert.assertEquals(ActuallowestPrice, TheExpectedTheLowestPrice);

	}

}
