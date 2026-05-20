package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthSteps {

    public static String token;

    @Given("user is authenticated")
    public void user_is_authenticated() {

        Map<String, String> requestBody =
                new HashMap<>();

        requestBody.put(
                "email",
                "customer3@practicesoftwaretesting.com");

        requestBody.put(
                "password",
                "pass123");

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/users/login");

        response.prettyPrint();

        token =
                response.jsonPath()
                        .getString("access_token");

        System.out.println(
                "Access Token : " + token);
    }
}


