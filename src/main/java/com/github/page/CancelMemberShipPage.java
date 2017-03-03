package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancelMemberShipPage {
    public void saveNow(WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"LAHero-desktop-0\"]/section/div/div/a")).click();
    }

    public void takeSpecialOffer(WebDriver driver){
        driver.findElement(By.xpath("/*[@id=\"top\"]/div/section/div/a[1]")).click();
    }

    public void switchToCancelPromoPage(WebDriver driver){
        driver.findElement(By.id("cancel-reveal")).click();
        driver.findElement(By.xpath("/*[@id=\"cancel-survey\"]/div/ul/li[1]/label")).click();
        driver.findElement(By.id("cancel-submit")).click();
    }

    public void keepPlan(WebDriver driver){
        driver.findElement(By.xpath(" //*[@id=\"cancel-survey\"]/div/div/a")).click();
    }
}
