package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestCoBaseURL {

    protected RequestSpecification specification;

    // BASE URL ====>>> https://gorest.co.in/public/v2
    @Before
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/public/v2").
                build();

    }

}
