package postRequest;

import baseURLs.GoRestCoBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import testData.GoRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends GoRestCoBaseURL {

        /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */

    @Test
    public void post02(){

        //Set Base URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath","users");


        //Step 2: Set Expected and Request Body
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String,String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("Drake F Clarusway SDET","male",
                "drakeff@clarusway.commmmm","active");

        System.out.println("reqBodyAndExpectedDataMap: " + reqBodyAndExpectedDataMap);


        //Step 3: Send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBodyAndExpectedDataMap).
                when().
                header("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").
                post("/{usersPath}");


        System.out.println("Response Body: " );
        response.prettyPrint();


        //Step 4: Assertion

        //Pojo kullanrak assert ediniz.

        GoRestCoApiPojo actualDataResponseBody = response.as(GoRestCoApiPojo.class);
        assertEquals(actualDataResponseBody.getName(), reqBodyAndExpectedDataMap.get("name"));
        assertEquals(actualDataResponseBody.getGender(), reqBodyAndExpectedDataMap.get("gender"));
        assertEquals(actualDataResponseBody.getEmail(), reqBodyAndExpectedDataMap.get("email"));
        assertEquals(actualDataResponseBody.getStatus(), reqBodyAndExpectedDataMap.get("status"));






    }




}
