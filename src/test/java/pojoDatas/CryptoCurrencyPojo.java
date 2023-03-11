package pojoDatas;

public class CryptoCurrencyPojo {

    /*
     {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",  //merch.code
        "first_name":"",
        "last_name":"",
        "email":"drakeF@gmail.com"
    }
}
     */
    private String cryptocurrency;
    private CustomerInfoPojo customer;

    public CryptoCurrencyPojo() {
    }

    public CryptoCurrencyPojo(String cryptocurrency, CustomerInfoPojo customer) {
        this.cryptocurrency = cryptocurrency;
        this.customer = customer;
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public CustomerInfoPojo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoPojo customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CryptoCurrencyPojo{" +
                "cryptocurrency='" + cryptocurrency + '\'' +
                ", customer=" + customer +
                '}';
    }
}
