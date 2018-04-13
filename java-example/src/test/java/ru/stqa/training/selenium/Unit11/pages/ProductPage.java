package ru.stqa.training.selenium.Unit11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page  {

    public ProductPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span.quantity")
    public WebElement quantity;

    @FindBy(css = "button[name=add_cart_product]")
    public WebElement buttonAdd;

    @FindBy(css = "td.options > strong")
    public WebElement optionSize;

    public void selectSize(String size) {
        Select selectSize = new Select(driver.findElement(By.cssSelector("select[name^=options")));
        selectSize.selectByValue(size);
    }
}
