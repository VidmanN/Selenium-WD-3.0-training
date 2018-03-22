package ru.stqa.training.selenium.Unit4;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.TestBase;

import java.util.List;

public class Task_7_litecart_admin_solution_2 extends TestBase {

    @Test
    public void litecartAdmin() {
        driver.get("http://localhost/litecart/admin/");
        //SignIn to Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


       /* WebElement demo1 = driver.findElement(By.cssSelector("div#box-apps-menu-wrapper ul"));
        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container  li"));
        List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

        pagination.get(2).click();
        wait.until(not(visibilityOf(items.get(0))));
        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        Assert.assertTrue(items.get(0).getText().equals("11"));*/













        //WebElement ui = driver.findElement(By.cssSelector("div#box-apps-menu-wrapper"));

        //Left Menu is present
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#box-apps-menu-wrapper li#app-")));


        //To choose all paragraphs of the Left Menu
        By mySelector = By.cssSelector("span.name");//By.xpath("/html/body/div[1]/div/section/div/div[2]/form[1]/div/ul/li");
        List<WebElement> listOfParagraphs = driver.findElements(mySelector);

       // List<WebElement> myElements = driver.findElements(mySelector);
        for(WebElement e : listOfParagraphs) {
            wait.until(ExpectedConditions.elementToBeClickable(mySelector));
            e.click();
            System.out.println(e.getText()+ " ");
            System.out.println("jdfhjshfjshfjk ");
        }
       /* System.out.println(listOfParagraphs.get(1).getText());
        listOfParagraphs.get(1).click();
        System.out.println(listOfParagraphs.get(2).getText());
        listOfParagraphs.get(2).click();*/


        //Count of paragraphs
     /*   int countOfParagraphs = listOfParagraphs.size();
        System.out.println(countOfParagraphs);

        for(int i = 0; i < countOfParagraphs ; i++)
        {
            listOfParagraphs.get(i).click();
        }*/




    }

}
