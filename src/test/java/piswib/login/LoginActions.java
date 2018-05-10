package piswib.login.pages;

import static piswib.Repository.*;

public class LoginActions extends LoginPage {

    protected void sendCorrectLogin() {
        login().clear();
        login().sendKeys(GOOD_LOGIN);
    }

    protected void sendIncorrectLogin() {
        login().clear();
        login().sendKeys(BAD_LOGIN);
    }

    protected void sendCorrectPassword() {
        password().clear();
        password().sendKeys(GOOD_PASSWORD);
    }

    protected void sendIncorrectPassword() {
        password().clear();
        password().sendKeys(BAD_PASSWORD);
    }
}
