package piswib.login.pages;

public class LoginActions extends LoginPage {

    protected void send_correct_login() {
        login().clear();
        login().sendKeys("admin");
    }

    protected void send_incorrect_login() {
        login().clear();
        login().sendKeys("admin1");
    }

    protected void send_correct_password() {
        password().clear();
        password().sendKeys("admin");
    }

    protected void send_incorrect_password() {
        password().clear();
        password().sendKeys("admin1");
    }
}
