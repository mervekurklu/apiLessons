package tmdbApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.TmdbApiTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class StepDefinitionTmdb {

    public RequestSpecification specification;


    public static Response response;

    public static JsonPath jsonPath;
    public static JsonPath jsonPathReq;

    public static String requestToken;

    public static String sessionID;

        
        
    TmdbApiTestData tmdbApiTestData = new TmdbApiTestData();


        
        
        
        
        
    @Given("Kullanici Tmdb icin Base URL set eder {string}")
    public void kullaniciTmdbIcinBaseURLSetEder(String baseUrl) {

        specification = new RequestSpecBuilder().
                setBaseUri(baseUrl).build();

    }

    @When("Kullanici request token create edebilmek icin ilgili url e GET methodu ve ilgili endpointler ile request atar {string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciRequestTokenCreateEdebilmekIcinIlgiliUrlEGETMethoduVeIlgiliEndpointlerIleRequestAtar(String idpath, String id, String authenticiationPath, String authenticiation, String tokenPath, String token, String newPath, String neww) {

        specification.pathParams(idpath,id,authenticiationPath,authenticiation,tokenPath,token,newPath,neww).
                queryParam("api_key",tmdbApiTestData.getApiKey());




        String  idPathformatted =tmdbApiTestData.formatted(idpath);
        String autformatted =tmdbApiTestData.formatted(authenticiationPath);
        String  tokenPathformatted =tmdbApiTestData.formatted(tokenPath);
        String newPathformatted =tmdbApiTestData.formatted(newPath);




        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                get("/"+idPathformatted+"/"+autformatted+"/"+tokenPathformatted+"/"+newPathformatted);

        jsonPathReq = response.jsonPath();




    }

    @And("Kullanici request token i alır")
    public void kullaniciRequestTokenIAlır() {

        jsonPath = response.jsonPath();

        requestToken = jsonPath.getString("request_token");

        System.out.println("requestToken = " + requestToken);


    }

    @Then("Kullanici request tokenin basarili bir sekilde create edildigini dogrular")
    public void kullaniciRequestTokeninBasariliBirSekildeCreateEdildiginiDogrular() {

        response.then().assertThat().statusCode(200);

    }
    @When("Kullanici request token i approve edebilmek icin ilgili url e GET methodu ve ilgili endpointler ile request atar {string},{string}, {string},{string},{string},{string},{string},{string}")
    public void kullaniciRequestTokenIApproveEdebilmekIcinIlgiliUrlEGETMethoduVeIlgiliEndpointlerIleRequestAtar(String idPath, String id, String authenticiationPath, String authentication, String tokenPath, String token, String allowPath, String validate_with_login) {


        specification.pathParams(idPath,id,authenticiationPath,authentication,tokenPath,token,allowPath,validate_with_login).
                queryParam("api_key",tmdbApiTestData.getApiKey());



        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("username","merveyldrm");
        reqBody.put("password","mrv135");
        reqBody.put("request_token",requestToken);


        String authenticateformatted = tmdbApiTestData.formatted(authenticiationPath);
        String idformatted = tmdbApiTestData.formatted(idPath);
        String allowformatted = tmdbApiTestData.formatted(allowPath);
        String reqTokenPathformatted = tmdbApiTestData.formatted(tokenPath);

        //https://www.themoviedb.org/authenticate/dea26dc6f8ed43edbcc3097443edbb091513e9db/allow

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBody).
                when().
                post("/"+idformatted+"/"+authenticateformatted+"/"+reqTokenPathformatted+"/"+allowformatted);



    }

    @When("Kullanici session id create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar {string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciSessionIdCreateEdebilmekIcinIlgiliUrlEPOSTMethoduVeIlgiliEndpointlerIleRequestAtar(String idPath, String three, String authenticiationPath, String authentication, String sessionPath, String session, String newPath, String neww) {

        specification.pathParams(idPath,three,authenticiationPath,authentication,sessionPath,session,newPath,neww).
                queryParam("api_key",tmdbApiTestData.getApiKey());



        String idformat = tmdbApiTestData.formatted(idPath);
        String authformat = tmdbApiTestData.formatted(authenticiationPath);
        String sessionformat = tmdbApiTestData.formatted(sessionPath);
        String newformat = tmdbApiTestData.formatted(newPath);

        Map<String,String> reqBody1 = new HashMap<>();
        reqBody1.put("request_token",requestToken);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBody1).
                when().
                post("/"+idformat+"/"+authformat+"/"+sessionformat+"/"+newformat);

        System.out.println("RESPONSE ");
        response.prettyPrint();

        JsonPath jsonPath1 = response.jsonPath();
        String sessionID = jsonPath1.getString("session_id");
        System.out.println("sessionID = " + sessionID);


    }

    @And("Kullanici session id i alır")
    public void kullaniciSessionIdIAlır() {

        JsonPath jsonPath = response.jsonPath();
        String sessionID = jsonPath.getString("session_id");
        System.out.println("sessionID = " + sessionID);

    }

    @Then("Kullanici session id basarili bir sekilde create edildigini dogrular")
    public void kullaniciSessionIdBasariliBirSekildeCreateEdildiginiDogrular() {

        response.then().assertThat().statusCode(200);
    }

    @When("Kullanici oylama islemi yapabilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar {string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciOylamaIslemiYapabilmekIcinIlgiliUrlEPOSTMethoduVeIlgiliEndpointlerIleRequestAtar(String idPath, String three, String moviePath, String movie, String movieIdPath, String thirtythree, String ratingPath, String rating) {

        specification.pathParams(idPath,three,moviePath,movie,movieIdPath,thirtythree,ratingPath,rating).
                queryParams("api_key",tmdbApiTestData.getApiKey(),"session_id",sessionID);

        Map<String,Double> reqBody = new HashMap<>();

        reqBody.put("value",8.5);

        String idformat = tmdbApiTestData.formatted(idPath);
        String movieformat = tmdbApiTestData.formatted(moviePath);
        String movieIDformat = tmdbApiTestData.formatted(movieIdPath);
        String ratingformat = tmdbApiTestData.formatted(ratingPath);


        response=given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBody).
                when().
                post("/"+idformat+"/"+movieformat+"/"+movieIDformat+"/"+ratingformat);


        System.out.println("RESPONSE ");
        response.prettyPrint();

    }

    @Then("Kullanici oylama islemini basarili bir sekilde yapabildigini dogrular")
    public void kullaniciOylamaIsleminiBasariliBirSekildeYapabildiginiDogrular() {

        response.then().assertThat().statusCode(201);

    }

    @When("Kullanici filmi silebilmek icin ilgili url e DELETE methodu ve ilgili endpointler ile request atar {string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciFilmiSilebilmekIcinIlgiliUrlEDELETEMethoduVeIlgiliEndpointlerIleRequestAtar(String idPath, String three, String moviePath, String movie, String movieIdPath, String thirtythree, String ratingPath, String rating) {

        specification.pathParams(idPath,three,moviePath,movie,movieIdPath,thirtythree,ratingPath,rating).
                queryParams("api_key",tmdbApiTestData.getApiKey(),"session_id",sessionID);


        String idformat = tmdbApiTestData.formatted(idPath);
        String movieformat = tmdbApiTestData.formatted(moviePath);
        String movieIDformat = tmdbApiTestData.formatted(movieIdPath);
        String ratingformat = tmdbApiTestData.formatted(ratingPath);



        response=given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/"+idformat+"/"+movieformat+"/"+movieIDformat+"/"+ratingformat);


    }

    @Then("Kullanici silme islemini basarili bir sekilde yapabildigini dogrular")
    public void kullaniciSilmeIsleminiBasariliBirSekildeYapabildiginiDogrular() {

        response.then().assertThat().statusCode(200);

    }

        
}
        
