package ru.stqa.training.selenium.Unit11.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.training.selenium.Unit11.pages.MainPage;
import ru.stqa.training.selenium.Unit11.pages.ProductPage;
import ru.stqa.training.selenium.Unit11.pages.CartPage;

public class Application {
    private WebDriver driver;

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void quit() {

        driver.quit();
    }

    public void addProducts(int count) {

        for (int i=0;i<count;i++) {
            mainPage.open(); //go to main page
            mainPage.firstProduct().click(); //chose first product from page
            int quantity = productPage.quantityInt(); //count of products is now
            productPage.waitAddClickable();
            productPage.selectSize(); //for product with 'Size' select element
            productPage.buttonAdd.click();//add product
            //wait while count of product will refresh with new value
            productPage.waitQuantityRefresh(quantity+1); //count of products after adding
        }
    }

    public void deleteProducts() {
        mainPage.open(); //go to main page
        mainPage.goCart.click(); //go to cart page
        int countOfRows = cartPage.tableProducts.size(); //count of all table rows
        int countOfDucks = cartPage.differentDucks.size(); //count of the different products in cart
        for (int i=0;i<countOfDucks-1;i++){
            cartPage.waitRemoveClickable();
            cartPage.buttonsRemove.get(0).click(); //delete product
            countOfRows -= 1; //in table should be rows-1
            cartPage.waitRowsCount(countOfRows); //in table should be rows-1
        }
        cartPage.buttonRemove.click(); //delete last product
    }

    public boolean deleteAllProducts(){
        return cartPage.imageInvisibility();
    }
}
