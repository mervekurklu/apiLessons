package getRequest;

import baseURLs.GoRestCoBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends GoRestCoBaseURL {

    /*

    Base URL Spec olarak kullanılmaldıır.

        Given
            https://gorest.co.in/public/v2/todos/14071
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
"id": 14071,
"user_id": 592752,
"title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
"due_on": "2023-03-20T00:00:00.000+05:30",
"status": "pending"
}
 */

    @Test
    public void get06(){

        // Step 1: Set URL
        // https://gorest.co.in/public/v2/todos/14071
        specification.pathParams("todosPath","todos",
                "idPath","14071");

        // Step 2: Set Expected Dat (ignored)


        //Step 3: Send Request

        Response response = given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");


        response.prettyPrint(); // like syso


        // Step 4: assertion

        // 1.Way

        /*
         Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
"id": 14071,
"user_id": 592752,
"title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
"due_on": "2023-03-20T00:00:00.000+05:30",
"status": "pending"
}
         */

        /*

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("user_id",equalTo(592752),
                        "title",equalTo("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet."),
                        "due_on",equalTo("2023-03-20T00:00:00.000+05:30"),
                        "status",equalTo("pending"));

                        */






        // 2.Way: JsonPath   --> JsonPath bbir clastır ve Json objeler içerisinde navigate etmemize olanak sağlar.
        JsonPath jsonPath = response.jsonPath();
        assertEquals(592752,jsonPath.getInt("user_id"));
        assertEquals("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",jsonPath.getString("title"));
        assertEquals("2023-03-20T00:00:00.000+05:30",jsonPath.getString("due_on"));
        assertEquals("pending",jsonPath.getString("status"));


       /*
       Expected Data: TEST CASE -- Doc. --- TEst Scen.
       Actual Data:::  RESPONSE
        */





    }


}
