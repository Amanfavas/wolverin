package com.wolverine.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wolverine.utils.lib.DataHandlers;

public class TestConfig
{
	public static WebDriver getDriverInstance()
	{
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromProperties
				("./test-config/test-data.properties", "browser");
		String url = DataHandlers.getDataFromProperties
				("./test-config/test-data.properties", "url");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", 
					"./browser-server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./browser-server/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else
		{
			System.err.println("Invalid Browser option please check");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
