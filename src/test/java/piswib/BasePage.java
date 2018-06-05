package piswib;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


public abstract class BasePage {

    protected boolean isExist(int size){
        if(size > 0){
            return true;
        }
        return false;
    }

    protected void assertThatIsEqualTo(Object actual, Object expected, String testlink_external_id) {
        try {
            assertThat(actual).isEqualTo(expected);
            set_status_testlink(testlink_external_id, true);
        } catch (AssertionError e) {
            set_status_testlink(testlink_external_id, false);
            throw e;
        }
    }

    private void set_status_testlink(String external_id, boolean status) {




System.out.println(System.getenv());
System.out.println(!System.getenv("LOGNAME").contains("d"));
        if(!System.getenv("LOGNAME").contains("d")){return;}
        String url = "http://192.168.2.52/testlink193/lib/api/xmlrpc.php";
        String dev_key = System.getenv("TESTLINK_KEY");
        ExecutionStatus execution_status;
        TestLinkAPI api = null;
        if (status) {
            execution_status = ExecutionStatus.PASSED;
        } else {
            execution_status = ExecutionStatus.FAILED;
        }

        try {
            api = new TestLinkAPI(new URL(url), dev_key);
        } catch (MalformedURLException e) {
            System.err.println("Brak dostępu do adresu: " + url);
        }
        TestPlan test_plan = api.getTestPlanByName("Ścieżki krytyczne", "PI SWIB");
        TestCase caseTest = api.getTestCaseByExternalId(external_id, 1);

        Build build = api.getLatestBuildForTestPlan(test_plan.getId());

        api.setTestCaseExecutionResult(caseTest.getId(), null, test_plan.getId(), execution_status,
                build.getId(), build.getName(), null, true, null, null, null, null, false);

    }

}
