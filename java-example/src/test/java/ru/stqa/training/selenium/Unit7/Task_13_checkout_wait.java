package ru.stqa.training.selenium.Unit7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task_13_checkout_wait extends TestBase {

    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.cssSelector(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void litecartWorkWithCart() {
        int count =3; //we will add this count of products to cart

        //--------------------Add products to cart----------------------------------------------------------------------
        for (int i=0;i<count;i++) {

            driver.get("http://localhost/litecart/en/"); //go to main page
            driver.findElements(By.cssSelector(".product")).get(0).click(); //chose first product from page

            int quantity = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText()); //count of products is now
            wait.until(elementToBeClickable(By.cssSelector("button[name=add_cart_product]")));
            //for product with 'Size' select element
            if (isElementPresent("td.options > strong")){
                Select selectSize = new Select(driver.findElement(By.cssSelector("select[name^=options")));
                selectSize.selectByValue("Small");
            }
            driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();//add product
            quantity += 1; //count of products after adding
            //wait while count of product will refresh with new value
            wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), "" + quantity + ""));

        }
        //--------------------Delete products from cart-----------------------------------------------------------------
        driver.get("http://localhost/litecart/en/"); //go to main page
        driver.findElement(By.cssSelector("#cart > a.link")).click(); // go to cart page
        int countOfRows = driver.findElements(By.cssSelector("table.dataTable.rounded-corners tr")).size(); //count of all table rows
        int countOfDucks = driver.findElements(By.cssSelector("li.shortcut")).size(); //count of the different products in cart

        for (int i=0;i<countOfDucks-1;i++){

            wait.until(elementToBeClickable(driver.findElements(By.cssSelector("button[name=remove_cart_item]")).get(0)));
            driver.findElements(By.cssSelector("button[name=remove_cart_item]")).get(0).click(); //delete product
            countOfRows -= 1; //in table should be rows-1
            wait.until(numberOfElementsToBe(By.cssSelector ("table.dataTable.rounded-corners tr"), countOfRows)); //in table should be rows-1

        }
        driver.findElement(By.cssSelector("button[name=remove_cart_item]")).click(); //delete last product
        wait.until(invisibilityOf(driver.findElement(By.cssSelector("a.image-wrapper.shadow")))); //last image of product shouldn't be present

        Assert.assertTrue("Not all elements were deleted",!isElementPresent("a.image-wrapper.shadow"));
    }
}
