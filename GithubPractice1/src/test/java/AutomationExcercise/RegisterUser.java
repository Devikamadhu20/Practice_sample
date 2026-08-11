package AutomationExcercise;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser {
	@Test
	public void CreateUser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("automationexercise"), "url doesnot match:"+url);
		
		WebElement ele = driver.findElement(By.xpath("//a[text()=' Home']"));
		Assert.assertTrue(ele.isDisplayed(), "home page is not visible");
		
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		WebElement signup = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		Assert.assertTrue(signup.isDisplayed(), "Signup is not visible");
		
		driver.findElement(By.name("name")).sendKeys("Devika");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("devika12@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		WebElement AccInfo = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
		Assert.assertTrue(AccInfo.isDisplayed(), "Account info. not dispayed");
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.name("name")).sendKeys("Devika");
		driver.findElement(By.name("email")).sendKeys("devika@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Devikaa@123");
		WebElement days = driver.findElement(By.id("days"));
		Select s =new Select(days);
		s.selectByIndex(2);
		WebElement month = driver.findElement(By.id("months"));
		Select se =new Select(month);
		se.selectByVisibleText("March");
		WebElement year = driver.findElement(By.id("years"));
		Select sel = new Select(year);
		sel.selectByVisibleText("2005");
		
		driver.close();
		
	}

}
