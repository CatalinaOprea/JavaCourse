package selenium.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest{

    public void waitForElementToBeDisplayed(WebElement element) {
        try{WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));}
        catch (Exception e){throw new TestException("The element was not present");}}

    public void waitForElementToBeClickable(WebElement element) {
        try{WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));}
        catch (Exception e){throw new TestException("The element was not present");}}

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        try {element.click();}
        catch(StaleElementReferenceException e) {element.click();}
        catch (Exception e) {throw new TestException("Element was not clickable");}}

    public void sendKeys(WebElement element, String value) {
        try{waitForElementToBeDisplayed(element);
            element.clear();
            element.sendKeys(value);}
        catch (Exception e){throw new TestException("The element was not present");}}

}
