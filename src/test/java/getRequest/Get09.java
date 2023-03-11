package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends JsonPlaceHolderBaseURL {

 /*

    Given
	   	     https://jsonplaceholder.typicode.com/todos/2
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Header da Server ın cloudflare olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
  {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}


     */


    @Test
    public void get09(){

        //Step 1: SET URL
        //https://jsonplaceholder.typicode.com/todos/2
        specification.pathParams("todosPath","todos",
                "idPath","2");


        //Step 2: Set Expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        HashMap<String,Object> expectedData = jsonPlaceHolderTestData.setUpDataTodos();

        System.out.println("Expected Data: " + expectedData);



        // Step 3: Send a request

        Response response = given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");

        System.out.println("Response: " );
        response.prettyPrint();


        // Step 4: Assertion


        //1. Way
        HashMap<String, Object> actualData = response.as(HashMap.class);   // De-Ser.
        System.out.println("Actual Data: " + actualData);

        assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        assertEquals(expectedData.get("StatusCode"),response.statusCode());
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));



        // HOMEWORKS:

        /*
        JsonPath + SoftAssertion
        response ile hard assertion   --->> response.then().assertThat()
         */








    }



}
