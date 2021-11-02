package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.pages.CartPage;
import selenium.pages.LoginPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;
import static org.testng.Assert.assertEquals;

@Listeners(TestNgListener.class)
public class Test1 extends BaseTest {

    @Test
    public void placeOrderAsRegisteredCustomer () throws InterruptedException {

        LoginPage loginPage = homePage.navigateToLogin();
        loginPage.loginInApp("customer","customer@123");
        Thread.sleep(2000);

        homePage.searchAndAddProductToCart("Pretzels");
        WebElement result1 = driver.findElement(By.xpath("//div[contains(@class, 'woocommerce-message')]"));
        assertEquals (result1.getText(), "View cart\n" + "“Rold Gold Tiny Twists Pretzels” has been added to your cart.");

        CartPage cartPage = homePage.navigateToCart();
        cartPage.updateQuantityUp();
        WebElement result2 = driver.findElement(By.xpath("//td[@data-title='Total']/strong/span[@class='woocommerce-Price-amount amount']"));
        assertEquals (result2.getText(), "$5.98");
        cartPage.placeOrderAsRegisteredCustomer();

    }

}
