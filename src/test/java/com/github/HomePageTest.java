package com.github;

import com.github.page.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by guohua.lin on 2017/3/3.
 */
public class HomePageTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriverwindows.exe");
        // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.qa.texture.com");
    }
    @Test
    public void SNF1(){
        /* Check company logo
         */
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-header\"]/div/h1/a")));
        element.click();
        Assert.assertTrue(driver.getPageSource().contains("All the best magazines."));
    }
    @Test
    public void SNF2(){
          /* Check catalog page
         */
        driver.findElement(By.xpath("//*[@id=\"menu-item-15\"]/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NIMNewsstand-desktop-0\"]/section/div/aside/div[1]/ul/li[1]/a")));
        Assert.assertTrue(driver.getPageSource().contains("By catalog"));
    }
    @Test
    public void SNF3(){
        /* Check pricing page
         */
        driver.findElement(By.xpath("//*[@id=\"site-header\"]/div/h1/a")).click();
        WebDriverWait waitHomePage = new WebDriverWait(driver, 200);
        waitHomePage.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-38603\"]/a"))).click();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"NIMPricingGrid_Light-desktop-0\"]/section/div/table/tfoot/tr/td[2]/a")));
        Assert.assertTrue(driver.getPageSource().contains("Choose your plan for unlimited access to the world's best magazines"));
    }

    @Test
    public void SNF4(){
          /* Check features page
         */
        driver.findElement(By.xpath("//*[@id=\"site-header\"]/div/h1/a")).click();
        WebDriverWait waitHomePage = new WebDriverWait(driver, 200);
        waitHomePage.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-item-14\"]/a"))).click();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"NIMFeatures-desktop-0\"]/section/div/h1")));
        Assert.assertTrue(driver.getPageSource().contains("So many reasons to love it."));
    }
    @Test
    public void SNF5(){
        driver.findElement(By.xpath("//*[@id=\"site-header\"]/div/h1/a")).click();
        WebDriverWait waitHomePage = new WebDriverWait(driver, 200);
        waitHomePage.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[4]/a"))).click();
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nim_authSigninSubmitBtn")));
        Assert.assertTrue(driver.getPageSource().contains("Sign In"));
        Assert.assertTrue(driver.getPageSource().contains("Already have a Texture account? Sign In."));
        Assert.assertTrue(driver.getPageSource().contains("Email Address"));
        Assert.assertTrue(driver.getPageSource().contains("Password"));
        Assert.assertTrue(driver.getPageSource().contains("Forgot Password?"));
        Assert.assertTrue(driver.getPageSource().contains("New Customer?"));
        Assert.assertTrue(driver.getPageSource().contains("Create a Texture account"));
        Assert.assertTrue(driver.getPageSource().contains("Create your account with Facebook"));
        Assert.assertTrue(driver.getPageSource().contains("Texture will not post to Facebook without your consent."));
        Assert.assertTrue(driver.findElement(By.id("nim_authSigninSubmitBtn")).getText().contains("Sign In"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"nim_authSignInFaceBookLoginBtn\"]/span")).getText().contains("Sign In With Facebook"));
    }
}