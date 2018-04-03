package piswib.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import piswib.BaseSeleniumPiswib;

public class LoginPage extends BaseSeleniumPiswib {

    protected WebElement login() {
        return wait_and_find_element(By.id("loginform:login"));
    }

    protected WebElement password() {

        return wait_and_find_element(By.id("loginform:password"));
    }

    protected WebElement submit() {

        return wait_and_find_element(By.id("loginform:submita"));
    }

    protected WebElement message_error() {

        return wait_and_find_element(By.className("ui-messages-error-summary"));
    }

    protected WebElement login_label() {

        return wait_and_find_element(By.id("loginLabel"));
    }

}
