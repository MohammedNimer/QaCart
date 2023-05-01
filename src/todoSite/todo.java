package todoSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class todo {

	WebDriver driver=new ChromeDriver();
	SoftAssert myAssertion=new SoftAssert();
	
	@BeforeTest
	public void setup() {
	}
	
	@Test(priority = 1)
	public void register() throws InterruptedException {
		driver.get("https://todo.qacart.com/");
	Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/a[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[1]/div/input")).sendKeys("Mohammed");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/input")).sendKeys("Nimer");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[3]/div/input")).sendKeys("mohammed.nimer.98@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[4]/div/input")).sendKeys("Mo7star@");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[5]/div/input")).sendKeys("Mo7star@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button/span[1]")).click();
		
		boolean emailAlreadyRegisteredMessage =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[6]")).isDisplayed(); //
		System.out.println(emailAlreadyRegisteredMessage+" : emailAlreadyRegisteredMessage displayed");
		myAssertion.assertEquals(emailAlreadyRegisteredMessage, true);
		myAssertion.assertAll();
	}
	
@Test(priority = 2)
public void addToDo() throws InterruptedException {
	driver.get("https://todo.qacart.com/");
	driver.findElement(By.id("email")).sendKeys("mohammed.nimer.98@gmail.com");
	driver.findElement(By.id("password")).sendKeys("Mo7star@");
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/input")).sendKeys("firstToDo");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button")).click();
	Thread.sleep(1500);
	boolean FirstToDo= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]")).isDisplayed();
	System.out.println(FirstToDo+" : ToDo Item displayed");
	myAssertion.assertEquals(FirstToDo, true);
	myAssertion.assertAll();
}

@Test(priority = 3)
public void deleteToDo() throws InterruptedException {
	
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[data-testid='delete']")).click();
	Thread.sleep(2000);	
	
	System.out.println(driver.findElement(By.cssSelector("[data-testid='no-todos']")).getText());
	
	String actual=driver.findElement(By.cssSelector("[data-testid='no-todos']")).getText();
	myAssertion.assertEquals(actual, "No Available Todos");
	myAssertion.assertAll();
}



}
