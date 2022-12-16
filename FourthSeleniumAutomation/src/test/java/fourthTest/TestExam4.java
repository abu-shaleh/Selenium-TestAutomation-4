package fourthTest;

import java.util.Collections;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestExam4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium Prj\\selenium-java-4.7.2\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// Hide control by automation
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
				WebDriver driver = new ChromeDriver(options);
				// Maximize window size
				driver.manage().window().maximize();
				driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
				WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
				WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
				WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
				WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
				
				jsAlert.click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				String alterOK = result.getText();
				Assert.assertEquals(alterOK, "You successfully clicked an alert");
				
				jsConfirm.click();
				Thread.sleep(1000);
				driver.switchTo().alert().dismiss();
				String alertCancenl = result.getText();
				Assert.assertEquals(alertCancenl, "You clicked: Cancel");
				Thread.sleep(2000);
				
				jsPrompt.click();
				Thread.sleep(2000);
				driver.switchTo().alert().sendKeys("This is 4th Test");
				driver.switchTo().alert().accept();
				String jsInput = result.getText();
				Assert.assertEquals(jsInput,"This is 4th Test");
				Thread.sleep(1000);
	}

}
