package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	private final WebDriver driver;

	public SignInPage(WebDriver driver) {

		this.driver = driver;
	}

	public void LoginValidUser(WebDriver driver, String email, String password){
		 driver.findElement(By.id("nim_authSignInUsernameInput")).sendKeys(email,password);
		 driver.findElement(By.id("nim_authSigninSubmitBtn")).click();
	 }
     public void switchToForgotPasswordPage(WebDriver driver){
    	 driver.findElement(By.id("nim_authSignInForgotPasswordLink")).click();	 
     }
     
     public void switchToCreateAccountPage(){
		 WebDriverWait wait = new WebDriverWait(driver, 200);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_authSignInCreateAccountLink")));
		 element.click();
     }
     public void switchToFaceBookPage(WebDriver driver){
    	 driver.findElement(By.id("nim_authSignInFaceBookLoginBtn")).click();
     }
}
