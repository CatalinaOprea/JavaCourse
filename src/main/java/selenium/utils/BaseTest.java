package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenium.pages.HomePage;

public class BaseTest {

    public static WebDriver driver;
    public HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://keyfood.ro/");
        homePage = new HomePage(driver);}

    @AfterClass(alwaysRun = true)
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();}


}
