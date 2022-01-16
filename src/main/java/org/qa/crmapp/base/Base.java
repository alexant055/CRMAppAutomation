package org.qa.crmapp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.crmapp.utils.TestUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties properties;

    public Base() {
        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/org/qa/crmapp/config/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeDriver() {
        String browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();
        }

        // Reset driver
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        // Launch application
        driver.get(properties.getProperty("url"));
    }
}
