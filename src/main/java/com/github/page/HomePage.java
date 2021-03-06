package com.github.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void switchToCatalogPage() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-15\"]/a")));
        element.click();
    }

    public void switchToFeaturesPage() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-14\"]/a")));
        element.click();
    }

    public void switchToPricingPage() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-38603\"]/a")));
        element.click();
    }

    public void switchToSignInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[4]/a")));
        element.click();
    }
    public void showDropDownMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[5]/a")));
        element.click();
    }
    public void selectAccountSummay(){
        driver.findElement(By.xpath("//*[@id=\"account-menu\"]/li[1]/a")).click();
    }

    public void switchToAccountSummaryPage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"account-menu\"]/li[1]/a")).click();
    }

    public void signOut(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"account-menu\"]/li[2]/a")).click();
    }

    public void switchToChooseGiftPage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"menu-item-16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-53407\"]/a")).click();
    }

    public void switchToHomePage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"menu-item-16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-43077\"]/a")).click();
    }

    public void switchToCatalogPageByFooter(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"menu-item-16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-20\"]/a")).click();
    }

    public void switchToFeaturesPageByFooter(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"menu-item-16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-19\"]/a")).click();
    }

    public void switchToReferAFriendPage(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"menu-item-16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-1709\"]/a")).click();
    }
    public void switchToPricingPageByFooter(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-16\"]/a")));
        element.click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-43078\"]/a")).click();
    }
    public void checkHomePageIsLoaded(){
        WebDriverWait HomePage = new WebDriverWait(driver, 200);
        HomePage.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-header\"]/div/h1/a")));
        Assert.assertTrue(driver.getPageSource().contains("All the best magazines."));
    }

    public void clickTextureLogo(){
        WebDriverWait HomePage = new WebDriverWait(driver, 200);
        WebElement element = HomePage.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-header\"]/div/h1/a")));
        element.click();
    }
}