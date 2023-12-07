package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppHooks {
    public static WebDriver driver;
    public static Properties prop;

    @Before
    public static void SetupMethod() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/config/config.proprties");
        prop.load(fs);

        if(prop.getProperty("BrowserKey").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com");
            driver.manage().window().maximize();
        } else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","./src/test/resources/Drivers/chromedriver.exe");
            driver=new FirefoxDriver();
            driver.get("https://opensource-demo.orangehrmlive.com");
            driver.manage().window().maximize();
        } else {
            System.out.println("Invalid browser name");
        }
    }

    @After(order = 2)
    public void takeScreenshot(Scenario sc) {
        if (sc.isFailed()) {
            TakesScreenshot TSS=(TakesScreenshot) driver;
            byte[] screenshot = TSS.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png","Failed scenario screenshot");
            System.out.println("===taking screenshot for failed test cases===");
        }
    }

    @After(order = 1)
    public void TearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        System.out.println("===Closing the Browser===");
    }
    }

