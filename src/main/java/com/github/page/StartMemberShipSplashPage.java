package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by guohua.lin on 2017/3/6.
 */
public class StartMemberShipSplashPage {
    private final WebDriver driver;

    public StartMemberShipSplashPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickNoThanksButton(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_splashNoThanksNoPurch")));
        element.click();
    }
    public void clickGetStartedButton(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_splashNewPurch")));
        element.click();
    }
}
