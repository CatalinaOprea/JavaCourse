package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.pages.CartPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;
import static org.testng.Assert.assertEquals;

@Listeners(TestNgListener.class)
public class Test2 extends BaseTest {

    @Test
    public void placeOrderWithoutActiveAccount () throws InterruptedException {

        homePage.selectCategory(homePage.frozenFoods);
        homePage.selectAndAddProductToCart(homePage.product1);
        homePage.selectCategory(homePage.frozenFoods);
        homePage.selectAndAddProductToCart(homePage.product2);
        homePage.selectCategory(homePage.beverages);
        homePage.selectAndAddProductToCart(homePage.cocaCola);

        CartPage cartPage = homePage.navigateToCart();
        WebElement price1 = driver.findElement(By.xpath("//td[@data-title='Total']/strong/span[@class='woocommerce-Price-amount amount']"));
        assertEquals (price1.getText(), "$10.42");
        cartPage.applyCoupon();
        WebElement price2 = driver.findElement(By.xpath("//td[@data-title='Total']/strong/span[@class='woocommerce-Price-amount amount']"));
        assertEquals (price2.getText(), "$5.21");
        cartPage.placeOrderWithoutActiveAccount();

    }

}
