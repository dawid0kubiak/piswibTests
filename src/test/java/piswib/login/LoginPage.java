package piswib.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import piswib.BaseSeleniumPiswib;

public abstract class LoginPage extends BaseSeleniumPiswib {

    protected WebElement login() {
        return waitAndFindElement(By.id("loginform:login"));
    }

    protected WebElement password() {

        return waitAndFindElement(By.id("loginform:password"));
    }

    protected WebElement submit() {

        return waitAndFindElement(By.id("loginform:submita"));
    }

    protected WebElement messageError() {

        return waitAndFindElement(By.className("ui-messages-error-summary"));
    }

    protected WebElement loginLabel() {

        return waitAndFindElement(By.id("loginLabel"));
    }

}
