package testData;

public class TmdbApiTestData {

    private String apiKey = "f18268445e963752bc9bf440be7b057a";

    public String getApiKey() {
        return apiKey;
    }

    public void setGetApiKey(String getApiKey) {
        this.apiKey = getApiKey;
    }


    public String formatted(String a){
        String b = String.format("{%s}",a);
        return b;
    }
}
