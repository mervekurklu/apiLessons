package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {


    protected RequestSpecification specification;

    // https://jsonplaceholder.typicode.com   ---->> Base URL

    @Before
    public void setUpBaseURL(){
        specification = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();
    }
}
