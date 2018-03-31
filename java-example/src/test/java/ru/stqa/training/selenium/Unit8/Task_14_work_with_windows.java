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


                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(existingWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
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

        List<WebElement> externalLinks = driver.findElements(By.cssSelector("i.fa.fa-external-link")); //список вебэлементов ведущих на доп. окна

        int linksCount = externalLinks.size();
        for (int i = 0; i < linksCount; i++) {
            System.out.println("number of iteration = "+(i+1));
            List<WebElement> Links = driver.findElements(By.cssSelector("i.fa.fa-external-link")); //список вебэлементов ведущих на доп. окна
            WebElement linkExternal = Links.get(i);

            String mainWindow = driver.getWindowHandle();// запоминаем идентификатор текущего окна
            Set<String> allWindows = driver.getWindowHandles(); // запоминаем идентификаторы уже открытых окон
            linkExternal.click(); // открывает новое окно

            String newWindow = wait.until(newWindowHandleIs(allWindows)); // ждем появления нового окна, с новым идентификатором

            driver.switchTo().window(newWindow); // переключаемся в новое окно
            driver.close(); // закрываем новое окно
            driver.switchTo().window(mainWindow); // возвращаемся в главное окно
            }
        }
}

