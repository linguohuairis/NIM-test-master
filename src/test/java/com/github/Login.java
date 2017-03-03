package com.github;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    public WebDriver driver;
    
    @Before
	public void setUp(){
		System.out.print("1111111111111");
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.qa.texture.com");
		System.out.print("2222222222");
	}
    
	@Test
	public void SNF1(){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-header\"]/div/h1/a")));
	    element.click();
//	    Assert.assertTrue(driver.getPageSource().contains("Account Creation Form Title"));
	}
	
	@Test
	public void SNF2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-15\"]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"NIMNewsstand-desktop-0\"]/section/div/aside/div[2]/ul/li[1]/a"))).click();
		Assert.assertTrue(driver.getPageSource().contains("By Category"));
	}
	
	@After
	public void tearDown(){
		System.out.print("4444444");
		driver.quit();
	} 
}
