package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class ProductSteps {
    Response response;

    @Given("user sets product list API endpoint")
    public void user_sets_product_list_api_endpoint() {
        RestAssured.baseURI = "https://api.practicesoftwaretesting.com";
    }

    @When("user sends GET request for product list")
    public void user_sends_product_list_api_endpoint() {
        response = RestAssured.given()
                .when()
                .get("/products");
        response.prettyPrint();
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be_200OK(Integer statusCode) {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Given("response should contain products")
    public void response_should_contain_products() {
        int productCount = response.jsonPath().getList("data").size();
        System.out.println("Total products: " + productCount);
        Assert.assertTrue(productCount > 0);
    }

}
