package stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class CommonSteps {
    public static Response response;

    @Then("response status code should be {int}")
    public void response_status_should_be(Integer statusCode) {
        Assert.assertEquals(
                response.statusCode(),
                statusCode);
    }
}
