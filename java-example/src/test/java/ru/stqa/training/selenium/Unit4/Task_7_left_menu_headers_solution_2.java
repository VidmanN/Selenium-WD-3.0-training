package ru.stqa.training.selenium.Unit4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

import java.util.List;

public class Task_7_left_menu_headers_solution_2 extends TestBase {

    @Test
    public void litecartLeftMenu() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#box-apps-menu")));

        List<WebElement> menuItems = driver.findElements(By.cssSelector("li#app-"));
        int itemsCount = menuItems.size();

        for (int i = 0; i < itemsCount; i++) {
            List<WebElement> itemLinks = driver.findElements(By.cssSelector("li#app-")); // list of li
            itemLinks.get(i).click();
            Assert.assertTrue("Header 'Template' not found!", driver.findElement(By.tagName("h1")).isEnabled());
            ///-------links into menu item////////////////////
            List<WebElement> intoItems = driver.findElements(By.cssSelector("ul.docs a"));
            int intoCount = intoItems.size();

            for (int j = 1; j < intoCount; j++) {
                List<WebElement> intoItems_ = driver.findElements(By.cssSelector("ul.docs a")); // list of li
                intoItems_.get(j).click();
                Assert.assertTrue("Header 'Template' not found!", driver.findElement(By.tagName("h1")).isEnabled());
                driver.navigate().back();
            }
            ///-------end/////////////////////////////////////
            driver.navigate().back();
        }
    }
}
