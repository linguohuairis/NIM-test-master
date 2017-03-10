package com.github;

import com.github.page.*;
import org.junit.*;


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
    public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriverwindows.exe");
        // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.qa.texture.com");
    }
    @Test
    public void SNF1(){
        /* Check company logo
         */
        HomePage homePage = new HomePage(driver);
        homePage.clickTextureLogo();
        Assert.assertTrue(driver.getPageSource().contains("All the best magazines."));
    }
    @Test
    public void SNF2(){
          /* Check catalog page
         */
        HomePage homePage = new HomePage(driver);
        homePage.switchToCatalogPage();
        WebDriverWait waitCatalog = new WebDriverWait(driver, 200);
        waitCatalog.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NIMNewsstand-desktop-0\"]/section/div/aside/div[1]/ul/li[1]/a")));
        Assert.assertTrue(driver.getPageSource().contains("By catalog"));
    }
    @Test
    public void SNF3(){
        /* Check pricing page
         */
        HomePage homePage = new HomePage(driver);
        homePage.switchToPricingPage();
        WebDriverWait waitPricing = new WebDriverWait(driver, 200);
        waitPricing.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"NIMPricingGrid_Light-desktop-0\"]/section/div/table/tfoot/tr/td[2]/a")));
        Assert.assertTrue(driver.getPageSource().contains("Choose your plan for unlimited access to the world's best magazines"));
    }

    @Test
    public void SNF4(){
          /* Check features page
         */
        HomePage homePage = new HomePage(driver);
        homePage.switchToFeaturesPage();
        WebDriverWait waitFeatures = new WebDriverWait(driver, 200);
        waitFeatures.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"NIMFeatures-desktop-0\"]/section/div/h1")));
        Assert.assertTrue(driver.getPageSource().contains("So many reasons to love it."));
    }
    @Test
    public void SNF5(){
         /* Check Sign in  page
         */
        HomePage homePage = new HomePage(driver);
        homePage.switchToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.checkSignInPageIsLoaded();
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
        signInPage.clickTextureLogo();
        homePage.checkHomePageIsLoaded();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul[1]/li[4]/a")).getText().contains("Sign In"));
    }

    public void SNF10(){
        HomePage homePage = new HomePage(driver);
        homePage.switchToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.LoginValidUser("jk4@163.com","123456");
        StartMemberShipSplashPage memberShipSplashPage = new StartMemberShipSplashPage(driver);
        memberShipSplashPage.clickNoThanksButton();
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        accountSummaryPage.clickTextureLogo();
        homePage.showDropDownMenu();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-menu\"]/li[1]/a")).getText().contains("Account Summary"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-menu\"]/li[2]/a")).getText().contains("Sign Out"));
    }
    @Test
    public void SNF11(){
        HomePage homePage = new HomePage(driver);
        homePage.switchToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.LoginValidUser("jk6@163.com","123456");
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        accountSummaryPage.checkAccountSummaryPageIsLoaded();
//        Assert.assertTrue(driver.getPageSource().contains("Billing Info"));
//        Assert.assertTrue(driver.getPageSource().contains("Credit Card Details"));
//        Assert.assertTrue(driver.getPageSource().contains("MasterCard ending in 0004"));
//        Assert.assertTrue(driver.getPageSource().contains("Expiration date: 10/18"));
//        Assert.assertTrue(driver.getPageSource().contains("master"));
//        Assert.assertTrue(driver.getPageSource().contains("ZIP code: 01001"));
//        Assert.assertTrue(driver.findElement(By.id("nim_acctSummaryDoneButton")).getText().contains("Done"));
//        Assert.assertTrue(driver.getPageSource().contains("Order History"));
        accountSummaryPage.signOut();
        homePage.switchToSignInPage();
        signInPage.LoginValidUser("jk8@163.com","123456");
        StartMemberShipSplashPage startMemberShipSplashPage = new StartMemberShipSplashPage(driver);
        startMemberShipSplashPage.clickNoThanksButton();
        accountSummaryPage.checkAccountSummaryPageIsLoaded();
        Assert.assertTrue(driver.getPageSource().contains("Get started"));
        accountSummaryPage.getStarted();
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.checkPricingPageIsLoaded();
        pricingPage.clickTextureLogo();
        homePage.checkHomePageIsLoaded();
    }


    public void SNF12(){
        HomePage homePage = new HomePage(driver);
        homePage.switchToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.LoginValidUser("jk9@163.com","123456");
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        accountSummaryPage.checkAccountSummaryPageIsLoaded();


    }
//    @After
//    public void tearDown(){
//        System.out.print("4444444");
//        driver.quit();
//    }

}
