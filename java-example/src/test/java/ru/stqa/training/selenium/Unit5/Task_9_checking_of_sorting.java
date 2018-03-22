package ru.stqa.training.selenium.Unit5;

import org.junit.Test;
import ru.stqa.training.selenium.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Task_9_checking_of_sorting extends TestBase{

    public List<WebElement> rows(String tableBy, String rowBy){
        //Create WebElement table
        WebElement table = driver.findElement(By.cssSelector(tableBy));
        //Get all the TR elements from the table
        List<WebElement> allRows = table.findElements(By.cssSelector(rowBy));
        return allRows;
    }

    public void testAlphabet (String tableBy, String rowBy){

        List<WebElement> allRows = rows(tableBy,rowBy);

        int firstCityASCII;
        int secondCityASCII = 65; //ASCII code of char 'A'
        int i = 0;
        int rowsCount = allRows.size();

        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {

                //Get name of City
                if (cell.getAttribute("cellIndex").equals("4")) {
                    String City = cell.getText();
                    //First letter of City name

                    //second step
                    firstCityASCII = secondCityASCII;
                    //char secondCity = firstLetter;
                    //ASCII code of letter
                    char firstLetter = City.charAt(0);
                    secondCityASCII = (int) firstLetter;
                    System.out.println("City = " + City);
                    Assert.assertTrue("Countries don't sorted by alphabet", firstCityASCII <= secondCityASCII);
                }
            }
            i += 1;
            if (i == rowsCount) break;
        }
    }

    @Test
    public void litecartAdmin() {
        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
        //SignIn as Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //testAlphabet("table.dataTable","tr.row");

        List<WebElement> allRows = rows("table.dataTable","tr.row");
        for (WebElement row : allRows) {
            String countZone = "0";
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {

                if (cell.getAttribute("cellIndex").equals("5") && !cell.getText().equals("0")) {
                    countZone = cell.getAttribute("cellIndex");
                    break;
                }
            }
            if (countZone != "0") {

                System.out.println("qu qu ="+row.findElement(By.tagName("a")).getText());
                String B1 = "//a[@text='"+row.findElement(By.tagName("a")).getText()+"']";
                driver.findElement(By.xpath(B1)).click();


               // testAlphabet("table#table-zones.dataTable","tr:not(.header)");
            }
        }

    }
}

