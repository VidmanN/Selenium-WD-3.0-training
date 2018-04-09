package ru.stqa.training.selenium.Unit6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;
import java.util.List;
import java.io.File;

import static java.lang.Math.random;

public class Task_12_add_new_product extends TestBase {

    double uniqueIndexDoub = random();
    int uniqueIndex = (int)(uniqueIndexDoub*100000);

    @Test
    public void litecartAddNewProduct() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Add New Product")).click();//go to page  -Add New Product-

        //----------------General---------------------------------------
        driver.findElement(By.cssSelector("a[href*=tab-general]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Enabled')]")).click();
        driver.findElement(By.cssSelector("input[name^=name]")).sendKeys("test"+uniqueIndex); // Name of product
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys(""+uniqueIndex); // Code
        // uncheck all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
        for (int i=0; i < checkboxes.size(); i++){
            if (checkboxes.get(i).isSelected())
            {
                checkboxes.get(i).click();
            }
        }
        //Categories
        List<WebElement> categories = driver.findElements(By.cssSelector("input[name^=categories]"));
        categories.get(categories.size()-1).click();
        //Product Groups
        List<WebElement> product_groups = driver.findElements(By.cssSelector("input[name^=product_groups]"));
        product_groups.get(product_groups.size()-1).click();
        // Quantity
        driver.findElement(By.cssSelector("input[name=quantity]")).clear();
        driver.findElement(By.cssSelector("input[name=quantity]")).sendKeys(""+uniqueIndex);
        //Default Category
        Select selectCategory = new Select(driver.findElement(By.cssSelector("select[name=default_category_id]")));
        selectCategory.selectByValue("2");
        //Quantity Unit
        Select selectQuantity = new Select(driver.findElement(By.cssSelector("select[name=quantity_unit_id]")));
        selectQuantity.selectByValue("1");
        //Delivery Status
        Select selectSize = new Select(driver.findElement(By.cssSelector("select[name=delivery_status_id]")));
        selectSize.selectByValue("1");
        //Sold Out Status
        Select selectSold = new Select(driver.findElement(By.cssSelector("select[name=sold_out_status_id]")));
        selectSold.selectByValue("2");
        //Date Valid From
        driver.findElement(By.cssSelector("input[name=date_valid_from")).sendKeys("09-04-2018");
        //Date Valid To
        //driver.findElement(By.cssSelector("input[name=date_valid_to")).clear();
        driver.findElement(By.cssSelector("input[name=date_valid_to")).sendKeys("09-04-2019");
        //Upload Images
        File file = new File(new File("src/test/java/ru/stqa/training/selenium/Unit6/duck_green.png").getAbsolutePath());
        driver.findElement(By.cssSelector("input[name^=new_images]")).sendKeys(""+file);

        //-------- Information -----------------------------------------------------------------------------------------
        driver.findElement(By.linkText("Information")).click();
        //Manufacturer
        Select selectManufacturer = new Select(driver.findElement(By.cssSelector("select[name=manufacturer_id]")));
        selectManufacturer.selectByValue("1");
        //Keywords
        driver.findElement(By.cssSelector("input[name=keywords")).sendKeys(""+uniqueIndex);
        //Short Description
        driver.findElement(By.cssSelector("input[name^=short_description")).sendKeys("Short Description "+uniqueIndex);
        //Description
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Description "+uniqueIndex);
        //Head Title
        driver.findElement(By.cssSelector("input[name^=head_title")).sendKeys("Head Title "+uniqueIndex);
        //Meta Description
        driver.findElement(By.cssSelector("input[name^=meta_description")).sendKeys("Meta Description "+uniqueIndex);
        //--------- Prices ---------------------------------------------------------------------------------------------
        driver.findElement(By.linkText("Prices")).click();
        //Purchase Price
        driver.findElement(By.cssSelector("input[name=purchase_price]")).clear();
        driver.findElement(By.cssSelector("input[name=purchase_price]")).sendKeys(""+uniqueIndex);
        Select selectPrice = new Select(driver.findElement(By.cssSelector("select[name=purchase_price_currency_code]")));
        selectPrice.selectByValue("USD");
        //Price
        List<WebElement> prices = driver.findElements(By.cssSelector("input[name^=prices]"));
        prices.get(0).clear();
        prices.get(0).sendKeys("1000");
        prices.get(1).clear();
        prices.get(1).sendKeys("2000");
        //--------- Save -----------------------------------------------------------------------------------------------
        driver.findElement(By.cssSelector("button[name=save]")).click();
        //--------- New Product is presented -----------------------------------------------------------------------------
         Assert.assertTrue("Product wasn't presented",driver.findElement(By.linkText("test"+uniqueIndex)).isEnabled());
    }

}
