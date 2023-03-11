package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseURL {


/*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın “quis ut nam facilis et officia qui” olduğunu verify et.,
		And
		    “completed” ın false olduğunu verify et.
		And
		    “userId” in 1 olduğunu verify et
     */


    /*
    {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
     */

    @Test
    public void get03(){

       /*
       1) Set URL
       2) Set Expected Data
       3) Send a Request
       4) Assertion
        */

    // Step 1: Set URL:  https://jsonplaceholder.typicode.com/todos/2
        specification.pathParams("todosPath","todos",
                "idPath","2");



    // Step 2: Set the Expected Data (ignored)

        /*
        Expected Data ları nasıl setleyebilirim?
         - map
         - arr  / list
         */

    //Step 3: Send Request

        Response response = given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");


        response.prettyPrint(); // like syso

    // Step 4: Assertion operations

        /*
         Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın “quis ut nam facilis et officia qui” olduğunu verify et.,
		And
		    “completed” ın false olduğunu verify et.
		And
		    “userId” in 1 olduğunu verify et
         */

        // 1. Way

        /*
        response.then().assertThat().statusCode(200).contentType("application/json");

        response.
                then().
                assertThat().
                body("title", Matchers.equalTo("quis ut nam facilis et officia qui"),
                        "completed",Matchers.equalTo(false),
                        "userId",Matchers.equalTo(1));*/


        // 2. Way
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),
                        "userId",equalTo(1));


    }
}
