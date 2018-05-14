package piswib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumPiswib {

    protected static final WebDriver browser = new FirefoxDriver();

    public BaseSeleniumPiswib() {
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browser.get(Repository.PISWIB_URL);
    }

    @AfterSuite
    public void tearDownSuite(){
        browser.quit();
    }

}
