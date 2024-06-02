import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class soso {
	
	WebDriver driver = new ChromeDriver(); 
	
	@BeforeTest
	
	public void myBeforeTest() {
		
	driver.get("http://192.168.1.15:5500/index.html");
	
	driver.switchTo().alert().accept();
	
	driver.manage().window().maximize();
	}
	
	@Test
	public void login() throws InterruptedException{
		WebElement username = driver.findElement(By.xpath("/html/body/form/input[1]"));
		WebElement password = driver.findElement(By.xpath("/html/body/form/input[2]"));
		WebElement loginButton =  driver.findElement(By.name("soso"));
Thread.sleep(2000);
		username.sendKeys("asaqa001@gmail.com");
		Thread.sleep(2000);

		password.sendKeys("iloveyou");
		Thread.sleep(2000);

		loginButton.click();
		
	}

}
