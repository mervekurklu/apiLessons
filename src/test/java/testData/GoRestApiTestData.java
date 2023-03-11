package testData;

import java.util.HashMap;

public class GoRestApiTestData {


    //422
    public int statusCodeForPostInvalid(){

        return 422;
    }


    /*
     {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
     */



    public HashMap<String,String > reqBodyAndExpectedData(String name, String gender, String email, String status ){

        HashMap<String ,String > reqBodyAndExpectedDataMap = new HashMap<>();

        reqBodyAndExpectedDataMap.put("name",name);
        reqBodyAndExpectedDataMap.put("gender",gender);
        reqBodyAndExpectedDataMap.put("email",email);
        reqBodyAndExpectedDataMap.put("status",status);


        return reqBodyAndExpectedDataMap;
    }


}
