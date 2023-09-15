package com.example.appwebsenai.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ContaViewTest {

    @Test
    public void testCriacaoContaWithError() {
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON).
                when().post("/conta?name=antonio&type=pato")
                .then().statusCode(404);
    }

    @Test
    public void testCriacaoConta() {
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON).
                when().post("/criaconta?name=antonio&type=pato").then().
                body("error", equalTo("Tipo da Conta não suporta"));
    }
}
