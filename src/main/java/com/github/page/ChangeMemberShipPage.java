package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeMemberShipPage {
	public void switchToBasic(WebDriver driver){
		driver.findElement(By.id("nim_selectBasicButton")).click();
	}
    
	public void keepCurrentMembership(WebDriver driver){
		driver.findElement(By.id("nim_acctChgSubDoneBtn")).click();
	}
	
	public void cancelMembership(WebDriver driver){
		driver.findElement(By.id("nim_acctCancelSubLink")).click();
	}
	
	public void switchToAccountSummaryPage(WebDriver driver){
		driver.findElement(By.id("nim_acctBackLinkChange")).click();
	}
	
	public void updateToPremium(WebDriver driver){
		driver.findElement(By.id("nim_selectBasicButtonUp")).click();
	}
}
