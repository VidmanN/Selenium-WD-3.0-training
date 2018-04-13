package ru.stqa.training.selenium.Unit11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Page  {

    public CartPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
}
