package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

@Epic("E-Commerce API")
@Feature("SearchProduct API")
public class SearchProductSteps {
    Response response;

    @Story("Search Product By Keyword")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify products are returned successfully using search keyword")

    @When("user searches product with keyword {string}")
    public void user_searches_product_with_keyword(String keyword) {
        response = RestAssured
                .given()
                .queryParam("q", keyword)
                .when()
                .get("/products/search");
        response.prettyPrint();
        CommonSteps.response = response;
    }

    @Given("response should contain searched product {string}")
    public void response_should_contain_searched_product(String keyword) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(keyword));
    }

}
