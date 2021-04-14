package com.qa.seleniumtest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

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
	}

}
