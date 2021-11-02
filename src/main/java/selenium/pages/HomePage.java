package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import selenium.utils.SeleniumWrappers;


public class HomePage extends SeleniumWrappers{

    //DRIVER
    public WebDriver driver;


    //ELEMENTE
    public By loginButton = By.linkText("My account");
    public By searchButton = By.id("dgwt-wcas-search-input-1");
    public By addToCart = By.name("add-to-cart");
    public By cartLink = By.linkText("CART");
    public By blogLink = By.linkText("BLOG");
    public By logo = By.cssSelector("img[class*='desktop-logo']");
    public By category = By.xpath("//a[@data-target='#all-categories']");
    public By frozenFoods = By.linkText("Frozen Foods");
    public By beverages = By.linkText("Beverages");
    //public By bisc = By.linkText("Biscuits & Snacks");
    public By product1 = By.xpath("//a[@title='Gorton’s Beer Battered Fish Fillets']");
    public By product2 = By.xpath("//a[@title='Green Giant Veggie Spirals']");
    public By cocaCola = By.xpath("//a[@title='Coca-Cola – 2 L Bottle']");


    //CONSTRUCTOR
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }


    //METODE
    public LoginPage navigateToLogin () {
        click(driver.findElement(loginButton));
        return new LoginPage(driver); }

    public void searchAndAddProductToCart (String product) throws InterruptedException {
        sendKeys(driver.findElement(searchButton),product);
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
        waitForElementToBeClickable(driver.findElement(addToCart));
        driver.findElement(addToCart).click();}

    public CartPage navigateToCart () {
        click(driver.findElement(cartLink));
        return new CartPage(driver);}

    public BlogPage navigateToBlog(){
        click(driver.findElement(blogLink));
        return new BlogPage(driver);}

    public void selectCategory (By locator) throws InterruptedException {
        waitForElementToBeClickable(driver.findElement(category));
        click(driver.findElement(category));
        Thread.sleep(2000);
        waitForElementToBeClickable(driver.findElement(locator));
        click(driver.findElement(locator));}

    public void selectAndAddProductToCart (By locator) throws InterruptedException {
        waitForElementToBeClickable(driver.findElement(locator));
        click(driver.findElement(locator));
        waitForElementToBeClickable(driver.findElement(addToCart));
        click(driver.findElement(addToCart));}


}






