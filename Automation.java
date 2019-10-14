package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Automation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");  
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("Weight Loss")) {
			System.out.println("Page Title has - Weight Loss");
		}
		else System.out.println("Page Title not has - Weight Loss");
		
		driver.findElement(By.xpath("(//span[contains(text(),'Find a Studio')])[1]")).click();
		String pageTitle1 = driver.getTitle();
		if (pageTitle1.contains("Meetings Near You")) {
			System.out.println("Page Title has - Meetings Near You");
		}
		else System.out.println("Page Title not has - Meetings Near You");
		
		
		driver.findElement(By.xpath("//input[@id=\"meetingSearch\"]")).sendKeys("10011");
		driver.findElement(By.xpath("//button[@ng-click=\"mfsearch.$valid && searchSubmit(searchText)\"]")).click();
		
		
		String locationname = driver.findElement(By.xpath("(//div[@class=\"location__name\"])[1]")).getText();
		String distant = driver.findElement(By.xpath("(//div[@class=\"location__distance\"])[1]")).getText();
		System.out.println("Name of first result is "+locationname);
		System.out.println("Distant of the location is "+distant);
		
		
		driver.findElement(By.xpath("(//div[@class=\"location__name\"])[1]")).click();
		
		String actualName = driver.findElement(By.xpath("//span[@ng-if=\"!linkName\"]")).getText();
		Assert.assertEquals(actualName, locationname);
		
		
		System.out.println("Today's Working Hours "+driver.findElement(By.xpath("(//div[@ng-repeat=\"meeting in day.meetings\"])[24]")).getText());
		System.out.println("Today's Working Hours "+driver.findElement(By.xpath("(//div[@ng-repeat=\"meeting in day.meetings\"])[25]")).getText());
	}

}
