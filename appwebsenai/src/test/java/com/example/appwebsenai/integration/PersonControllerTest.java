package com.example.appwebsenai.integration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PersonControllerTest {

    @Test
    public void testCadastroPessoa() {
        // Configura a base URL da sua API
        RestAssured.baseURI = "http://localhost:8080";

        // Dados para o corpo da solicitação (JSON)
        String requestBody = "{"
                + "\"nome\": \"João\","
                + "\"tipoConta\": \"corrente\""
                + "}";

        // Faz a chamada POST para cadastrar uma conta
        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/person?name=Antonio&sexo=m")
                //.getBody().asString()
                .then()
                .statusCode(200) // Verifica se a resposta tem status 201 (Created)
                .body("nome", equalTo("Antonio")); // Verifica se o atributo "nome" é igual a "João"
    }
}
