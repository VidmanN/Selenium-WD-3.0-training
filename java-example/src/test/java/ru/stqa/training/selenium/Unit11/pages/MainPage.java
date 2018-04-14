package ru.stqa.training.selenium.Unit11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/en/");
    }

    @FindBy(css = ".product")
    private List<WebElement> products;

    @FindBy(css = "#cart > a.link")
    public WebElement goCart;

    public WebElement firstProduct() {
        return this.products.get(0);
    }

}
