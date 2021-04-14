package com.qa.seleniumtest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	
	static WebDriver driver = null;

	static Logger logger = LogManager.getRootLogger();
	
	public static void main(String[] args) {

	//	WebDriver driver = null ;
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		logger.info("Maximizing window");
		
		logger.debug("Maximizing window");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		logger.info("Hitting url");
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		List<WebElement> droplist =new Select(driver.findElement(By.id("month"))).getOptions();
		
		logger.info("Fetching dropdown options");
		
		Set<String> dropset= new HashSet<>();
		
		for(WebElement s : droplist)
		{
			if(dropset.add(s.getText())==false)
			{
				System.out.println("Text "+s.getText()+" is duplicate");
			}
			else
			{
				System.out.println("No Text is duplicate");
			}
			
			System.out.println(" Elements are "+s.getText());
		}
		
		driver.quit();
	}

}
