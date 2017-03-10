package com.github;

import com.github.common.Config;
import com.github.common.DBConnection;
import com.github.page.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BasicPlanTest {
    public WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        System.out.print("1111111111111");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriverwindows.exe");
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.qa.texture.com");
        System.out.print("2222222222");
    }

  @Test
    public void shouldRegisterAnAccountAndBuyABasicPlanSuccessfully() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.switchToSignInPage();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.switchToCreateAccountPage();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        String email = "basic_" + RandomStringUtils.randomAlphabetic(8) + "@163.com";
        System.out.println(email);
        String password = "123456";
        createAccountPage.createValidAccount(email, password);
        homePage.switchToPricingPage();
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.startBasicTrial();
        BillingInfoPage billingInfoPage = new BillingInfoPage(driver);
        billingInfoPage.enterValidCreditCard("5500000000000004");
        PlanReceiptPage planReceiptPage = new PlanReceiptPage(driver);
        String unlimitedReceiptHeader = planReceiptPage.getUnlimitedReceiptHeader();
        Config config = new Config();
        DBConnection db = new DBConnection();
        db.insert(email,"123456",config.getDate(),"Basic_free");
        assertThat(unlimitedReceiptHeader, is("Your membership's started."));
        assertThat(planReceiptPage.getUnlimitedSubReceiptHeader(),
                is("Ready to read? Just download the app and sign in with your Texture account: " + email));

    }
//    @After
//    public void tearDown(){
//        System.out.print("4444444");
//        driver.quit();
//    }
}
