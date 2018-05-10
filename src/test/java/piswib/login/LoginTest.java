package piswib.login;

import org.testng.Assert;
import org.testng.annotations.*;
import static piswib.Repository.*;


public class LoginTest extends LoginActions {


    @BeforeClass
    public void setUpTest() {

        browser.get(PISWIB_URL);
    }


    @Test(priority=1)
    public void badLoginTest() {
        sendIncorrectLogin();
        sendCorrectPassword();
        submit().click();
        Assert.assertEquals(messageError().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test(priority=2)
    public void badPasswordTest() {
        sendCorrectLogin();
        sendIncorrectPassword();
        submit().click();
        Assert.assertEquals(messageError().getText(), MESSAGE_ERROR_LOGIN);
    }

    @Test(priority=3)
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
