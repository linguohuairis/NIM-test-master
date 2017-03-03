package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

	private final WebDriver driver;

	public CreateAccountPage(WebDriver driver) {

		this.driver = driver;
	}

	public void createValidAccount(String email, String password){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_authCreateAcctSubmitBtn")));
		driver.findElement(By.id("nim_authCreateAcctUsernameInput")).sendKeys(email);
		driver.findElement(By.id("nim_authCreateAcctPasswordInput")).sendKeys(password);
		driver.findElement(By.id("nim_authCreateAcctSubmitBtn")).click();		
	}
	
	public void switchToSignInPage(WebDriver driver){
		driver.findElement(By.id("nim_authCreateAcctSignInLink")).click();
	}
}
