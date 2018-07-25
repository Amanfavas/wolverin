package com.wolverine.test.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wolverine.test.config.TestConfig;
import com.wolverine.ui.objects.LoginPage;

public class TestSartPageU13679 
{
	WebDriver driver;
	LoginPage loginPage;
	@BeforeMethod
	public void preCondition()
	{
		driver = TestConfig.getDriverInstance();
		loginPage =  new LoginPage(driver);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testStatPageTC18532()
	{
		loginPage.waitForLoginPageToLoad();
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		boolean loginButtonStatus = 
				loginPage.getLoginButton().isEnabled();
		Assert.assertEquals(loginButtonStatus, true);
		WebElement usernameTextbox =loginPage.getUsernameTextbox();
		Assert.assertNotNull(usernameTextbox);
		WebElement passwordTextbox = loginPage.getPasswordTextbox();
		Assert.assertNotNull(passwordTextbox);
	}
}
