package piswib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import piswib.logged.HomePage;
import piswib.login.LoginPage;

import static piswib.Repository.GOOD_LOGIN;

public class Utils {
    private WebDriver browser;
    private LoginPage login_page = PageFactory.initElements(browser, LoginPage.class);
    private HomePage home_page =PageFactory.initElements(browser, HomePage.class);

    public Utils(WebDriver browser) {
        this.browser = browser;
    }

    public boolean signIn() {
        login_page.sendCorrectLogin();
        login_page.sendCorrectPassword();
        login_page.submit();
        return home_page.loginLabelText().contains(GOOD_LOGIN);
    }

}
