package piswib.ognivo;

import org.testng.Assert;
import org.testng.annotations.*;
import piswib.ognivo.pages.DebtorsActions;

public class DebtorsTest extends DebtorsActions {


    @Test
    public void viewPage() {
        Menu.ognivoDluznicy();

        Assert.assertEquals(templateTitleId().getText(), "Dłużnicy");
    }

}
