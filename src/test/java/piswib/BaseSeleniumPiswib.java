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

    protected static void signIn() {
        waitAndFindElement(By.id("loginform:login")).sendKeys(GOOD_LOGIN);
        waitAndFindElement(By.id("loginform:password")).sendKeys(GOOD_PASSWORD);
        waitAndFindElement(By.id("loginform:submita")).click();
        waitAndFindElement(By.id("loginLabel"));

    }

    protected static void signOut() {
        waitAndFindElement(By.id("authTopForm:logoutButton")).click();
        waitAndFindElement(By.id("loginform:login"));

    }

    protected static boolean isElementExist(By by) {

        return browser.findElements(by).size() > 0;
    }

    protected static WebElement waitAndFindElement(By by) {
        int timeout = 30;

        while (timeout != 0) {
            if (isElementExist(by)) {
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

    protected static boolean waitForPage(String search_name_page) {
        int timeout = 30;

        while (timeout != 0) {
            String name_page = waitAndFindElement(By.id("contentForm:templateTitleId")).getText();
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


        public static void ognivoDluznicy() {
            waitAndFindElement(By.id("menu-group-applicationmenuognivo")).click();
            waitAndFindElement(By.linkText("Dłużnicy")).click();
            waitForPage("Dłużnicy");
        }

        public static void ognivoCentralnaInformacja() {
            waitAndFindElement(By.id("menu-group-applicationmenuognivo")).click();
            waitAndFindElement(By.linkText("Centralna informacja")).click();
            waitForPage("Centralna informacja");
        }

        public static void ognivoEzajecia() {
            System.out.println("login e-zajecia");

        }

    }
}
