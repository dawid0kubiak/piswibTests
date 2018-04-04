package piswib;

import org.testng.annotations.*;

public abstract class BaseSignIn extends BaseSeleniumPiswib {

    @BeforeTest
    public void setUpTest() {

        browser.get(Repository.PISWIB_URL);
        sign_in();
    }

    @AfterTest
    public void tearDownTest() {
        browser.quit();
    }
}
