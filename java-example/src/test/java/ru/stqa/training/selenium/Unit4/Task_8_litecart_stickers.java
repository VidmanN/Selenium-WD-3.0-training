package ru.stqa.training.selenium.Unit4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

import java.util.List;


public class Task_8_litecart_stickers extends TestBase {

    @Test
    public void litecartDucksAndStickers() {
        driver.get("http://localhost/litecart/en/");

        //One of ducks is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.image-wrapper")));

        //To choose all ducks on the page
        List<WebElement> listOfDucks = driver.findElements(By.cssSelector("div.image-wrapper"));
        //Count of all ducks on the page
        int countOfDucks = listOfDucks.size();

        //To choose all stickers "New" on the page
        List<WebElement> listOfStickersNew = driver.findElements(By.cssSelector("div.sticker.new"));
        int countOfStickersNew = listOfStickersNew.size();

        //To choose all stickers "Sale" on the page
        List<WebElement> listOfStickerSale = driver.findElements(By.cssSelector("div.sticker.sale"));
        int countOfStickerSale = listOfStickerSale.size();

        //Amount of all "New" and "Sale" stickers on the page
        int countOfStickers = countOfStickersNew+countOfStickerSale;

        //If count of ducks = count of stickers - then all ducks have a stickers
        Assert.assertTrue("Not all ducks have a stickers!",countOfDucks == countOfStickers);

    }
}
