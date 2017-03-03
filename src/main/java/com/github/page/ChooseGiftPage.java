package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseGiftPage {
	public void selectGiftFor30(WebDriver driver){
		driver.findElement(By.xpath(" //*[@id=\"gift-select\"]/div[1]")).click();
		driver.findElement(By.id("gift-select-submit")).click();
	}

	public void selectGiftFor60(WebDriver driver){
		driver.findElement(By.xpath(" //*[@id=\"gift-select\"]/div[2]")).click();
		driver.findElement(By.id("gift-select-submit")).click();
	}

	public void selectGiftFor75(WebDriver driver){
		driver.findElement(By.xpath("//*[@id=\"gift-select\"]/div[3]")).click();
		driver.findElement(By.id("gift-select-submit")).click();
	}

	public void switchToRedeemGiftPage(WebDriver driver){
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/section/div[1]/div/p[2]/a")).click();
	}
}
