package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {




    /*
        Bizler bu zamana kadar sizler ile birlikte POSTMAN üzerinde farklı doc. sahip olan
        çeşitli API lere request attık.
        REq atarken HTTP methodların da GET, POST; PUT, PATCH and DELETE methoslarınınkullandık.



        Bizler markete genle olarak POSTMAN i bir otomasyon toolu olarak değil manule test tool u olarka
        kullanıyoruz. Fakat dersler de işlediğimiz üsere PSTAMN ile test otomasyonu yapabiliyoruz.

        API testlerimiz bundan sonra REstAssured Lib. kullanrak yapacğaız.


        TEST leri yapabiliyor olmak içn sizlerin bir doc. ihtiyacı vardır.
        Biz test eng. bu doc. göre API leri nasıl kullanacağımız veya nasıl test edeceğimizi öğreniriz.

        Ve doc. lara göre çeşitli seneryoalr oluşturabiliriz. Tıpkı ne gibi?
        Selenium Web UI teslteri koştuğumuz gibi.

        Test Case:

         --> Expected Result  // TEST CASE   Seneayodan alacğaım


         ---> Actual Result      ====>>>>> Response dan alacağım.


        Gherkin Lang.

            Given ---> testin yapılabilmesi için ön hazırlık/ön şart
            When ---> Action --> Gerçekleştirilecek Eylemler
            Then ---> Assertion için kullanıyoruz
            And  ---> Öncesinde kullanılan keyword u etkisinin hala devame titğini bizlere gösterir.

     */

/*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */



    @Test   // -> it is like it main method
    public void get01(){

        /*
        4 tane adımımız vardır.

        1)URL i tanımlamam lazım. URL i set etmem lazım

        2)Expected data ları tanımlamam lazım. Expected dataları set etmem lazım
        Expected datalar TEST CASE den alınır. Doc. dan alınır (Şu an için bu step ignore edilecektir.)

        3)Request Gönder.  Postman de ki SEND butonu


        4)Assertion İşlemi
         */

        // Step 1: URL i set ediniz. (https://restful-booker.herokuapp.com/booking/7)
        String URL = "https://restful-booker.herokuapp.com/booking/7";


        // Step 2: Expected dataları set et. (Ignore edilmiştir.)



        //Step 3: Request Gönder.
        //Kullanıcı GET Methodu ile Request Gönderir


        Response response = given().
                when().
                get(URL);

        System.out.println("RESPONSE: ");
        response.prettyPrint(); //prettyPrint()  syso gibidir.



        // Step 4:  Asertion İşlemleri
        /*
         Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
         */

        //Test 1: status code ,===> 200

        response.then().assertThat().statusCode(200); // Doc. TestCase den alınmıştır.

        //Test 2: Content Type

        response.then().assertThat().contentType("application/json");

        response.then().assertThat().contentType(ContentType.JSON);

        //Test 3: Status Line

        response.then().assertThat().statusLine("HTTP/1.1 200 OK");


        //Status Code u konsola nasıl yazdırabiliriz?

        System.out.println("Status Code: " + response.getStatusCode());

        // Contetnt Type ı konsola nasıl yazdırabilirim?
        System.out.println("Content Type: " + response.getContentType());

        //Status Line ı nasıl yazdırabilrim

        System.out.println("Status Line: " + response.getStatusLine());
        //REsponse Time ı nasıl yazdırabilirim

        System.out.println("Response Time: " + response.getTime());

        //Headers ları konsola nasıl yazdıarbilriim?

        System.out.println("Headers: " + response.getHeaders());








    }


}
