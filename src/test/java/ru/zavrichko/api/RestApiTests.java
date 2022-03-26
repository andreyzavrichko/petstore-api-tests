package ru.zavrichko.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class RestApiTests {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    void findByStatusAvailableTest() {
        given()
                .when()
                .params("status", "available")
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    void findByStatusPendingTest() {
        given()
                .when()
                .params("status", "pending")
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    void findByStatusSoldTest() {
        given()
                .when()
                .params("status", "sold")
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    void findByStatusNullTest() {
        given()
                .when()
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("id", hasSize(0));
    }



    @Test
    void petIdTest() {
        given()
                .when()
                .get("/v2/pet/9223372016854934000")
                .then()
                .statusCode(200)
                .body("id", is(9223372016854934000L))
                .body("name", is("doggie"));
    }

    @Test
    void inventoryTest() {
        given()
                .when()
                .get("/v2/store/inventory")
                .then()
                .statusCode(200)
                .body("sold", is(5));
    }


}
