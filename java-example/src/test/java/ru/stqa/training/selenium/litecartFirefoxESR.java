package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class litecartFirefoxESR {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions()
                .setBinary("c:/Program Files/Mozilla Firefox ESR/firefox.exe")
                .addCapabilities(new DesiredCapabilities(ImmutableMap.of(FirefoxDriver.MARIONETTE, false)));
        driver = new FirefoxDriver(options);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void litecartTest() {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
