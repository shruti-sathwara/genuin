import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.Base.TestBase;
import org.example.CommonUtilities.TestUtil;
import org.example.Page.MainDashboardPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.Base.TestBase.Initialization;

public class MainDashboardTest extends TestBase {

    MainDashboardPage mainDashboardPage;
    TestUtil testutil = new TestUtil();
    private WebDriver driver;

    public MainDashboardTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver = Initialization();
        mainDashboardPage = new MainDashboardPage(driver);
//        softassert = new SoftAssert();
        testutil = new TestUtil();

    }

    @Test(priority = 1)
    public void openHomeUrl() throws Exception {

        driver.get(prop.getProperty("url"));
        mainDashboardPage.clickonHomeUrl();
    }

    @Test(priority = 2)
    public void acceptCookies() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        mainDashboardPage.clickonHomeUrl();
        mainDashboardPage.acceptCookie();
    }

    @Test(priority = 3)
    public void clickOnMoreButton() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        mainDashboardPage.clickonHomeUrl();
        mainDashboardPage.acceptCookie();
        mainDashboardPage.clickOnMoreButton();
    }

    @Test(priority = 4)
    public void acceptAlertDialog() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        mainDashboardPage.clickonHomeUrl();
        mainDashboardPage.acceptCookie();
//        mainDashboardPage.scrollDownPage();
        mainDashboardPage.clickOnMoreButton();
        mainDashboardPage.clickOnOkAlert();
    }
//

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
