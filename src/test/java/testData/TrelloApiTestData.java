package testData;

public class TrelloApiTestData {


    //key  ---> string
    //token  --> string
    //name  ---> string

    //token = ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC
    //apikey = 7852a988d8215fe699b78a92c8aa400b
    private String key = "7852a988d8215fe699b78a92c8aa400b";
    private String token = "ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC";
    private String boardName = "Cw Board";
    private String listName = "Cw List";

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
