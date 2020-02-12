package utils.com.frame;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static String propertyFilePath;
    static BufferedReader reader;
    static Properties readFile;
   @BeforeSuite
   public static void property() throws IOException {
       propertyFilePath = "src/main/resources/app.properties";
       reader = new BufferedReader(new FileReader(propertyFilePath));
       readFile = new Properties();
       readFile.load(reader);
   }

   public static String getData(String element){
       String data = readFile.getProperty(element);
       return data;
   }
}
