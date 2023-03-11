package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        strict = true,
        plugin = {
                "pretty", //Steplerimi konsolda görebilmek için
        },


        //path of feature
        features = "src/test/resources/tmdb.feature",

        //path of step definitons
        glue = "tmdbApi",
        tags = "@tmdbApi",
        dryRun = false

)


public class RunnerTmdb {
}

