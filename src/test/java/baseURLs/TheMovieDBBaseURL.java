package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TheMovieDBBaseURL {


    // https://api.themoviedb.org/3      ===,> BASE URL

    protected RequestSpecification specification;

    @Before
    public void setBaseURL(){

        specification = new RequestSpecBuilder().
                setBaseUri("https://api.themoviedb.org/3").
                build();
    }

}
