package piswib.pages.login;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static piswib.Repository.*;

public class LoginPage extends piswib.BasePage {
    @FindBy(id = "loginform:login")
    private WebElement login;

    @FindBy(id = "loginform:password")
    private WebElement password;

    @FindBy(id = "loginform:submita")
    private WebElement submit;

    @FindBy(className = "ui-messages-error-summary")
    private WebElement messageError;

    @FindBy(className = "ui-messages-warn-summary")
    private WebElement loginMessage;

    @FindAll({@FindBy(id = "loginform")})
    private List<WebElement> loginForm;


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

    public void clearLogin(){
        login.clear();
    }

    public void clearPassword(){
        password.clear();
    }

    public void submit() {
        submit.click();
    }

    public void checkMessageErrorLogin(String testlink_external_id){
        assertThatIsEqualTo(messageError.getText(), MESSAGE_ERROR_LOGIN, testlink_external_id);
    }

    public void checkMessageLogin(String testlink_external_id){
        assertThatIsEqualTo(loginMessage.getText(), MESSAGE_LOGIN, testlink_external_id);
    }

    public void checkMessagePassword(String testlink_external_id){
        assertThatIsEqualTo(loginMessage.getText(), MESSAGE_PASSWORD, testlink_external_id);
    }

    public void checkLoginPage(String testlink_external_id){
        assertThatIsEqualTo(super.isExist(loginForm.size()), ELEMENT_EXIST, testlink_external_id);
    }
}
