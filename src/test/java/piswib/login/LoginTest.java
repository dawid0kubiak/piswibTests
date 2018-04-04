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
    public void badLoginTest() {
        sendIncorrectLogin();
        sendCorrectPassword();
        submit().click();
        Assert.assertEquals(messageError().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void badPasswordTest() {
        sendCorrectLogin();
        sendIncorrectPassword();
        submit().click();
        Assert.assertEquals(messageError().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test
    public void goodLoginTest() {
        sendCorrectLogin();
        sendCorrectPassword();
        submit().click();
        Assert.assertEquals(loginLabel().getText(), GOOD_LOGIN);
    }

    @AfterClass
    public void tearDownTest() {
        browser.quit();
    }

}
