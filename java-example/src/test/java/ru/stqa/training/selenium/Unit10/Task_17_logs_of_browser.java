package ru.stqa.training.selenium.Unit10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;

import java.util.List;



public class Task_17_logs_of_browser extends TestBase{

    @Test
    public void litecartProductsLogIsEmpty() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();
        driver.findElement(By.linkText("Subcategory")).click();

        List<WebElement> Products = driver.findElements(By.cssSelector("tr.row"));
        int productsCount = Products.size();
        for (int i = 3; i <productsCount; i++) {
            List<WebElement> ProductsSecond = driver.findElements(By.cssSelector("tr.row"));
            ProductsSecond.get(i).findElement(By.cssSelector("td:nth-child(3) a")).click();

            Assert.assertTrue("Log isn't empty!",(driver.manage().logs().get("browser").getAll().size() == 0));

            driver.navigate().back();
        }
    }
}
