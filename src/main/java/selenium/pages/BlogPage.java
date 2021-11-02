package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.SeleniumWrappers;
import static org.testng.Assert.assertEquals;

public class BlogPage extends SeleniumWrappers {

    //DRIVER
    public WebDriver driver;


    //ELEMNTE
    public By blog1 = By.linkText("But I must explain to you how all this mistaken idea");
    public By blog2 = By.linkText("The Problem With Typefaces on the Web");
    public By blog3 = By.linkText("English Breakfast Tea With Tasty Donut Desserts");
    public By blog4 = By.linkText("On the other hand we provide denounce with righteous");
    public By comment = By.id("comment");
    public By name = By.id("author");
    public By email = By.id("email");
    public By website = By.id("url");
    public By postComment = By.id("submit");
    public By result = By.cssSelector("div[class='klb-post'] em");


    //CONSTRUCTOR
    public BlogPage (WebDriver driver) {this.driver=driver;}


    //METODE
    public boolean returnBlog (By locator, String value) {
        try{WebElement blog = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.textToBePresentInElement(blog, value));
            return true;}
        catch (NoSuchElementException e) {return false;}}

    public void addCommentOnBlog (By locator) throws InterruptedException {
        click(driver.findElement(locator));
        sendKeys(driver.findElement(comment),"testHomework");
        sendKeys(driver.findElement(name),"Catalina");
        sendKeys(driver.findElement(email),"catalinamihaela.radu@yahoo.com");
        sendKeys(driver.findElement(website),"test");
        Thread.sleep(2000);
        click(driver.findElement(postComment));
        waitForElementToBeDisplayed(driver.findElement(result));
        assertEquals (driver.findElement(result).getText(), "Your comment is awaiting moderation.");
        driver.navigate().to("https://keyfood.ro/blog/");
        waitForElementToBeDisplayed(driver.findElement(locator));}


}
