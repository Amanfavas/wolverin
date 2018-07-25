package com.wolverine.ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.
			visibilityOfAllElementsLocatedBy(By.name("LoginForm")));
	}
	public WebElement getUsernameTextbox()
	{
		WebElement element = 
				driver.findElement(By.name("username"));
		return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	public WebElement getLoginErrorMessage()
	{
		return driver.findElement(By.xpath
				("//span[contains(text(), 'Username or Password')]"));
	}
}

