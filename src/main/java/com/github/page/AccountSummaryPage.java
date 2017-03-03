package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPage {
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
}
