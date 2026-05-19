package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleProductTest {
    @Test
    public void getSingleProduct() {
        Response response = RestAssured
                .given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .queryParam("q","Thor")
                .when()
                .get("/products/search");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
