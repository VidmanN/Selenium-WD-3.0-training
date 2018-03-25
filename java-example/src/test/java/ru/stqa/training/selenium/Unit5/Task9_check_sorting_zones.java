package ru.stqa.training.selenium.Unit5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;

import java.util.List;

public class Task9_check_sorting_zones extends TestBase{

    @Test
    public void litecartCheckingZones() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        //SignIn as Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> Countries = driver.findElements(By.cssSelector("table.dataTable tr.row"));  // list of countries
        int countriesCount = Countries.size();
        for (int i = 0; i < countriesCount; i++) {
            List<WebElement> countryLinks = driver.findElements(By.cssSelector("table.dataTable tr.row")); // list of countries
            WebElement link = countryLinks.get(i).findElement(By.cssSelector("td:nth-child(3) a"));

            link.click(); // click on country

            //////////////--Alphabet on Select---/////////////////////
            int firstZoneASCII;
            int secondZoneASCII = 65; //ASCII code of char 'A'
            List<WebElement> selectZones = driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3) select"));
            for (WebElement zone : selectZones) {

                Select selectZone = new Select(zone);
                String zoneName = selectZone.getFirstSelectedOption().getText();
                firstZoneASCII = secondZoneASCII;
                //First letter of Zone name
                char firstLetter = zoneName.charAt(0);
                //ASCII code of letter
                secondZoneASCII = (int) firstLetter;

                Assert.assertTrue("Countries don't sorted by alphabet", firstZoneASCII <= secondZoneASCII);
            }
            /////////////--END---////////////////////////////////////
            driver.navigate().back();
        }
    }
}

