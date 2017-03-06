package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummaryPage {
    private final WebDriver driver;

    public AccountSummaryPage(WebDriver driver) {

        this.driver = driver;
    }
	public void signOut(WebDriver driver){
		driver.findElement(By.id("nim_acctAcctSummarySignOutLink")).click();
	}
    public void switchToReferLink(WebDriver driver){
    	driver.findElement(By.id("nim_acctSummaryRAFlink")).click();
    }
    public void connectWithFaceBook(WebDriver driver){
    	driver.findElement(By.id("nim_acctConnectFacebookLink")).click();
    }
    public void updateBillingInfo(WebDriver driver){
    	driver.findElement(By.id("nim_acctUpdateBillingInfoBtn")).click();	
    }
    public void getStarted(WebDriver driver){
    	driver.findElement(By.linkText("Get started")).click();
    }
    public void clickTextureLogo(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nim_layoutLogoImage\"]"))).click();
    }
}
