package testData;

import java.util.HashMap;
import java.util.Map;

public class BitPaceGetToken {



    /*
       {
    "merchant_code":"20625123425",
    "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
}
     */

    public Map<String,String> reqTestDataBody(){

        HashMap<String,String> reqBodyData = new HashMap<>();
        reqBodyData.put("merchant_code","20625123425");
        reqBodyData.put("password","a1a82a55-8355-46f1-9a95-3cd9adce495b");

        return reqBodyData;
    }

}
