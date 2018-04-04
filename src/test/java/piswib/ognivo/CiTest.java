package piswib.ognivo;

import org.testng.Assert;
import org.testng.annotations.*;
import piswib.ognivo.pages.DebtorsActions;

public class CiTest extends DebtorsActions {

    @Test
    public void view_page() {
        Menu.ognivo_centralna_informacja();

        Assert.assertEquals(templateTitleId().getText(), "Centralna informacja");
    }
}
