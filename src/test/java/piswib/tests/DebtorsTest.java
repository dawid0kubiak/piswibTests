package piswib.tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import piswib.BaseSeleniumPiswib;
import piswib.Utils;


public class DebtorsTest extends BaseSeleniumPiswib {

    Utils utils = new Utils(browser);

    @BeforeClass
    public void setUpTest() {
    }

    @Test
    public void viewPage() {
Reporter.log( "Message", true );
    }

}
