package ru.stqa.training.selenium.Unit11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartPage extends Page  {

    public CartPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(css = "table.dataTable.rounded-corners tr")
    public List<WebElement> tableProducts;

    @FindBy(css = "li.shortcut")
    public List<WebElement> differentDucks;

    @FindBy(css = "button[name=remove_cart_item]")
    public List<WebElement> buttonsRemove;

    @FindBy(css = "button[name=remove_cart_item]")
    public WebElement buttonRemove;

    @FindBy(css = "a.image-wrapper.shadow")
    public WebElement imageDuck;

    public void waitRemoveClickable(){
        wait.until(elementToBeClickable(this.buttonsRemove.get(0)));
    }

    public void waitRowsCount(int count) {
        wait.until(numberOfElementsToBe(By.cssSelector("table.dataTable.rounded-corners tr"), count));
    }

    public boolean imageInvisibility() {
        return isElementPresent(this.imageDuck);
    }

}
