package piswib.ognivo;

import org.testng.Assert;
import org.testng.annotations.*;
import piswib.ognivo.pages.DebtorsActions;

public class DebtorsTest extends DebtorsActions {


    @Test
    public void view_page() {
       Menu.ognivo_dluznicy();

        Assert.assertEquals(templateTitleId().getText(), "Dłużnicy");
    }

}
