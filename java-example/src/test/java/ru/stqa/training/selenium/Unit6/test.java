package ru.stqa.training.selenium.Unit6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;

public class test  extends TestBase {

    @Test
    public void Test1(){
        driver.get("http://localhost/litecart/en/create_account");

        //Select selectZone = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        //WebElement sel = driver.findElement(By.cssSelector("select[name=zone_code]"));
        System.out.println("test 1");
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIdex = 10; arguments[0].dispatchEvent(new Event('change'))",driver.findElement(By.cssSelector("select[name=zone_code]")));
        System.out.println("test 2");
        WebElement element = driver.findElement(By.cssSelector("button[name=create_account]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }

}
