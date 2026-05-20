package stepdefinitions;

import io.cucumber.java.PendingException;
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
@Feature("Cart API")
public class CartSteps {
    Response response;

    @Story("user can add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify authenticated user can add product to cart successfully")

    @When("user adds product {string} with quantity {int} to cart")
    public void user_adds_product_with_quantity_to_cart(String product_id, Integer quantity) {

        Map<String, Object> requestBody =
                new HashMap<>();

        requestBody.put("product_id", product_id);
        requestBody.put("quantity", quantity);

        response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Bearer " + AuthSteps.token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/carts");
        response.prettyPrint();
        CommonSteps.response = response;
    }

    @Then("response should contain cart id")
    public void response_should_contain_cart_id() {
        String cartId = response.jsonPath().getString("id");
        Assert.assertNotNull(cartId);
    }

}
