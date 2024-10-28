package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {


    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    //Constructor
    public LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }


    //locators

    //UserName
    By userNameField = By.name("username");

    //Password
    By passwordField = By.name("password");

    //Login Btn
    By loginButton = By.xpath("//button" +
            "[contains(@class,'orangehrm-login-button')]");



    //Actions

    //Functions that enters username
    public LoginPage enterUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField))
        .sendKeys(userName);
        return this;
    }

    //Functions that enters username
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .sendKeys(password);
        return this;
    }

    //Functions that click on LoginBtn
    public void clickLoginButton() {
        js.executeScript("arguments[0].click();",driver.findElement(loginButton));
    }
}
