package piswib.login.pages;

import static piswib.Repository.*;

public class LoginActions extends LoginPage {

    protected void send_correct_login() {
        login().clear();
        login().sendKeys(GOOD_LOGIN);
    }

    protected void send_incorrect_login() {
        login().clear();
        login().sendKeys(BAD_LOGIN);
    }

    protected void send_correct_password() {
        password().clear();
        password().sendKeys(GOOD_PASSWORD);
    }

    protected void send_incorrect_password() {
        password().clear();
        password().sendKeys(BAD_PASSWORD);
    }
}
