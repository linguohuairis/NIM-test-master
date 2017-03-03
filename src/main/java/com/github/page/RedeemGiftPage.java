package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedeemGiftPage {
	public void redeemGift(WebDriver driver, String giftCode){
		driver.findElement(By.id("gift-code")).sendKeys(giftCode);
		driver.findElement(By.xpath("//*[@id=\"gift-redeem\"]/input[2]")).click();
	}
}
