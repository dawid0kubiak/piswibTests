package piswib.ognivo.debtors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import piswib.BaseSignIn;

public class DebtorsPage extends BaseSignIn {

    protected WebElement templateTitleId() {

        return waitAndFindElement(By.id("contentForm:templateTitleId"));
    }
}
