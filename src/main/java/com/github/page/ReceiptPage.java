package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReceiptPage {
	public void clickTextureLogo(WebDriver driver){
		driver.findElement(By.id("nim_layoutLogoImage")).click();		
	}

	public void switchToPrintablePage(WebDriver driver){
		driver.findElement(By.id("nim_purchaseReceiptPrint")).click();
	}
	
	public void switchToAppStore(WebDriver driver){
		driver.findElement(By.id("nim_purchaseReceiptiOSLink")).click();		
	}
	
	public void switchToGooglePlay(WebDriver driver){
		driver.findElement(By.id("nim_purchaseReceiptAndroidLink")).click();		
	}
	
	public void switchToAmazon(WebDriver driver){
		driver.findElement(By.id("nim_purchaseReceiptAmzLink")).click();		
	}

	public void switchToFriendBuy(WebDriver driver){
		driver.findElement(By.id("nim_friendbuyDiv")).click();
	}
	
}
