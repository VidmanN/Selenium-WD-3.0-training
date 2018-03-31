package ru.stqa.training.selenium.Unit6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;
import static java.lang.Math.random;


public class Task_11_user_registration extends TestBase{

    double uniqueIndexDoub = random();
    int uniqueIndex = (int)(uniqueIndexDoub*100000);

    @Test
    public void UserRegistration() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//a[contains(text(),'New customers click here')]")).click();


        driver.findElement(By.cssSelector("input[name='tax_id']")).sendKeys("ID00"+uniqueIndex+"" + Keys.ENTER); // Tax ID
        driver.findElement(By.cssSelector("input[name='company']")).sendKeys("Selenium" + Keys.ENTER); // Company
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("TestFirstName" + Keys.ENTER); // First Name
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("TestLastName" + Keys.ENTER); // Last Name
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("TestAddress1" + Keys.ENTER); // Address 1
        driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("TestAddress2" + Keys.ENTER); // Address 2
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("12345" + Keys.ENTER); // Postcode
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("TestCity" + Keys.ENTER); // City

        Select selectCountry = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        selectCountry.selectByValue("US");

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].selectedIdex = 10; arguments[0].dispatchEvent(new Event(\"change\"));",driver.findElement(By.cssSelector("select[name=zone_code]")));

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test"+uniqueIndex+"@email.com" + Keys.ENTER);//Email
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(Keys.HOME + "+7809500"+uniqueIndex+"" + Keys.ENTER);//Phone
        //Newsletter
        if (driver.findElement(By.cssSelector("input[name='newsletter']")).getAttribute("value").equals("0")){
            driver.findElement(By.cssSelector("input[name='newsletter']")).click();
        }

        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("pass"+uniqueIndex+"" + Keys.ENTER);//Desired Password
        driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys("pass"+uniqueIndex+"" + Keys.ENTER);//Confirm Password


        //executor.executeScript("arguments[0].onclick = true;",driver.findElement(By.cssSelector("button[name=create_account]")));
        driver.findElement(By.cssSelector("[type=submit]")).click();

        wait.until(ExpectedConditions.urlContains("http://localhost/litecart/en"));
        Assert.assertTrue("Registration isn't success!",(driver.findElement(By.cssSelector("div.notice.success")).getText().equals("Your customer account has been created.")));

        //--------------Log Out----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#slider-wrapper")));
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        //--------------Log In-----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=email]")));
        driver.findElement(By.cssSelector("input[name=email]")).clear();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("test"+uniqueIndex+"@email.com" + Keys.ENTER);//Email Address
        executor.executeScript("arguments[0].value = \"pass"+uniqueIndex+"\"; arguments[0].dispatchEvent(new Event(\"change\"))",driver.findElement(By.cssSelector("input[name=password]")));
    }
}
