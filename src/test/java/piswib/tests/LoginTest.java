package piswib.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import piswib.BaseSeleniumPiswib;
import piswib.pages.logged.HomePage;
import piswib.pages.login.LoginPage;


public class LoginTest extends BaseSeleniumPiswib {

    LoginPage login_page;
    HomePage home_page;

    @BeforeClass
    public void setUpTest() {

        login_page = PageFactory.initElements(browser, LoginPage.class);
        home_page = PageFactory.initElements(browser, HomePage.class);
    }

    @Test
    public void isExistLoginPageTest() {
        String testlink_external_id = "SW3-545";

        login_page.checkLoginPage(testlink_external_id);
    }

    @Test
    public void badLoginTest() {
        String testlink_external_id = "SW3-546";

        login_page.sendIncorrectLogin();
        login_page.sendCorrectPassword();
        login_page.submit();

        login_page.checkMessageErrorLogin(testlink_external_id);
    }

    @Test
    public void badPasswordTest() {
        String testlink_external_id = "SW3-547";

        login_page.sendCorrectLogin();
        login_page.sendIncorrectPassword();
        login_page.submit();

        login_page.checkMessageErrorLogin(testlink_external_id);
    }

    @Test
    public void emptyLoginTest() {
        String testlink_external_id = "SW3-548";

        login_page.clearLogin();
        login_page.sendCorrectPassword();
        login_page.submit();

        login_page.checkMessageLogin(testlink_external_id);
    }

    @Test
    public void emptyPasswordTest() {
        String testlink_external_id = "SW3-549";

        login_page.sendCorrectLogin();
        login_page.clearPassword();
        login_page.submit();

        login_page.checkMessagePassword(testlink_external_id);
    }

    @Test(priority = 1)
    public void goodLoginTest() {
        String testlink_external_id = "SW3-551";

        login_page.sendCorrectLogin();
        login_page.sendCorrectPassword();
        login_page.submit();

        home_page.checkIsLoged(testlink_external_id);

    }

}
