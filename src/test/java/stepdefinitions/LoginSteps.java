package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
@Epic("E-Commerce API")
@Feature("Login API")

public class LoginSteps {
    Response response;

    @Story("Valid user able to Login ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate valid user is able to login")
    @When("user sends login request with username {string} and password {string}")
    public void user_sends_login_request_with_username_and_password(String username, String password) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", username);
        requestBody.put("password", password);

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users/login");
        response.prettyPrint();
        CommonSteps.response = response;
    }
    // SHARE RESPONSE


    @Then("response should contain access token")
    public void response_should_contain_access_token() {
        String token = response.jsonPath().getString("access_token");
        System.out.println("Access token : " + token);
        Assert.assertNotNull(token);
    }



}
