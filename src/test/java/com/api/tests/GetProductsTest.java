package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProductsTest {

    @Test
    public void getAllProducts() {
        Response response = RestAssured
                .given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .when()
                .get("/products");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);

    }
}
