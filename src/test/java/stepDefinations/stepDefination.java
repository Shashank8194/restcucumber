package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class stepDefination {

    Response response;

    @Given("^I want to execute openweathermap API$")
    public void i_want_to_execute_openweathermap_api() throws Throwable {
         response = given().
                param("id", "2172797").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().get("https://samples.openweathermap.org/data/2.5/weather");



    }

    @When("^User want to check the Response Code is 200$")
    public void user_want_to_check_the_Response_code_is_200() throws Throwable {

        Integer resp = response.getStatusCode();
        if (resp == 200) {
            System.out.println("API is working" + resp);

        } else {
            System.out.println("API is not working fine" + resp);
        }
    }

    @Then("^User should be able to see the Weather Details$")
    public void user_should_be_able_to_see_the_weather_details() throws Throwable {
        System.out.println(response);
        System.out.println(response.asString());
    }

    @And("^User should be able to see the Weather Description$")
    public void user_should_be_able_to_see_the_weather_description() throws Throwable {
        String reportID=response.
                then().
                contentType(ContentType.JSON)
                .extract()
                .path("weather[0].description");
        System.out.println("Output from Extraction is " +reportID);
    }
}
