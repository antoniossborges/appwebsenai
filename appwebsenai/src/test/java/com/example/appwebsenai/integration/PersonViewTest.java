package com.example.appwebsenai.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PersonViewTest {

    @Test
    public void testAddPerson(){
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON)
                .when().post("/person?name=Antonio&sexo=m")
                .then().statusCode(200)
                .body("name", equalTo("Antonio"));

        given().contentType(ContentType.JSON)
                .when().get("/person?name=Antonio")
                .then().body("sexo", equalTo("m"))
                .body("id", equalTo(1));
    }

    @Test
    public void testUpdatePerson(){
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType(ContentType.JSON)
                .when().post("/person?name=Antonio&sexo=m")
                .then().statusCode(200)
                .body("name", equalTo("Antonio"));
    }
}
