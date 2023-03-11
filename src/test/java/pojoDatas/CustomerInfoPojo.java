package pojoDatas;

public class CustomerInfoPojo {

    /*
     "customer": {
        "reference_id": "20625123425",  //merch.code
        "first_name":"",
        "last_name":"",
        "email":"drakeF@gmail.com"
    }
     */

    private String reference_id;
    private String first_name;
    private String last_name;
    private String email;

    public CustomerInfoPojo() {
    }

    public CustomerInfoPojo(String reference_id, String first_name, String last_name, String email) {
        this.reference_id = reference_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerInfoPojo{" +
                "reference_id='" + reference_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
