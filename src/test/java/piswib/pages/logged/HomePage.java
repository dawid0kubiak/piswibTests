package piswib.pages.logged;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import piswib.BasePage;

import java.util.List;

import static piswib.Repository.*;

public class HomePage extends BasePage {

    @FindBy(id = "loginLabel")
    private WebElement loginLabel;

    @FindAll({@FindBy(id = "loginLabel")})
    private List<WebElement> loginLabels;

    // Actions

    public String loginLabelText() {
        return loginLabel.getText();
    }

    public boolean isLoged(){
       return super.isExist(loginLabels.size());
    }

    public void checkIsLoged(String testlink_external_id) {
        assertThatIsEqualTo(isLoged(), ELEMENT_EXIST, testlink_external_id);
        assertThatIsEqualTo(loginLabelText(), GOOD_LOGIN, testlink_external_id);
    }
}
