package selenium.utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot {

    public WebDriver driver;

    public TakeScreenshot(WebDriver driver) {
        this.driver = driver;}

    public void scrennshot(String fileName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File picture = screenshot.getScreenshotAs(OutputType.FILE);
        try{Files.copy(picture, new File("screenshots/"+ fileName + ".png"));}
        catch (IOException e) {
            selenium.utils.Log.error("Could not take the picture");
            selenium.utils.Log.error(e.getMessage());}}


}