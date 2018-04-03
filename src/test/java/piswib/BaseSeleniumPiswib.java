package piswib;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumPiswib {
    protected static WebDriver browser;

    protected BaseSeleniumPiswib() {
        browser = new FirefoxDriver();
    }

    protected static boolean is_element_exist(By by) {
        return browser.findElements(by).size() > 0;
    }

    protected static WebElement wait_and_find_element(By by) {
        int timeout = 30;

        while (timeout != 0) {
            if (is_element_exist(by)) {
                return browser.findElement(by);
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            timeout--;
        }
        throw new ElementNotVisibleException("Element not exist");
    }

    protected static class Menu {


        public static void ognivo_dluznicy() {
            wait_and_find_element(By.id("menu-group-applicationmenuognivo")).click();
            wait_and_find_element(By.linkText("Dłużnicy")).click();
        }

        public static void ognivo_centralna_informacja() {
            System.out.println("login dłużnicy");
        }

        public static void ognivo_ezajecia() {
            System.out.println("login e-zajecia");

        }

    }
}
