package piswib.pages.login;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piswib.BaseSeleniumPiswib;

import static piswib.Repository.*;

public class LoginPage extends BaseSeleniumPiswib {
    @FindBy(id = "loginform:login")
    private static WebElement login;

    @FindBy(id = "loginform:password")
    private static WebElement password;

    @FindBy(id = "loginform:submita")
    private static WebElement submit;

    @FindBy(className = "ui-messages-error-summary")
    private static WebElement messageError;


    //    Actions

    public void sendCorrectLogin() {
        login.clear();
        login.sendKeys(GOOD_LOGIN);
    }

    public void sendCorrectPassword() {
        password.clear();
        password.sendKeys(GOOD_PASSWORD);
    }

    public void sendIncorrectLogin() {
        login.clear();
        login.sendKeys(BAD_LOGIN);
    }

    public void sendIncorrectPassword() {
        password.clear();
        password.sendKeys(BAD_PASSWORD);
    }

    public String messageErrorText() {

        return messageError.getText();
    }

    public void submit() {

        submit.click();
    }
}
