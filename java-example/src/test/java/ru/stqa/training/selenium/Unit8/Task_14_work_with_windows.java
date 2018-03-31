package ru.stqa.training.selenium.Unit8;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.stqa.training.selenium.TestBase;
import java.util.List;
import java.util.Set;

public class Task_14_work_with_windows extends TestBase {


    public static ExpectedCondition<String> newWindowHandleIs(
            final Set<String> existingWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                String newWindowHandle = "";
                do{
                Set<String> Windows = driver.getWindowHandles();
                    System.out.println("test wind all= "+existingWindows);
                    System.out.println("test new wins= "+Windows);
                Windows.removeAll(existingWindows);
                newWindowHandle = Windows.toString();
                    System.out.println("test cond= "+newWindowHandle);
                }
                while (newWindowHandle.equals(""));
                return newWindowHandle;
                }
        };
    }


    @Test
    public void testWindows(){
        driver.get("http://localhost/litecart/admin");
        //SignIn as Admin
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //Left Menu -> Countries
        driver.findElement(By.cssSelector("i.fa.fa-flag.fa-stack-1x.icon")).click();

        driver.findElement(By.cssSelector("a[title=Edit]")).click();

        List<WebElement> externalLinks = driver.findElements(By.cssSelector("i.fa.fa-external-link"));

        int linksCount = externalLinks.size();
        for (int i = 0; i < linksCount; i++) {
            List<WebElement> Links = driver.findElements(By.cssSelector("i.fa.fa-external-link")); // получаем снова список вебэлементов
            WebElement linkExternal = Links.get(i);
  String aaa = driver.getCurrentUrl();

            System.out.println("a1="+aaa);
            String mainWindow = driver.getWindowHandle();// запоминаем идентификатор текущего окна
            System.out.println("test old win= "+ mainWindow);
            Set<String> allWindows = driver.getWindowHandles(); // запоминаем идентификаторы уже открытых окон
            linkExternal.click(); // открывает новое окно

            String newWindow = wait.until(newWindowHandleIs(allWindows)); // ждем появления нового окна, с новым идентификатором

            System.out.println("fhgdfhfjdfhjdh="+driver.getWindowHandles());

            System.out.println("test 1");
            String a1 = driver.getCurrentUrl();
            System.out.println("a2="+a1);
            if ( !mainWindow.equals(newWindow)){

                System.out.println("new in main = "+newWindow);
                driver.switchTo().window(newWindow);
                System.out.println("a new = "+driver.getCurrentUrl());

            }


            System.out.println("test 2");
            //driver.close();
            System.out.println("test 3");
            driver.switchTo().window(mainWindow);
            System.out.println("test 4");
            driver.navigate().back();
            }
        }
}

