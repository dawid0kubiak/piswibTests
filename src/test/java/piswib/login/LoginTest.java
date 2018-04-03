package piswib.login;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import piswib.login.pages.LoginActions;


public class LoginTest extends LoginActions {

    @BeforeClass
    public void setUpClass() {
        browser.get("");
    }

    @Test
    public void bad_login_test() {
        // given
        send_incorrect_login();
        send_correct_password();

        // when
        submit().click();

        // then
        Assert.assertEquals(message_error().getText(), "Zły login lub hasło.");
    }

    @Test
    public void bad_password_test() {
        // given
        send_correct_login();
        send_incorrect_password();

        // when
        submit().click();

        // then
        Assert.assertEquals(message_error().getText(), "Zły login lub hasło.");
    }

    @Test
    public void good_login_test() {
        // given
        send_correct_login();
        send_correct_password();

        // when
        submit().click();

        // then
        Assert.assertEquals(login_label().getText(), "admin");
    }

    @AfterClass
    public void tearDownClass() {
        browser.quit();
    }
}
