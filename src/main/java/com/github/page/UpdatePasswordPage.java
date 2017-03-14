package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by guohua.lin on 2017/3/14.
 */
public class UpdatePasswordPage {
    private final WebDriver driver;
    public UpdatePasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void updatePassword(String currentPassword,String NewPassword){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_acctSaveUpdatedPasswordBtn")));
        driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[1]/div[1]/p")).sendKeys(currentPassword);
        driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[2]/div[1]/p")).sendKeys(NewPassword);
        driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[3]/div[1]/p")).sendKeys(NewPassword);
        driver.findElement(By.id("nim_acctSaveUpdatedPasswordBtn")).click();
    }
    public void checkUpdatePasswordPage(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nim_acctUpdatePassword")));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/h2")).getText(),is("Update Password"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[1]/div[1]/p")).getText(),is("Current Password:"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[2]/div[1]/p")).getText(),is("New Password:"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[3]/div[1]/p")).getText(),is("Retype New Password:"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[1]/div[3]/label")).getText(),is("Show"));
        assertThat(driver.findElement(By.xpath(" //*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[2]/div[3]/label")).getText(),is("Show"));
        assertThat(driver.findElement(By.xpath(" //*[@id=\"nim_acctUpdatePasswordForm\"]/div/div[3]/div[3]/label")).getText(),is("Show"));
        assertThat(driver.findElement(By.id("nim_acctCancelUpdateUpdatePasswordBtn")).getText(),is("Cancel"));
        assertThat(driver.findElement(By.id("nim_acctSaveUpdatedPasswordBtn")).getText(),is("Update"));
    }
    public void clickCancel(){
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_acctCancelUpdateUpdatePasswordBtn")));
        element.click();
    }
}
