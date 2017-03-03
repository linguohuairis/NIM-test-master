package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ChooseDeliveryMethodPage {
	public void sendAnEmail(WebDriver driver, String to, String from, String personalMessage, String month, String date){
		driver.findElement(By.id("nim_selectEmailBtn")).click();
		driver.findElement(By.id("nim_giftBuyEmailToInput-selectized")).sendKeys(to);
		driver.findElement(By.id("nim_giftBuyEmailFromInput")).sendKeys(from);
		driver.findElement(By.id("nim_giftBuyEmailMessageInput")).sendKeys(personalMessage);
		Select selectMonth = new Select(driver.findElement(By.tagName("nim_giftPurchDeliverMonthInput")));
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(driver.findElement(By.tagName("nim_giftPurchDeliverDayInput")));
		selectYear.selectByVisibleText(date);
		driver.findElement(By.id("nim_giftBuySubmitBtn")).click();
	}

}
