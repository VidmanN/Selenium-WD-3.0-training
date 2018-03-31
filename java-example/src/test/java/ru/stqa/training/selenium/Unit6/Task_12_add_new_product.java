package ru.stqa.training.selenium.Unit6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

public class Task_12_add_new_product extends TestBase {

    double uniqueIndexDoub = random();
    int uniqueIndex = (int)(uniqueIndexDoub*100000);

    @Test
    public void litecartLeftMenu() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("i.fa.fa-th.fa-stack-1x.icon")).click();
        driver.findElement(By.xpath("//a[contains(text(),' Add New Product')]")).click();


        //----------------General---------------------------------------
        driver.findElement(By.xpath("//label[contains(text(),'Enabled')]")).click();
        driver.findElement(By.cssSelector("input[name^=name]")).sendKeys("test"+uniqueIndex + Keys.ENTER); // Name of product
       // driver.findElement(By.cssSelector("input[name=code]")).clear();
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys(""+uniqueIndex + Keys.ENTER); // Code

        //--selects

       /* System.out.println(driver.findElement(By.cssSelector("select[name=quantity_unit_id]")).getText());
        System.out.println(driver.findElement(By.cssSelector("select[name=delivery_status_id]")).getText());

        Select selectSize = new Select(driver.findElement(By.cssSelector("select[name=delivery_status_id]")));
        selectSize.selectByValue("1");
        */
        //((JavascriptExecutor) driver).executeScript("arguments[0].selectedIdex = 1;arguments[0].dispatchEvent(new Event('change'))",selectZone);

        //System.out.println(driver.findElement(By.cssSelector("div#tab-general select[name=delivery_status_id]")).getText());
       // System.out.println(driver.findElements(By.cssSelector("select")).get(1).getText());
        //System.out.println(driver.findElements(By.cssSelector("select")).get(2).getText());
       // System.out.println(driver.findElements(By.cssSelector("select")).get(3).getText());
       // System.out.println(driver.findElements(By.cssSelector("select")).get(4).getText());
       // System.out.println(driver.findElements(By.cssSelector("select")).get(5).getText());



        /*WebElement selectZone = driver.findElement(By.cssSelector("select[name=quantity_unit_id]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIdex = 1;arguments[0].dispatchEvent(new Event('change'))",selectZone);*/
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);


        Select selectQuantityUnit = new Select(driver.findElement(By.cssSelector("select[name=quantity_unit_id]")));
        selectQuantityUnit.selectByValue("1");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select selectDeliveryStatus = new Select(driver.findElement(By.cssSelector("select[name=delivery_status_id]")));
        selectDeliveryStatus.selectByValue("1");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select selectSoldOutStatus = new Select(driver.findElement(By.cssSelector("select[name=sold_out_status_id]")));
        selectSoldOutStatus.selectByValue("1");

        //---------

    }

}
