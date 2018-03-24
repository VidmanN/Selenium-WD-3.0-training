package ru.stqa.training.selenium.Unit4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

import java.util.List;


public class Task_8_litecart_stickers_solution_2 extends TestBase {


    @Test
    public void litecartDucksAndStickers() {
        driver.get("http://localhost/litecart/en/");

        //One of ducks is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product")));

        List<WebElement> listOfDucks = driver.findElements(By.cssSelector(".product"));
        int productsCount = listOfDucks.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            int isSticker = resultLinks.get(i).findElements(By.cssSelector(".sticker")).size();
            
            Assert.assertTrue("Not all ducks have a stickers!",isSticker > 0);
        }
    }
}
