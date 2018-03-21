package ru.stqa.training.selenium.Unit1_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;            //Capabilities
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver; //IE 11
import org.openqa.selenium.chrome.ChromeDriver;       //Chrome
//import org.openqa.selenium.firefox.FirefoxDriver;     //FF
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Capabilities {
    private WebDriver driver;
    private WebDriverWait wait;

   /* ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    options.addArguments("start-maximized");
    WebDriver chromeDriver = new ChromeDriver(options);*/

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        driver = new InternetExplorerDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void capabilitiesTest() {
            }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
