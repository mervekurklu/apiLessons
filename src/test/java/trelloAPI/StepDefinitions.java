package trelloAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.TrelloApiTestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    //token = ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC
    //apikey = f18268445e963752bc9bf440be7b057a

    public RequestSpecification specification;

    TrelloApiTestData trelloApiTestData = new TrelloApiTestData();

    public static Response response;

    public static String boardID;

    public static JsonPath jsonPath;

    public static String listID;

    public static List<String> cardsID = new ArrayList<>();

    @Given("Kullanıcı Trello icin Base URL set eder {string}")
    public void kullanıcı_Trello_icin_Base_URL_set_eder(String baseURL) {

        specification = new RequestSpecBuilder().
                setBaseUri(baseURL).
                build();
    }


    @When("Kullanıcı board create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_create_edebilmek_icin_ilgili_url_e_POST_methodu_ve_ilgili_endpointler_ile_request_atar(String idPath, String id, String boardsPath, String boards) {

        /*
        specification.pathParams("idPath",1,
                "boardsPath","boards");
        */

        //https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
        specification.pathParams(idPath,id,
                boardsPath,boards).
                queryParams("name",trelloApiTestData.getBoardName(),
                        "key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        //string ifade var ---> idPAth ve boardsPath
        //{idPath}   {boardPAth}

        String idPathFormated = String.format("{%s}",idPath);
        System.out.println("idPathFormated: " + idPathFormated); //{idPath}

        String boardsPathFormated = String.format("{%s}",boardsPath);

         response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormated +"/" +boardsPathFormated + "/");

       // post("/{idPath}/{boardsPath}")
        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();


    }
    @When("Kullanıcı board id yi alır")
    public void kullanıcı_board_id_yi_alır() {
        jsonPath = response.jsonPath();
        boardID = jsonPath.getString("id");
    }
    @Then("Kullanıcı boad un basarili bir sekilde create edildigini dogrular")
    public void kullanıcı_boad_un_basarili_bir_sekilde_create_edildigini_dogrular() {
        response.
                then().
                assertThat().
                statusCode(200);
    }

    @When("Kullanıcı list create edebilmek icin ilgili url e POST methodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_list_create_edebilmek_icin_ilgili_url_e_POST_methodu_ile_request_atar(String idPath, String id, String listsPath, String list) {

        //#https://api.trello.com/1/lists?name={name}&idBoard=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken
        specification.pathParams(idPath,id,
                listsPath,list).
                queryParams("name",trelloApiTestData.getListName(),
                        "idBoard",boardID,
                        "key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        String idPathFormated = String.format("{%s}",idPath);
        String listsPathFormated = String.format("{%s}",listsPath);


        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormated + "/" + listsPathFormated);


        System.out.println("Response Body: ");
        response.prettyPrint();

    }

    @When("Kullanıcı list id yi alir")
    public void kullanıcı_list_id_yi_alir() {
        jsonPath = response.jsonPath();
        listID = jsonPath.getString("id");
    }

    @Then("Kullanıcı listin basari ile create edidldigini verfiy eder")
    public void kullanıcı_listin_basari_ile_create_edidldigini_verfiy_eder() {
        response.
                then().
                assertThat().
                statusCode(200);
    }

    @When("Kullanıcı card ccreate edebilmek icin ilgili url e POST metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_card_ccreate_edebilmek_icin_ilgili_url_e_POST_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {

        //#"https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken"
        specification.pathParams(idPath,id,
                cardsPath,cards).
                queryParams("idList",listID,
                        "name","CwCARDS",
                        "key", trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        String idPathFormated = String.format("{%s}",idPath);
        String cardsPathFormated = String.format("{%s}",cardsPath);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormated + "/" + cardsPathFormated);


        System.out.println("RESPONSE ");
        response.prettyPrint();

    }



    @When("Kullanıcı card is yi alir")
    public void kullanıcı_card_is_yi_alir() {

        jsonPath = response.jsonPath();
        cardsID.add(jsonPath.getString("id"));
    }
    @Then("Kullanıcı vard create edildigini verify eder")
    public void kullanıcı_vard_create_edildigini_verify_eder() {
        response.
                then().
                assertThat().
                statusCode(200);
    }

    @When("Kullanıcı update islemi iicn ilgili url ePUT metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_update_islemi_iicn_ilgili_url_ePUT_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {

        //https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken
        Random random = new Random();
        int numberOfRandom = random.nextInt(cardsID.size()); //Bu metot nextInt() in içerisne verileen bir paramternin 0 ile o değer arasında random bir sayı generate eder. [0,value)

         specification.pathParams(idPath,id,
                cardsPath,cards,
                 "cardIdPath",cardsID.get(numberOfRandom)).
                 queryParams("idList",listID,
                         "name","Cw Card Update",
                         "key",trelloApiTestData.getKey(),
                         "token",trelloApiTestData.getToken());


         String idPathFormated = String.format("{%s}",idPath);
        String cardsPathFormated = String.format("{%s}",cardsPath);

         response = given().
                 spec(specification).
                 contentType(ContentType.JSON).
                 when().
                 put("/" + idPathFormated + "/" + cardsPathFormated + "/{cardIdPath}");


        System.out.println("RESPONSE ");
        response.prettyPrint();

    }




    @Then("Kullanıcı basarili bir sekilde cardlardan birini update ettigini verify eder")
    public void kullanıcı_basarili_bir_sekilde_cardlardan_birini_update_ettigini_verify_eder() {
        response.
                then().
                assertThat().
                statusCode(200);
    }

    @When("Kullanıcı delete islemi yapabilmek icin ilgili url e DELETE metodu ile request atar {string},{string},{string},{string},{int}")
    public void kullanıcı_delete_islemi_yapabilmek_icin_ilgili_url_e_DELETE_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards,
                                                                                                    Integer cardsIdGET) {

    }


    @When("Kullanıcı delete islemi yapabilmek icin ilgili url e DELETE metodu ile request atar {string},{string},{string},{string},{string},{int}")
    public void kullanıcı_delete_islemi_yapabilmek_icin_ilgili_url_e_DELETE_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards, String cardIdPath, Integer cardsIdGET) throws InterruptedException {


        //#"https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken"
        specification.pathParams(idPath,id,
                        cardsPath,cards,
                        cardIdPath,cardsID.get(cardsIdGET)).
                queryParams("key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        System.out.println("CARDS ID: " + cardsID);
        String idPathFormated = String.format("{%s}",idPath);
        String cardsPathFormated = String.format("{%s}",cardsPath);
        String cardIdPathFormated = String.format("{%s}",cardIdPath);

        Thread.sleep(5000);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/" + idPathFormated + "/" + cardsPathFormated + "/" + cardIdPathFormated);


        System.out.println("RESPONSE: ");
        response.prettyPrint();
    }

    @Then("Kullanıcı basarili bir sekilde cardalrin delete edildigini verfiy eder")
    public void kullanıcı_basarili_bir_sekilde_cardalrin_delete_edildigini_verfiy_eder() {
        response.then().assertThat().statusCode(200);
    }

    //#"https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"
    @When("Kullanıcı board delete islemi icin ilgili url e DELETE metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_delete_islemi_icin_ilgili_url_e_DELETE_metodu_ile_request_atar(String idPath, String id, String boardsPath, String boards) {

        specification.pathParams(idPath,id,
                boardsPath,boards,
                "boardIdePath",boardID).
                queryParams("key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());
        String idPathFormated = String.format("{%s}",idPath);
        String boardsPathFormated = String.format("{%s}",boardsPath);

        response = given().spec(specification).contentType(ContentType.JSON).when().delete("/" + idPathFormated + "/" + boardsPathFormated + "/{boardIdePath}");
    }




    @Then("Kullanıcı basarili bir sekilde boardun delete edildigini verfiy eder")
    public void kullanıcı_basarili_bir_sekilde_boardun_delete_edildigini_verfiy_eder() {
        response.then().assertThat().statusCode(200);
    }







}
