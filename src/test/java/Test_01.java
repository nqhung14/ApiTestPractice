
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test_01 {

    public static String header = "accountUid";
    public static String valueOfHeader = "56247b09-c731-412c-b72c-b15a8c2aaf18";
    public static String URL = "https://internal.dv2corp1.pd.aws-ca-central-1.faultless.ca/agent-download-webservice/v1.0/installers";
    public static String baseURI = "https://internal.dv2corp1.pd.aws-ca-central-1.faultless.ca";
    public static String resourceOfURL = "/agent-download-webservice/v1.0/installers";
    public static Map<String, String> headers = new HashMap<>();

    static {
        headers.put("accountUid", "56247b09-c731-412c-b72c-b15a8c2aaf18");
    }

    @Test
    public void getBodyOfResponse() {
        testMethod.getBodyOfRequestWithHeader(header, valueOfHeader, URL);
    }

    @Test
    public void getSpecificValue(){
        testMethod.getSpecificValueOfResponse(baseURI, resourceOfURL, header, valueOfHeader);
    }

    @Test
    public static void verifyStatusResponse200() {
        testMethod.verifyStatusCode(baseURI, header, valueOfHeader, resourceOfURL, 200);
    }

    @Test
    public static void test01(){

        testMethod.getAPI(URL, headers);
    }
    @Test
    public static void test02(){
        testMethod.getAPI1(URL, headers);
    }
}


