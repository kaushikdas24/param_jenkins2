package day22;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo2 {

	@Parameters({"gridURL","appURL"})
	@Test
	public void testA(String gridURL,String appURL) throws Exception
	{
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("report/spark.html");
		report.attachReporter(spark);
		ExtentTest extentTest=report.createTest("testA");
		extentTest.info("testA of Demo2 of day 22");
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		driver.get(appURL);
		extentTest.info(driver.getTitle());
		extentTest.info("Enter username,pw & click login");
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("pointofsale");
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(7000);
		extentTest.info(driver.getTitle());
		report.flush();
	}
}
