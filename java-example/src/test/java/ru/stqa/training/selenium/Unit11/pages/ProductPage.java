package ru.stqa.training.selenium.Unit11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductPage extends Page  {

    public ProductPage (WebDriver driver) {
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

    @FindBy(css = "span.quantity")
    public WebElement quantity;

    @FindBy(css = "button[name=add_cart_product]")
    public WebElement buttonAdd;

    @FindBy(css = "td.options > strong")
    public WebElement optionSize;

    public void selectSize() {
        if (isElementPresent(this.optionSize)) {
            Select selectSize = new Select(driver.findElement(By.cssSelector("select[name^=options")));
            selectSize.selectByValue("Small");
        }
    }

    public int quantityInt() {
        return Integer.parseInt(this.quantity.getText());
    }

    public void waitAddClickable() {
        wait.until(elementToBeClickable(this.buttonAdd));
    }

    public void waitQuantityRefresh(int quantityNew) {
        //wait while count of product will refresh with new value
        wait.until(textToBePresentInElement(this.quantity, "" + quantityNew + ""));
    }

}
