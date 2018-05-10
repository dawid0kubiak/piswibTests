package piswib.ognivo;

import org.testng.Assert;
import org.testng.annotations.*;
import piswib.ognivo.debtors.DebtorsActions;

public class CiTest extends DebtorsActions {

    @Test
    public void viewPage() {
        Menu.ognivoCentralnaInformacja();

        Assert.assertEquals(templateTitleId().getText(), "Centralna informacja");
    }
}
