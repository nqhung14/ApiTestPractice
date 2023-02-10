import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.Map;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class testMethod {

    public static void getBodyOfRequestWithHeader(String headerKey, String valueOfKey, String URL) {
        given().header(headerKey, valueOfKey)
                .when().get(URL)
                .then().log().body();
    }

    public static void getSpecificValueOfResponse(String baseURI, String resourceOfAPI, String headerKey, String valueOfKey) {
        RestAssured.baseURI = baseURI;
        String resource = resourceOfAPI;
        Header myHeaders = new Header(headerKey, valueOfKey);

        Response response = RestAssured.given()
                .header(myHeaders)
                .get(resourceOfAPI)
                .then()
                .extract().response();

        System.out.println(response.getBody().asString());

        //Cach 1: lay id theo index
//        String getID = response.getBody().asString();
//        JsonPath jsonPath = new JsonPath(getID);
//        List<Object> items = jsonPath.getList("id");
//        Object indexOfId = items.get(0);
//        System.out.println(indexOfId.toString());

        //Cach 2: lay id theo index
        String id = response.jsonPath().getString("[2].id");
        System.out.println("ID is: " + id);
    }

    public static void verifyStatusCode(String baseURI, String headerKey, String valueOfKey, String resourceOfAPI, int statusCode) {
        RestAssured.baseURI = baseURI;
        Response response = RestAssured.given()
                .header(headerKey, valueOfKey)
                .get(resourceOfAPI)
                .then()
                .extract().response();
//        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(), statusCode);
        System.out.println("Status code is: " + response.statusCode());
    }


//    public static void getByURL(String URL, String headerOfParam, String valueOfParam, String headerKey, String valueOfHeader ) {
//        String baseURL = URL+"?"+headerOfParam+"="+valueOfParam;
//        RestAssured.baseURI = baseURL;
//
//        Header myHeader = new Header(headerKey, valueOfHeader);
//
//        Response response = RestAssured.given()
//                .header(myHeader)
//                .then()
//                .extract().response();
//    }

    public static void sendGetApi(String url, List<Header> headers, List<Map<String, String>> params) {
        //deviceUi=....
        //actionUid=....
    }


    public static void getAPI(String baseURI,Map<String, String> headers) {
        RestAssured.baseURI = baseURI;
        Response response = RestAssured.given()
                .headers(headers)
                .get()
                .then()
                .extract().response();

        System.out.println(response.getBody().asString());

    }
}
