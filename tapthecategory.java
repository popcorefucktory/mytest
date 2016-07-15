import com.android.ddmlib.testrunner.RemoteAndroidTestRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;

import java.lang.Object;
import java.lang.Throwable;
import java.lang.String;
import java.util.ArrayList;


/**
 * Created by ki on 01.07.2016.
 */


public class tapthecategory {
    AndroidDriver driver;
    //private AppiumDriver<AndroidElement> driver;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        //set up appium
        File appDir = new File("C:\\Users\\ki\\Downloads");
        File app = new File(appDir, "recipes-2.0.15-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Google Nexus 7");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("appPackage", "com.recipes-2.0.15-debug");
        //capabilities.setCapability("appActivity", "com.recipes-2.0.15-debug.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(280, TimeUnit.SECONDS);
    }

    @Test
    public void tapthecategory() throws InterruptedException {

        driver.findElement(By.xpath("//android.widget.TextView[@text='Коктейли']")).click();
        //int xpathCount = driver.findElements(By.xpath("//android.widget.ImageView[@class='android.widget.ImageView']")).size();
        //WebElement xpathCount = (WebElement) driver.findElements(By.id("com.secretlab.eatathome:id/title"));
        String elementsId = "com.secretlab.eatathome:id/title";
        Set<WebElement> uniqueElements = new HashSet<>();
        List<WebElement> elements = driver.findElements(By.id(elementsId));
        uniqueElements.addAll(elements);
        //int xpathCount = driver.findElements(By.xpath("//android.widget.ImageView[@class='android.widget.ImageView'][@index='1']")).size();
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        TestUtils.scroll(driver);
        System.out.println(elements.size());
        elements = driver.findElements(By.id(elementsId));
        uniqueElements.addAll(elements);
        System.out.println(elements.size());

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        System.out.println(uniqueElements.size());
        for (WebElement element : uniqueElements) {
            System.out.println(element.getText());
        }

    }


    @AfterMethod
    public void tearDown() {
        driver.manage();


    }
}

