package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {

    //DRIVER
    public WebDriver driver;


    //ELEMENTE
    public By userNameField = By.id("username");
    public By passwordField = By.id("password");
    public By LogInButton = By.name("login");


    //CONSTRUCTOR
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }


    //METODE
    public void setUserNameField (String username) {
        sendKeys(driver.findElement(userNameField),username);}

    public void setPasswordField (String password) {
        sendKeys(driver.findElement(passwordField), password);}

    public void clickLogInButton () {
        click(driver.findElement(LogInButton));};

    public void loginInApp(String username, String password) {
        setUserNameField(username);
        setPasswordField(password);
        clickLogInButton();}


}
