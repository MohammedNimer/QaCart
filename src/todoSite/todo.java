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
		driver.findElement(By.cssSelector("[href='/signup']")).click();
		driver.findElement(By.cssSelector("[data-testid='first-name']")).sendKeys("Mohammed");
		driver.findElement(By.cssSelector("[data-testid='last-name']")).sendKeys("Nimer");
		driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys("mohammed.nimer.98@gmail.com");
		driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("Mo7star@");
		driver.findElement(By.cssSelector("[data-testid='confirm-password']")).sendKeys("Mo7star@");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[data-testid='submit']")).click();
		Thread.sleep(1000);

		boolean oppenedAccountURL=driver.getCurrentUrl().equals("https://todo.qacart.com/todo");
		System.out.println(oppenedAccountURL+" : New account oppened");
		if(oppenedAccountURL) {
			myAssertion.assertEquals(oppenedAccountURL, true);
			myAssertion.assertAll();
		}
		
		else {
		boolean emailAlreadyRegisteredMessage =driver.findElement(By.cssSelector("[class='MuiAlert-message']")).isDisplayed();
		System.out.println(emailAlreadyRegisteredMessage+" : emailAlreadyRegisteredMessage displayed");

		myAssertion.assertEquals(emailAlreadyRegisteredMessage, true);
		myAssertion.assertAll();
		}

	}
	
@Test(priority = 2)
public void addToDo() throws InterruptedException {
	Thread.sleep(1000);
	if(driver.getCurrentUrl().equals("https://todo.qacart.com/todo")) {
		driver.findElement(By.cssSelector("[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']")).click();
	}
	Thread.sleep(1000);

	driver.get("https://todo.qacart.com/");
	Thread.sleep(1000);

	driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys("mohammed.nimer.98@gmail.com");
	driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("Mo7star@");
	driver.findElement(By.cssSelector("[data-testid='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[class='MuiButtonBase-root MuiIconButton-root']")).click();
	driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("firstToDo");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
	Thread.sleep(1500);
	boolean FirstToDo= driver.findElement(By.cssSelector("[data-testid='todo-item']")).isDisplayed(); 
	System.out.println(FirstToDo+" : ToDo Item displayed");
	myAssertion.assertEquals(FirstToDo, true);
	myAssertion.assertAll();
}

@Test(priority = 3)
public void deleteToDo() throws InterruptedException {
	
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("[data-testid='delete']")).click();
	Thread.sleep(2000);	
	
	System.out.println(driver.findElement(By.cssSelector("[data-testid='no-todos']")).getText());
	
	String actual=driver.findElement(By.cssSelector("[data-testid='no-todos']")).getText();
	myAssertion.assertEquals(actual, "No Available Todos");
	myAssertion.assertAll();
}
}
