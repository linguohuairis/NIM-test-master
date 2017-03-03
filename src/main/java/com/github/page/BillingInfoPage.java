package com.github.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingInfoPage {
	private final WebDriver driver;

	public BillingInfoPage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterValidCreditCard(String cardNumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_billingInfoPmtMethodTab1")));
		element.click();
		driver.findElement(By.id("nim_billingCCAccountNameInput")).sendKeys("name");
		driver.findElement(By.id("nim_billingCCAccountNum")).sendKeys(cardNumber);

		WebElement expMonthInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_billingCCExpMonthInput")));
		expMonthInput.click();
		Select select = new Select(expMonthInput);
		select.selectByValue("12");

		WebElement expYearInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("nim_billingCCExpYearInput")));
		expYearInput.click();
		Select yearSelect = new Select(expYearInput);
		yearSelect.selectByValue("2017");

		driver.findElement(By.id("nim_billingCCCVNInput")).sendKeys("777");
		driver.findElement(By.id("nim_billingCCPostalCodeInput")).sendKeys("01001");
		driver.findElement(By.id("nim_billingCCSubmitBtn")).click();
	}

	public void enterValidPayPal(WebDriver driver, String email, String password){
		driver.findElement(By.id("nim_billingInfoPmtMethodTab2")).click();
		driver.findElement(By.id("nim_billingPayPalSubmitBtn")).click();
		WebDriverWait waitforPayPalLoad = new WebDriverWait(driver, 200);
		WebElement elementLogin = waitforPayPalLoad.until(ExpectedConditions.elementToBeClickable(By.id("btnLogin")));
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(email);
		elementLogin.click();
		WebDriverWait waitforPayPalConfirmation = new WebDriverWait(driver, 200);
		WebElement elementAgree = waitforPayPalConfirmation.until(ExpectedConditions.elementToBeClickable(By.id("confirmButtonTop")));
		elementAgree.click();
	}
	public void useDifferentCard(WebDriver driver, String name, String cardNumber, String securityCode, String zipCode){
		driver.findElement(By.id("nim_billingInfoUseNewCard")).click();
		driver.findElement(By.id("nim_billingCCAccountNameInput")).sendKeys(name);
		driver.findElement(By.id("nim_billingCCAccountNum")).sendKeys(cardNumber);
		Select selectMonth = new Select(driver.findElement(By.tagName("cardExpMon")));
		selectMonth.selectByVisibleText("Dec [12]");	
		Select selectYear = new Select(driver.findElement(By.tagName("cardExpYr")));
		selectYear.selectByVisibleText("2017");
		driver.findElement(By.id("nim_billingCCCVNInput")).sendKeys(securityCode);
		driver.findElement(By.id("nim_billingCCPostalCodeInput")).sendKeys(zipCode);
		driver.findElement(By.id("nim_billingCCSubmitBtn")).click();
	}
	public String getBillingHeader(WebDriver driver){
		return driver.findElement(By.id("nim_billingHeader")).getText();
	}
	
	public String getBillingSubHeader1(WebDriver driver){
		return driver.findElement(By.id("nim_billingSubHeader1")).getText();
	}
	
	public String getBillingSubHeader2(WebDriver driver){
		return driver.findElement(By.id("nim_billingSubHeader2")).getText();
	}
	
	public String getBillingSubHeader3(WebDriver driver){
		return driver.findElement(By.id("nim_billingSubHeader3")).getText();
	}
	
	public String getBillingSubHeader4(WebDriver driver){
		return driver.findElement(By.id("nim_billingSubHeader4")).getText();
	}
	
	public String getCreditCardConfirmOrderReviewMessage(WebDriver driver){
		return driver.findElement(By.id("nim_confirmOrderReviewMessage1Txt")).getText();
	}
	
	public String getPayPalConfirmOrderReviewMessage(WebDriver driver){
		return driver.findElement(By.id("nim_confirmOrderReviewPayPalMessageTxt")).getText();
	}
	
	public String getConfirmOrderKeepUpdatedInputMessage(WebDriver driver){
		return driver.findElement(By.id("nim_confirmOrderKeepUpdatedInput")).getText();
	}
	
	public void checkSecurityLogo(WebDriver driver){
		driver.findElement(By.linkText("DigiCert.com")).click();
	}

	
}
