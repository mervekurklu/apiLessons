package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)  //org.codehaus.jackson.map.exc.UnrecognizedPropertyException: Unrecognized field "data" (Class pojoDatas.DummyResTApiReqPojo), not marked as ignorable
 //at [Source: java.io.StringReader@3a26ec8d; line: 3, column: 14] (through reference chain: pojoDatas.DummyResTApiReqPojo["data"])
public class DummyRestApiExPojo {



        /*
         {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}
         */


    private String status;
    private DummyRestApiPojo data;
    private String message;

    public DummyRestApiExPojo() {
    }

    public DummyRestApiExPojo(String status, DummyRestApiPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public void setData(DummyRestApiPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
