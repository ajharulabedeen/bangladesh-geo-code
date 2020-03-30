/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.geocode;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author G7
 */
public class Selenium {

//    private static WebDriver driver;

    public Selenium() {
    }

    @BeforeClass
    public static void setUpClass() {
//        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownClass() {
//        driver.quit();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        System.out.println("Selenium Working!");
    }

    //    @Test
    public void verifySearchButton() {
        Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver/geckodriver.exe");
        System.out.println(path.toString());
//        String
        System.setProperty("webdriver.gecko.driver", path.toString());
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.get("http://www.google.com");
        driver.get("https://www.bangladesh.gov.bd/site/view/union-list/");

        String search_text = "Google Search";
//        WebElement search_button = driver.findElement(By.name("btnK"));
        WebElement search_button = driver.findElement(By.className("submit-lang"));
        search_button.click();
//        WebElement div_list = driver.findElement(By.className("div-list"));
        WebElement div_list = driver.findElement(By.id("div-list"));
        div_list.click();
        WebElement div_list_ = driver.findElement(By.tagName("option"));

        String text = search_button.getAttribute("value");
        Assert.assertEquals(text, search_text, "বাংলা");
    }

    @Test
    public void testChoromo() {
// declaration and instantiation of objects/variables
//        Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver/geckodriver.exe");
//        System.out.println(path.toString());
//        System.setProperty("webdriver.gecko.driver", path.toString());
//        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        Path path = FileSystems.getDefault().getPath("src/main/resources/chromedriver/chromedriver.exe");
        System.out.println(path.toString());
        System.setProperty("webdriver.chrome.driver", path.toString());
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();
    }
}
