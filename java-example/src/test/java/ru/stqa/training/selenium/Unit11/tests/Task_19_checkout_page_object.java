package ru.stqa.training.selenium.Unit11.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Task_19_checkout_page_object extends TestBase {

    @Test
    public void litecartWorkWithCart() {
        int count =3; //we will add this count of products to cart
        app.addProducts(count);
        app.deleteProducts();
        assertTrue("Not all elements were deleted", app.deleteAllProducts());
    }
}
