package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class SwapiApiBaseURL {

    // BASE URL  ====>>>> https://swapi.dev/api

    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().
                setBaseUri("https://swapi.dev/api").
                build();

    }


}
