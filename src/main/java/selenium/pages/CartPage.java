package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import selenium.utils.SeleniumWrappers;
import static org.testng.Assert.*;

public class CartPage extends SeleniumWrappers{

    //DRIVER
    public WebDriver driver;


    //ELEMNTE
    public By quantityUp = By.xpath("//div[@class='quantity-button plus']");
    public By proceedToCheckout = By.linkText("Proceed to checkout");
    public By termsCheckbox = By.id("terms");
    public By placeOrder = By.id("place_order");
    public By result1 = By.cssSelector("p[class*='woocommerce-thankyou-order-received']");
    public By result2 = By.cssSelector("li[class*='woocommerce-order-overview__order']");
    public By coupon = By.id("coupon_code");
    public By applyCouponButton = By.cssSelector("button[type='submit'][name='apply_coupon']");
    public By firstName = By.id("billing_first_name");
    public By lastName = By.id("billing_last_name");
    public By country = By.id("billing_country");
    public By address = By.id("billing_address_1");
    public By city = By.id("billing_city");
    public By county = By.id("billing_state");
    public By code = By.id("billing_postcode");
    public By email = By.id("billing_email");
    public By phone = By.id("billing_phone");


    //CONSTRUCTOR
    public CartPage (WebDriver driver) {this.driver=driver;}


    //METODE
    public  void updateQuantityUp () throws InterruptedException {
        click(driver.findElement(quantityUp));
        Thread.sleep(2000);}

    public void placeOrderAsRegisteredCustomer() throws InterruptedException {
        waitForElementToBeClickable(driver.findElement(proceedToCheckout));
        click(driver.findElement(proceedToCheckout));
        Thread.sleep(2000);
        click(driver.findElement(termsCheckbox));
        click(driver.findElement(placeOrder));
        Thread.sleep(2000);
        assertEquals (driver.findElement(result1).getText(), "Thank you. Your order has been received.");
        //assertEquals (driver.findElement(result2).getText(), "Order number: 2195");
        assertNotNull(driver.findElement(result2));}

    public void applyCoupon () throws InterruptedException {
        sendKeys(driver.findElement(coupon),"keyfood31122021");
        click(driver.findElement(applyCouponButton));
        Thread.sleep(2000);}

    public void placeOrderWithoutActiveAccount() throws InterruptedException {
        click(driver.findElement(proceedToCheckout));
        waitForElementToBeClickable(driver.findElement(firstName));
        sendKeys(driver.findElement(firstName),"Catalina");
        sendKeys(driver.findElement(lastName),"Oprea");
        Select select1 = new Select(driver.findElement(country));
        select1.selectByValue("RO");
        sendKeys(driver.findElement(address),"test");
        sendKeys(driver.findElement(city),"test");
        Select select2 = new Select(driver.findElement(county));
        select2.selectByValue("AB");
        sendKeys(driver.findElement(code),"123456");
        sendKeys(driver.findElement(phone),"0720111222");
        sendKeys(driver.findElement(email),"catalinamihaela.radu@yahoo.com");
        click(driver.findElement(termsCheckbox));
        click(driver.findElement(placeOrder));
        Thread.sleep(2000);
        waitForElementToBeDisplayed(driver.findElement(result1));
        assertEquals (driver.findElement(result1).getText(), "Thank you. Your order has been received.");
        //assertEquals (driver.findElement(result2).getText(), "Order number: 2195");
        assertNotNull(driver.findElement(result2));}


}
