package piswib.login;

import static org.assertj.core.api.Assertions.*;

import static piswib.Repository.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import piswib.BaseSeleniumPiswib;

public class LoginTest extends BaseSeleniumPiswib {

    LoginPage login_page =PageFactory.initElements(browser, LoginPage.class);

    @BeforeClass
    public void setUpTest() {
    }


    @Test
    public void badLoginTest() {
        login_page.sendIncorrectLogin();
        login_page.sendCorrectPassword();
        login_page.submit();
        assertThat(login_page.messageErrorText()).isEqualTo(MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void badPasswordTest() {
        login_page.sendCorrectLogin();
        login_page.sendIncorrectPassword();
        login_page.submit();
        assertThat(login_page.messageErrorText()).isEqualTo(MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void goodLoginTest() {
        login_page.sendCorrectLogin();
        login_page.sendCorrectPassword();
        login_page.submit();
        assertThat(login_page.loginLabelText()).isEqualTo(GOOD_LOGIN);
    }

    @AfterClass
    public void tearDownClass() {
        browser.manage().deleteAllCookies();
    }

}
