package piswib;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static piswib.Repository.*;
import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumPiswib {

    protected static final WebDriver browser = new FirefoxDriver();

    protected static void sign_in() {
        wait_and_find_element(By.id("loginform:login")).sendKeys(GOOD_LOGIN);
        wait_and_find_element(By.id("loginform:password")).sendKeys(GOOD_PASSWORD);
        wait_and_find_element(By.id("loginform:submita")).click();
        wait_and_find_element(By.id("loginLabel"));

    }

    protected static void sign_out() {
        wait_and_find_element(By.id("authTopForm:logoutButton")).click();
        wait_and_find_element(By.id("loginform:login"));

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
        throw new ElementNotVisibleException("Element not exist: " + by.toString());
    }

    protected static boolean wait_for_page(String search_name_page) {
        int timeout = 30;

        while (timeout != 0) {
            String name_page = wait_and_find_element(By.id("contentForm:templateTitleId")).getText();
            if (search_name_page.contains(name_page)) {
                return true;
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            timeout--;
        }
        throw new ElementNotVisibleException("Element not exist: " + search_name_page);
    }

    protected static class Menu {


        public static void ognivo_dluznicy() {
            wait_and_find_element(By.id("menu-group-applicationmenuognivo")).click();
            wait_and_find_element(By.linkText("Dłużnicy")).click();
            wait_for_page("Dłużnicy");
        }

        public static void ognivo_centralna_informacja() {
            wait_and_find_element(By.id("menu-group-applicationmenuognivo")).click();
            wait_and_find_element(By.linkText("Centralna informacja")).click();
            wait_for_page("Centralna informacja");
        }

        public static void ognivo_ezajecia() {
            System.out.println("login e-zajecia");

        }

    }
}
