package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenShot {

     WebDriver driver;

    public  screenShot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot(String fileName) {

        //Take screenShot
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //where you want to save screenShot
        File destination = new File(fileName);

        try {
            FileUtils.copyFile(screenShot, destination);
            System.out.println("Screenshot taken at " + destination.getAbsolutePath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
