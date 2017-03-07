package com.github.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPage {
	private final WebDriver driver;

	public PricingPage(WebDriver driver) {

		this.driver = driver;
	}

	public void startBasicTrial(){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NIMPricingGrid_Light-desktop-0\"]/section/div/table/tfoot/tr/td[2]/a")));
		element.click();
	}
	public void startPremiumTrial(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NIMPricingGrid_Light-desktop-0\"]/section/div/table/tfoot/tr/td[3]/a")));
		element.click();
	}

	public void clickTextureLogo(){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-header\"]/div/h1/a")));
		element.click();
	}

	public void checkPricingPageIsLoaded(){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"NIMPricingGrid_Light-desktop-0\"]/section/div/table/tfoot/tr/td[2]/a")));
		Assert.assertTrue(driver.getPageSource().contains("Choose your plan for unlimited access to the world's best magazines"));
	}
}
