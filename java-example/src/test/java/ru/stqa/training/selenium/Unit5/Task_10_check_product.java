package ru.stqa.training.selenium.Unit5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import ru.stqa.training.selenium.TestBase;

import java.util.List;

import static java.lang.Float.parseFloat;


public class Task_10_check_product  extends TestBase {

    @Test
    public void litecartProductName() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
        int productsCount = Products.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            String nameOnMainPage = resultLinks.get(i).findElement(By.cssSelector("div.name")).getText();
            resultLinks.get(i).click(); // click on product
            String nameOnProductPage = driver.findElement(By.cssSelector("h1.title")).getText();
            Assert.assertTrue("Names of product don't match", nameOnMainPage.equals(nameOnProductPage));
            driver.navigate().back();
        }
    }
    @Test
    public void litecartProductPrice() {
        driver.get("http://localhost/litecart/en/");
        String prices;
        String pricesOnPage;
        String countOfPrices;
        List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
        int productsCount = Products.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            countOfPrices = resultLinks.get(i).findElement(By.cssSelector("div.price-wrapper")).getAttribute("childElementCount");
            if (countOfPrices.equals("2")){
                prices = resultLinks.get(i).findElement(By.cssSelector("s.regular-price")).getText()+" "+resultLinks.get(i).findElement(By.cssSelector("strong.campaign-price")).getText();
            }
            else prices = resultLinks.get(i).findElement(By.cssSelector("span.price")).getText();
            resultLinks.get(i).click(); // click on product

            WebElement information = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
            countOfPrices = information.getAttribute("childElementCount");
            if (countOfPrices.equals("2")){
                pricesOnPage = information.findElement(By.cssSelector("s.regular-price")).getText()+" "+information.findElement(By.cssSelector("strong.campaign-price")).getText();
            }
            else pricesOnPage = information.findElement(By.cssSelector("span.price")).getText();

            Assert.assertTrue("Prices of product don't match", prices.equals(pricesOnPage) );
            driver.navigate().back();
        }
    }
    @Test
    public void litecartRegularPrice() {
        driver.get("http://localhost/litecart/en/");
        int R,G,B;
        String countOfPrices;
        String rgb;
        List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
        int productsCount = Products.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            countOfPrices = resultLinks.get(i).findElement(By.cssSelector("div.price-wrapper")).getAttribute("childElementCount");
            if (countOfPrices.equals("2")) {
                //PART 1 - there is tag 's' for .regular-price element
                Assert.assertTrue("There isn't the line-through (tag s)", resultLinks.get(i).findElement(By.cssSelector("s.regular-price")).isEnabled());
                //PART 2 - RGB
                rgb = resultLinks.get(i).findElement(By.cssSelector(".regular-price")).getCssValue("color");
                R = Color.fromString(rgb).getColor().getRed();
                G = Color.fromString(rgb).getColor().getGreen();
                B = Color.fromString(rgb).getColor().getBlue();
                Assert.assertTrue("Color isn't grey", (R == G) && (R == B) );

                resultLinks.get(i).click(); // click on product

                WebElement information = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
                //PART 1 - there is tag 's' for .regular-price element
                Assert.assertTrue("There isn't the line-through (tag s) on product page", information.findElement(By.cssSelector("s.regular-price")).isEnabled());
                rgb = information.findElement(By.cssSelector(".regular-price")).getCssValue("color");
                R = Color.fromString(rgb).getColor().getRed();
                G = Color.fromString(rgb).getColor().getGreen();
                B = Color.fromString(rgb).getColor().getBlue();
                Assert.assertTrue("Color isn't grey on product page", (R == G) && (R == B) );

                driver.navigate().back();

            }
        }
    }
    @Test
    public void litecartCampaignPrice() {
        driver.get("http://localhost/litecart/en/");
        int R,G,B;
        String countOfPrices;
        String rgb;
        List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
        int productsCount = Products.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            countOfPrices = resultLinks.get(i).findElement(By.cssSelector("div.price-wrapper")).getAttribute("childElementCount");
            if (countOfPrices.equals("2")) {
                //PART 1 - there is tag 'strong' for .campaign-price element
                Assert.assertTrue("There isn't the bold text (tag strong)", resultLinks.get(i).findElement(By.cssSelector("strong.campaign-price")).isEnabled());
                //PART 2 - RGB
                rgb = resultLinks.get(i).findElement(By.cssSelector(".campaign-price")).getCssValue("color");
                R = Color.fromString(rgb).getColor().getRed();
                G = Color.fromString(rgb).getColor().getGreen();
                B = Color.fromString(rgb).getColor().getBlue();
                Assert.assertTrue("Color isn't red", (R > 0) && (G == 0) && (B == 0) );

                resultLinks.get(i).click(); // click on product

                WebElement information = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
                //PART 1 - there is tag 'strong' for .campaign-price element
                Assert.assertTrue("There isn't the bold text (tag strong) on product page", information.findElement(By.cssSelector("strong.campaign-price")).isEnabled());
                rgb = information.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
                R = Color.fromString(rgb).getColor().getRed();
                G = Color.fromString(rgb).getColor().getGreen();
                B = Color.fromString(rgb).getColor().getBlue();
                Assert.assertTrue("Color isn't red", (R > 0) && (G == 0) && (B == 0) );

                driver.navigate().back();

            }
        }
    }
    @Test
    public void litecartRegularVSCampaign() {
        driver.get("http://localhost/litecart/en/");
        String countOfPrices;
        String sizeRegular,sizeCampaign;
        float sizeRegularFl,sizeCampaignFl;
        List<WebElement> Products = driver.findElements(By.cssSelector(".product"));
        int productsCount = Products.size();
        for (int i = 0; i < productsCount; i++) {
            List<WebElement> resultLinks = driver.findElements(By.cssSelector(".product")); // получаем снова список вебэлементов
            countOfPrices = resultLinks.get(i).findElement(By.cssSelector("div.price-wrapper")).getAttribute("childElementCount");
            if (countOfPrices.equals("2")) {

                sizeRegular = resultLinks.get(i).findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
                sizeCampaign = resultLinks.get(i).findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
                sizeRegularFl = parseFloat(sizeRegular.replaceAll("[a-zA-Z]",""));
                sizeCampaignFl = parseFloat(sizeCampaign.replaceAll("[a-zA-Z]",""));
                Assert.assertTrue("font-size of campaign price < regular", sizeRegularFl<sizeCampaignFl );

                resultLinks.get(i).click(); // click on product

                WebElement information = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
                sizeRegular = information.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
                sizeCampaign = information.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
                sizeRegularFl = parseFloat(sizeRegular.replaceAll("[a-zA-Z]",""));
                sizeCampaignFl = parseFloat(sizeCampaign.replaceAll("[a-zA-Z]",""));
                Assert.assertTrue("font-size of campaign price < regular on product page", sizeRegularFl<sizeCampaignFl );

                driver.navigate().back();
            }
        }
    }
}
