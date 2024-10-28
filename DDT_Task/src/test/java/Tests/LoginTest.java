package Tests;

import DataDrivenTest.DataProvider_Class;
import Pages.LoginPage;
import Properties.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.screenShot;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static Properties.ReadProperties.Read_Properties;
import static Properties.ReadProperties.properties;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;
    screenShot screenShot;



    @BeforeMethod
    public void setUp() throws Exception {

        // Set ChromeOptions and initialize WebDriver
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");
       // driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Use URL from config file
        Properties prop =
                Read_Properties("D:\\Mahmoud\\Data_Driven\\DDT_Task\\src\\main\\resources" +
                "\\ConfigFiles.properties");
        System.out.println( "this is url: "+ prop.getProperty("url"));
        driver.get(prop.getProperty("url"));


        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        screenShot = new screenShot(driver);
    }


    @Test(dataProvider = "LoginData",dataProviderClass = DataProvider_Class.class)
    public void testLogin(String username, String password) {

       loginPage = new LoginPage(driver,wait);
       loginPage
               .enterUserName(username)
                     .enterPassword(password)
                              .clickLoginButton();



        //Verify if Url contains Dashboard
        Assert
                .assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {

            // Get screenshot directory from config file
            Properties prop =  Read_Properties("D:\\Mahmoud\\Data_Driven\\DDT_Task\\src\\main\\resources" +
                    "\\ConfigFiles.properties");
            screenShot.
                    takeScreenShot(prop.getProperty("filePath"));
        }
        driver.quit();
    }


}
