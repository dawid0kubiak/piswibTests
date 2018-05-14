package piswib.logged;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "loginLabel")
    private static WebElement loginLabel;

    // actoins
    public String loginLabelText() {
        return loginLabel.getText();
    }
}
