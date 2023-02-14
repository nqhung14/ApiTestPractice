
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Test_02 {
    public static String URL = "https://internal.dv2arch.pd.aws-ca-central-1.faultless.ca/device-groups-webapp/internal/devicegroupnodes/searchfilters";
    public static String headerKey1 = "accountUid";
    public static String headerValue1 = "ab890a59-31d3-4862-b9c4-a4f9dbc9ca96";
    public static String headerKey2 = "deviceGroupNodes";
    public static String headerValue2 = "all_active_devices,fee5d2c0-9d72-462a-96db-cc814e732d25";

    public static Map<String, String> headers = new HashMap<>();

    static {
        headers.put(headerKey1, headerValue1);
        headers.put(headerKey2, headerValue2);
    }

    @Test
    public void test_01(){
        testMethod.getAPI1(URL, headers);
    }
}
