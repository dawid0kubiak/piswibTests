package piswib.login.pages;

public class LoginActions extends LoginPage {
    private String good_login;
    private String bad_login;
    private String good_password;
    private String bad_password;

    public LoginActions() {
        this.good_login = "admin";
        this.good_password ="admin";
        this.bad_login = "zlylogin";
        this.bad_password = "zlehaslo";
    }

    protected void send_correct_login() {
        login().clear();
        login().sendKeys(good_login);
    }

    protected void send_incorrect_login() {
        login().clear();
        login().sendKeys(bad_login);
    }

    protected void send_correct_password() {
        password().clear();
        password().sendKeys(good_password);
    }

    protected void send_incorrect_password() {
        password().clear();
        password().sendKeys(bad_password);
    }
}
