package piswib.login;

import static piswib.Repository.*;

public abstract class LoginActions extends LoginPage {

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
