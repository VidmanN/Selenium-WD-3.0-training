package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;       //Chrome
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver; //IE 11
import org.openqa.selenium.firefox.FirefoxDriver;     //FF
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class allBrowsers {
    private WebDriver chromeDriver = new ChromeDriver();
    private WebDriver ieDriver = new InternetExplorerDriver();

    FirefoxOptions options = new FirefoxOptions().setLegacy(false);
    private WebDriver firefoxDriver = new FirefoxDriver(options);


    private WebDriverWait chromeWait;
    private WebDriverWait ieWait;
    private WebDriverWait firefoxWait;

    @Before
    public void start() {
        chromeWait = new WebDriverWait(chromeDriver, 10);
        ieWait = new WebDriverWait(ieDriver, 10);
        firefoxWait = new WebDriverWait(firefoxDriver, 10);
    }

    @Test
    public void allBrowsersTest() {
        chromeDriver.get("http://www.google.com");
        chromeDriver.findElement(By.name("q")).sendKeys("vidman\n");
        chromeDriver.findElement(By.name("btnG")).click();
        chromeWait.until(titleIs("vidman - Поиск в Google"));

        ieDriver.get("http://www.google.com");
        ieDriver.findElement(By.name("q")).sendKeys("vidman ");
        ieDriver.findElement(By.name("btnK")).click();
        ieWait.until(titleIs("vidman - Поиск в Google"));

        firefoxDriver.get("http://www.google.com");
        firefoxDriver.findElement(By.name("q")).sendKeys("vidman");
        firefoxDriver.findElement(By.name("btnK")).click();
        firefoxWait.until(titleIs("vidman - Поиск в Google"));
    }

    @After
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;

        ieDriver.quit();
        ieDriver = null;

        firefoxDriver.quit();
        firefoxDriver = null;
    }


}
