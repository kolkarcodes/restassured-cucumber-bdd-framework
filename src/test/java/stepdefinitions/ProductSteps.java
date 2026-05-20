package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

@Epic("E-Commerce API")
@Feature("Product API")

public class ProductSteps {
    Response response;

    @Story("View List of Products ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify products are listed successfully")

    @When("user sends GET request for product list")
    public void user_sends_product_list_api_endpoint() {
        response = RestAssured
                .given()
                .when()
                .get("/products");
        response.prettyPrint();
        CommonSteps.response = response;
    }
    //common share


    @Given("response should contain products")
    public void response_should_contain_products() {
        int productCount = response.jsonPath().getList("data").size();
        Assert.assertTrue(productCount > 0);
    }

}
