package ru.stqa.training.selenium.Unit5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task9_check_sorting extends TestBase{

    public List<WebElement> rows(String tableBy, String rowBy){

        //Create WebElement table
        WebElement table = driver.findElement(By.cssSelector(tableBy));
        //Get all the TR elements from the table
        List<WebElement> allRows = table.findElements(By.cssSelector(rowBy));

        return allRows;
    }

    public void testAlphabet (String tableBy, String rowBy,String indexOfCountry, int lastElement){

        List<WebElement> allRows = rows(tableBy,rowBy);

        int firstCityASCII;
        int secondCityASCII = 65; //ASCII code of char 'A'
        int i = lastElement;
        int rowsCount = allRows.size();

        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {

                //Get name of City
                if (cell.getAttribute("cellIndex").equals(indexOfCountry)) {
                    String City = cell.getText();
                    //second step
                    firstCityASCII = secondCityASCII;
                    //First letter of City name
                    char firstLetter = City.charAt(0);
                    //ASCII code of letter
                    secondCityASCII = (int) firstLetter;
                    //System.out.println("City = " + City);
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

        //PART 1
        testAlphabet("table.dataTable","tr.row","4",0);
        //PART 2
        List<String> Links = new ArrayList(); //List of Coutries with Zones

        List<WebElement> allRows = rows("table.dataTable","tr.row");
        for (WebElement row : allRows) {

            WebElement link = row;

            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {

                if (cell.getAttribute("cellIndex").equals("5") && !cell.getText().equals("0")) {
                    Links.add(link.findElement(By.tagName("a")).getText());
                }
            }
        }
        //Press on Country with zones + check Alphabet for zones + return to list of countries
        for (int i=0;i<Links.size();i++){
            String xpathLink = "//tr/td/a[contains(text(),'"+Links.get(i)+"')]";
            driver.findElement(By.xpath(xpathLink)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table#table-zones.dataTable")));

            testAlphabet("table#table-zones.dataTable","table#table-zones.dataTable tr:not(.header)","2",1);

            driver.findElement(By.cssSelector("button[name=cancel]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.dataTable")));
        }
    }
}
