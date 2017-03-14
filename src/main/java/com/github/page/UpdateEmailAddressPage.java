package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by guohua.lin on 2017/3/13.
 */
public class UpdateEmailAddressPage {
    private final WebDriver driver;
    public UpdateEmailAddressPage(WebDriver driver){
        this.driver = driver;
    }
    public void updateEmailAddress(String newEmailAddress,String retypeNewEmailAddress, String password){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_acctSaveUpdatedEmailAddressBtn")));
        driver.findElement(By.id("nim_acctNewEmail")).sendKeys(newEmailAddress);
        driver.findElement(By.id("nim_acctRetypeNewEmail")).sendKeys(retypeNewEmailAddress);
        driver.findElement(By.id("nim_acctUpdateEmailPassword")).sendKeys(password);
        driver.findElement(By.id("nim_acctSaveUpdatedEmailAddressBtn")).click();
    }
    public void checkUpdateEmailAddressPage(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nim_acctSaveUpdatedEmailAddressBtn")));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/h2")).getText(),is("Update Email Address"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/div/div[1]/div[1]/p")).getText(),is("Current Email Address"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/div/div[2]/div[1]/p")).getText(),is("New Email Address:"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/div/div[3]/div[1]/p")).getText(),is("Retype New Email Address:"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/div/div[4]/div[1]/p")).getText(),is("Password:\n" + "Enter password to update your email address"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdateEmailModal\"]/form/div/div[4]/div[3]/label")).getText(),is("Show"));
        assertThat(driver.findElement(By.id("nim_acctCancelUpdateEmailAddressBtn")).getText(),is("Cancel"));
        assertThat(driver.findElement(By.id("nim_acctSaveUpdatedEmailAddressBtn")).getText(),is("Update"));
    }
    public void clickCancel(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_acctCancelUpdateEmailAddressBtn")));
        element.click();
    }
}