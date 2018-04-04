package piswib.ognivo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import piswib.BaseSignIn;

public class DebtorsPage extends BaseSignIn {

    protected WebElement templateTitleId() {
        return wait_and_find_element(By.id("contentForm:templateTitleId"));
    }
}
