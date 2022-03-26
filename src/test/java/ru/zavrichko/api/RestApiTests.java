package ru.zavrichko.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.zavrichko.api.model.User;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.zavrichko.api.spec.Specs.request;
import static ru.zavrichko.api.spec.Specs.responseSpec;

public class RestApiTests {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    void findByStatusAvailableTest() {
        given()
                .spec(request)
                .when()
                .params("status", "available")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(responseSpec)
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

    @Test
    void getUserNoValidTest() {
        given()
                .when()
                .get("/v2/user/1")
                .then()
                .statusCode(404)
                .body("message", is("User not found"));
    }

    @Test
    void logoutTest() {
        given()
                .when()
                .get("/v2/user/logout")
                .then()
                .statusCode(200)
                .body("message", is("ok"));
    }

    @Test
    void singleUserWithLombokModel() {

        User data = given()
                .contentType(JSON)

                .when()
                .post("/user")
                .then()
                .statusCode(201)
                .extract().as(User.class);

        assertEquals(2, data.getId());
    }


}
