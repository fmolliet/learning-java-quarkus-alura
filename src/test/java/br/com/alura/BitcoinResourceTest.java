package br.com.alura;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class BitcoinResourceTest {
    @Test
    public void testsStatusCode200(){
        RestAssured
        .given()
            .get("bitcoins")
        .then()
            .statusCode(200);
    }
}
