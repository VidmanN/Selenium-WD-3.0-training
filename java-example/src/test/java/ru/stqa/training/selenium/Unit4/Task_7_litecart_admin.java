package ru.stqa.training.selenium.Unit4;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

public class Task_7_litecart_admin extends TestBase {

    @Test
    public void litecartAdmin() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //Left Menu is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#box-apps-menu.list-vertical")));

        //Left Menu -> Apperance
        WebElement Apperance = driver.findElement(By.cssSelector("i.fa.fa-adjust.fa-stack-1x.icon"));
        Apperance.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-template")));
        driver.findElement(By.cssSelector("li#doc-template")).click();
        Assert.assertTrue("Header 'Template' not found!", driver.findElement(By.tagName("h1")).getText().contains("Template"));
        driver.findElement(By.cssSelector("li#doc-logotype")).click();
        Assert.assertTrue("Header 'Logotype' not found!", driver.findElement(By.tagName("h1")).getText().contains("Logotype"));

        //Left Menu -> Catalog
        WebElement Catalog = driver.findElement(By.cssSelector("i.fa.fa-th.fa-stack-1x.icon"));
        Catalog.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-catalog")));
        driver.findElement(By.cssSelector("li#doc-catalog")).click();
        Assert.assertTrue("Header 'Catalog' not found!", driver.findElement(By.tagName("h1")).getText().contains("Catalog"));
        driver.findElement(By.cssSelector("li#doc-product_groups")).click();
        Assert.assertTrue("Header 'Product Groups' not found!", driver.findElement(By.tagName("h1")).getText().contains("Product Groups"));
        driver.findElement(By.cssSelector("li#doc-option_groups")).click();
        Assert.assertTrue("Header 'Option Groups' not found!", driver.findElement(By.tagName("h1")).getText().contains("Option Groups"));
        driver.findElement(By.cssSelector("li#doc-manufacturers")).click();
        Assert.assertTrue("Header 'Manufacturers' not found!", driver.findElement(By.tagName("h1")).getText().contains("Manufacturers"));
        driver.findElement(By.cssSelector("li#doc-suppliers")).click();
        Assert.assertTrue("Header 'Suppliers' not found!", driver.findElement(By.tagName("h1")).getText().contains("Suppliers"));
        driver.findElement(By.cssSelector("li#doc-delivery_statuses")).click();
        Assert.assertTrue("Header 'Delivery Statuses' not found!", driver.findElement(By.tagName("h1")).getText().contains("Delivery Statuses"));
        driver.findElement(By.cssSelector("li#doc-sold_out_statuses")).click();
        Assert.assertTrue("Header 'Sold Out Statuses' not found!", driver.findElement(By.tagName("h1")).getText().contains("Sold Out Statuses"));
        driver.findElement(By.cssSelector("li#doc-quantity_units")).click();
        Assert.assertTrue("Header 'Quantity Units' not found!", driver.findElement(By.tagName("h1")).getText().contains("Quantity Units"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        Assert.assertTrue("Header 'CSV Import/Export' not found!", driver.findElement(By.tagName("h1")).getText().contains("CSV Import/Export"));

        //Left Menu -> Countries
        WebElement Countries = driver.findElement(By.cssSelector("i.fa.fa-flag.fa-stack-1x.icon"));
        Countries.click();
        Assert.assertTrue("Header 'Countries' not found!", driver.findElement(By.tagName("h1")).getText().contains("Countries"));

        //Left Menu -> Currencies
        WebElement Currencies = driver.findElement(By.cssSelector("i.fa.fa-money.fa-stack-1x.icon"));
        Currencies.click();
        Assert.assertTrue("Header 'Currencies' not found!", driver.findElement(By.tagName("h1")).getText().contains("Currencies"));

        //Left Menu -> Customers
        WebElement Customers = driver.findElement(By.cssSelector("i.fa.fa-user.fa-stack-1x.icon"));
        Customers.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-customers")));
        driver.findElement(By.cssSelector("li#doc-customers")).click();
        Assert.assertTrue("Header 'Customers' not found!", driver.findElement(By.tagName("h1")).getText().contains("Customers"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        Assert.assertTrue("Header 'CSV Import/Export' not found!", driver.findElement(By.tagName("h1")).getText().contains("CSV Import/Export"));
        driver.findElement(By.cssSelector("li#doc-newsletter")).click();
        Assert.assertTrue("Header 'Newsletter' not found!", driver.findElement(By.tagName("h1")).getText().contains("Newsletter"));

        //Left Menu -> Geo Zones
        WebElement GeoZones = driver.findElement(By.cssSelector("i.fa.fa-globe.fa-stack-1x.icon"));
        GeoZones.click();
        Assert.assertTrue("Header 'Geo Zones' not found!", driver.findElement(By.tagName("h1")).getText().contains("Geo Zones"));

        //Left Menu -> Languages
        WebElement Languages = driver.findElement(By.cssSelector("i.fa.fa-comments.fa-stack-1x.icon"));
        Languages.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-languages")));
        driver.findElement(By.cssSelector("li#doc-languages")).click();
        Assert.assertTrue("Header 'Languages' not found!", driver.findElement(By.tagName("h1")).getText().contains("Languages"));
        driver.findElement(By.cssSelector("li#doc-storage_encoding")).click();
        Assert.assertTrue("Header 'Storage Encoding' not found!", driver.findElement(By.tagName("h1")).getText().contains("Storage Encoding"));

        //Left Menu -> Modules
        WebElement Modules = driver.findElement(By.cssSelector("i.fa.fa-cube.fa-stack-1x.icon"));
        Modules.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-jobs")));
        driver.findElement(By.cssSelector("li#doc-jobs")).click();
        Assert.assertTrue("Header 'Job Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Job Modules"));
        driver.findElement(By.cssSelector("li#doc-customer")).click();
        Assert.assertTrue("Header 'Customer Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Customer Modules"));
        driver.findElement(By.cssSelector("li#doc-shipping")).click();
        Assert.assertTrue("Header 'Shipping Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Shipping Modules"));
        driver.findElement(By.cssSelector("li#doc-payment")).click();
        Assert.assertTrue("Header 'Payment Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Payment Modules"));
        driver.findElement(By.cssSelector("li#doc-order_total")).click();
        Assert.assertTrue("Header 'Order Total Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Order Total Modules"));
        driver.findElement(By.cssSelector("li#doc-order_success")).click();
        Assert.assertTrue("Header 'Order Success Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Order Success Modules"));
        driver.findElement(By.cssSelector("li#doc-order_action")).click();
        Assert.assertTrue("Header 'Order Action Modules' not found!", driver.findElement(By.tagName("h1")).getText().contains("Order Action Modules"));

        //Left Menu -> Orders
        WebElement Orders = driver.findElement(By.cssSelector("i.fa.fa-shopping-cart.fa-stack-1x.icon"));
        Orders.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-orders")));
        driver.findElement(By.cssSelector("li#doc-orders")).click();
        Assert.assertTrue("Header 'Orders' not found!", driver.findElement(By.tagName("h1")).getText().contains("Orders"));
        driver.findElement(By.cssSelector("li#doc-order_statuses")).click();
        Assert.assertTrue("Header 'Order Statuses' not found!", driver.findElement(By.tagName("h1")).getText().contains("Order Statuses"));

        //Left Menu -> Pages
        WebElement Pages = driver.findElement(By.cssSelector("i.fa.fa-file-text.fa-stack-1x.icon"));
        Pages.click();
        Assert.assertTrue("Header 'Pages' not found!", driver.findElement(By.tagName("h1")).getText().contains("Pages"));

        //Left Menu -> Reports
        WebElement Reports = driver.findElement(By.cssSelector("i.fa.fa-pie-chart.fa-stack-1x.icon"));
        Reports.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-monthly_sales")));
        driver.findElement(By.cssSelector("li#doc-monthly_sales")).click();
        Assert.assertTrue("Header 'Monthly Sales' not found!", driver.findElement(By.tagName("h1")).getText().contains("Monthly Sales"));
        driver.findElement(By.cssSelector("li#doc-most_sold_products")).click();
        Assert.assertTrue("Header 'Most Sold Products' not found!", driver.findElement(By.tagName("h1")).getText().contains("Most Sold Products"));
        driver.findElement(By.cssSelector("li#doc-most_shopping_customers")).click();
        Assert.assertTrue("Header 'Most Shopping Customers' not found!", driver.findElement(By.tagName("h1")).getText().contains("Most Shopping Customers"));

        //Left Menu -> Settings
        WebElement Settings = driver.findElement(By.cssSelector("i.fa.fa-cogs.fa-stack-1x.icon"));
        Settings.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-store_info")));
        driver.findElement(By.cssSelector("li#doc-store_info")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-defaults")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-general")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-listings")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-images")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-checkout")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-advanced")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));
        driver.findElement(By.cssSelector("li#doc-security")).click();
        Assert.assertTrue("Header 'Settings' not found!", driver.findElement(By.tagName("h1")).getText().contains("Settings"));

        //Left Menu -> Slides
        WebElement Slides = driver.findElement(By.cssSelector("i.fa.fa-picture-o.fa-stack-1x.icon"));
        Slides.click();
        Assert.assertTrue("Header 'Slides' not found!", driver.findElement(By.tagName("h1")).getText().contains("Slides"));

        //Left Menu -> Tax
        WebElement Tax = driver.findElement(By.cssSelector("i.fa.fa-university.fa-stack-1x.icon"));
        Tax.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-tax_classes")));
        driver.findElement(By.cssSelector("li#doc-tax_classes")).click();
        Assert.assertTrue("Header 'Tax Classes' not found!", driver.findElement(By.tagName("h1")).getText().contains("Tax Classes"));
        driver.findElement(By.cssSelector("li#doc-tax_rates")).click();
        Assert.assertTrue("Header 'Tax Rates' not found!", driver.findElement(By.tagName("h1")).getText().contains("Tax Rates"));

        //Left Menu -> Translations
        WebElement Translations = driver.findElement(By.cssSelector("i.fa.fa-book.fa-stack-1x.icon"));
        Translations.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-search")));
        driver.findElement(By.cssSelector("li#doc-search")).click();
        Assert.assertTrue("Header 'Search Translations' not found!", driver.findElement(By.tagName("h1")).getText().contains("Search Translations"));
        driver.findElement(By.cssSelector("li#doc-scan")).click();
        Assert.assertTrue("Header 'Scan Files For Translations' not found!", driver.findElement(By.tagName("h1")).getText().contains("Scan Files For Translations"));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        Assert.assertTrue("Header 'CSV Import/Export' not found!", driver.findElement(By.tagName("h1")).getText().contains("CSV Import/Export"));

        //Left Menu -> Users
        WebElement Users = driver.findElement(By.cssSelector("i.fa.fa-star.fa-stack-1x.icon"));
        Users.click();
        Assert.assertTrue("Header 'Users' not found!", driver.findElement(By.tagName("h1")).getText().contains("Users"));

        //Left Menu -> vQmods
        WebElement vQmods = driver.findElement(By.cssSelector("i.fa.fa-plug.fa-stack-1x.icon"));
        vQmods.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#doc-vqmods")));
        driver.findElement(By.cssSelector("li#doc-vqmods")).click();
        Assert.assertTrue("Header 'vQmods' not found!", driver.findElement(By.tagName("h1")).getText().contains("vQmods"));
    }


}
