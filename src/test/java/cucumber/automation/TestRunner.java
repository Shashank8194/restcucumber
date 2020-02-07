package cucumber.automation;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import stepDefinations.stepDefination;

import java.io.File;


@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinations"
        )
public class TestRunner extends AbstractTestNGCucumberTests {

    stepDefination sd= new stepDefination();


    @Test
    public void getWeatherAPI() throws Throwable {
        sd.i_want_to_execute_openweathermap_api();
        sd.user_want_to_check_the_Response_code_is_200();
        sd.user_should_be_able_to_see_the_weather_details();
        sd.user_should_be_able_to_see_the_weather_description();
    }


}
