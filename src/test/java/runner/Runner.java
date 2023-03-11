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
        features = "src/test/resources",

        //path of step definitons
        glue = "trelloAPI",
        tags = "@trelloApi",
        dryRun = false

)


public class Runner {
}
