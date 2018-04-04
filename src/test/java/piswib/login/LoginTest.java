package piswib.login;

import org.testng.Assert;
import org.testng.annotations.*;
import piswib.login.pages.LoginActions;
import static piswib.Repository.*;


public class LoginTest extends LoginActions {


    @BeforeClass
    public void setUpTest() {

        browser.get(PISWIB_URL);
    }


    @Test
    public void bad_login_test() {
        send_incorrect_login();
        send_correct_password();
        submit().click();
        Assert.assertEquals(message_error().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void bad_password_test() {
        send_correct_login();
        send_incorrect_password();
        submit().click();
        Assert.assertEquals(message_error().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void good_login_test() {
        send_correct_login();
        send_correct_password();
        submit().click();
        Assert.assertEquals(login_label().getText(), GOOD_LOGIN);
    }

    @AfterClass
    public void tearDownTest() {
        browser.quit();
    }

}
