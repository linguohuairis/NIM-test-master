package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetSpecialOfferPage {
  public void takeSpecialOfferPage(WebDriver driver){
	  driver.findElement(By.xpath("//*[@id=\"LAHero-desktop-0\"]/section/div/div/a")).click();
  }
  
  public void cancelMemberShip(WebDriver driver){
	  driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[4]/a")).click();
  }
}
