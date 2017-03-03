package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftReceiptPage {
	public void switchToAccountSummaryPage(WebDriver driver){
		driver.findElement(By.linkText("Account Summary")).click();
	}
	
	public void printOutCard(WebDriver driver){
		driver.findElement(By.id("nim_printGiftCards")).click();
	}
    
	public void buyMoreGifts(WebDriver driver){
		driver.findElement(By.id("nim_giftBuyMore")).click();
	}
	
	public void switchToPrintTips(WebDriver driver){
		driver.findElement(By.linkText("print tips")).click();
	}
}
