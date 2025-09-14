package day22;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo1 {

	@Parameters({"gridURL","appURL"})
	@Test
	public void testA(String gridURL,String appURL) throws Exception
	{
		Reporter.log("TestA of Demo2 Of Day21",true);
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		driver.get(appURL);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("pointofsale");
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
	}
}
