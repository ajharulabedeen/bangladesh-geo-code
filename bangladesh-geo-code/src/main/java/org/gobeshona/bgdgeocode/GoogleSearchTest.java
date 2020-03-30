package org.gobeshona.bgdgeocode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GoogleSearchTest {

    public static void main(String...args) {
        Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver/geckodriver.exe");
        System.out.println(path.toString());
//        String
        System.setProperty("webdriver.gecko.driver",path.toString());
        WebDriver driver  = new FirefoxDriver();
//        driver.navigate().to("http://google.com");
        driver.navigate().to("https://www.bangladesh.gov.bd/site/view/union-list/");
        String appTitle = driver.getTitle();
        System.out.println("Application title is :: "+appTitle);
        driver.quit();
    }

}