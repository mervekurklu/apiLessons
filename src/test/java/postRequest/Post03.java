package postRequest;

import baseURLs.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiExPojo;
import pojoDatas.DummyRestApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends DummyRestApiBaseURL {


          /*

    Given

        //http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",

    },
    "message": "Successfully! Record has been added."
}

   */


    @Test
    public void post03(){

        //Step1: Set URL
        //http://dummy.restapiexample.com/api/v1/create

        specification.pathParam("createPath","create");


        //Set Expected and Req. Body

        /*
            {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
         */
        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo("Drake F.","40000","28");

        /*
         {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",

    },
    "message": "Successfully! Record has been added."
}
         */

        DummyRestApiExPojo dummyResTApiExPojo = new DummyRestApiExPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");



        //Step 3: Send a request

        //Basic Auth.  ---> kullanılaak.
        // Dokumanda suth istemiyor fakat biz örnek olsun diye nasıl kukllanıalcğaını öğrenmek amaçlı olarak basic auth. ile işlem yapacağız.

        // ---> Bearer token     Header da vermiştik.
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                body(dummyRestApiPojo).
                when().
                post("/{createPath}");

        System.out.println("Response:  ");
        response.prettyPrint();


        //Step 4: Assertion İşlemi:

        DummyRestApiExPojo actualData = response.as(DummyRestApiExPojo.class);  //POJO
        System.out.println("Actual Data: " + actualData);

        assertEquals(dummyResTApiExPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyResTApiExPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyResTApiExPojo.getData().getSalary(),actualData.getData().getSalary());

        /*-
        assertEquals(dummyResTApiExPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyResTApiExPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyResTApiExPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyResTApiExPojo.getData().getName(),actualData.getData().getName());
        assertEquals(dummyResTApiExPojo.getData().getSalary(),actualData.getData().getSalary());

         */










    }


}
