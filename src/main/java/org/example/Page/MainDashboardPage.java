package org.example.Page;

import org.example.Base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainDashboardPage extends TestBase {

    @FindBy(xpath = "//section[@class='flex-[1] lg:flex-[3]']//nav//div//a[@href='/home']")
    WebElement homeLinkUrl;

    //    @FindBy(xpath = "//button[@type='button' and @aria-controls='radix-:r2l:']//div[@title='More options!']")
    @FindBy(xpath = "(//button[@type='button' and @aria-haspopup='dialog']//div[@title='More options!'])[1]")
    WebElement moreBtn;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookie;


    public MainDashboardPage(WebDriver driver) throws IOException {

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickonHomeUrl() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(homeLinkUrl));
        homeLinkUrl.click();
    }

    public void clickOnMoreButton() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(moreBtn));
        moreBtn.click();
        Thread.sleep(2000);
    }

    //handle alert // close dialogbox
    public void clickOnOkAlert() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void scrollDownPage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
    }

    public void acceptCookie() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(acceptCookie));
        Thread.sleep(2000);
        acceptCookie.click();

        Thread.sleep(5000);
    }

}