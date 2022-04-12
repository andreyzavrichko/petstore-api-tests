package ru.zavrichko.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zavrichko.api.data.DataGenerator;
import ru.zavrichko.api.models.Order;
import ru.zavrichko.api.models.Pet;
import ru.zavrichko.api.models.User;
import ru.zavrichko.api.spec.Specs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class RestApiTests {

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Find by status Available")
    @Severity(SeverityLevel.NORMAL)
    void findByStatusAvailableTest() {
        given(Specs.request)
                .when()
                .params("status", "available")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Find by status Pending")
    @Severity(SeverityLevel.NORMAL)
    void findByStatusPendingTest() {
        given(Specs.request)
                .when()
                .params("status", "pending")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Find by status Sold")
    @Severity(SeverityLevel.NORMAL)
    void findByStatusSoldTest() {
        given(Specs.request)
                .when()
                .params("status", "sold")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Find by status Null")
    @Severity(SeverityLevel.NORMAL)
    void findByStatusNullTest() {
        given(Specs.request)
                .when()
                .params("status", "null")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec);
    }

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Find by pet ID")
    @Severity(SeverityLevel.NORMAL)
    void petIdTest() {
        given(Specs.request)
                .when()
                .get("/v2/pet/9223372016854934000")
                .then()
                .spec(Specs.responseSpec)
                .body("id", is(9223372016854934000L))
                .body("name", is("doggie"));
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Create User")
    @Severity(SeverityLevel.BLOCKER)
    void createUserTest() {
        User newUser = DataGenerator.getUser(8, 16, true, true, true);

        String response = given(Specs.request)
                .body(newUser)
                .when()
                .post("/v2/user")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("message");

        assertThat(response).isEqualTo(newUser.getId().toString());
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Create User with array")
    @Severity(SeverityLevel.BLOCKER)
    void createWithArrayTest() {
        User newUser = DataGenerator.getUser(8, 16, true, true, true);

        String response = given(Specs.request)
                .body(newUser)
                .when()
                .post("/v2/user/createWithArray")
                .then()
                .statusCode(500)
                .extract().path("message");

        assertThat(response).isEqualTo("something bad happened");
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Create User with list")
    @Severity(SeverityLevel.BLOCKER)
    void createWithListTest() {
        User newUser = DataGenerator.getUser(8, 16, true, true, true);

        String response = given(Specs.request)
                .body(newUser)
                .when()
                .post("/v2/user/createWithList")
                .then()
                .statusCode(500)
                .extract().path("type");

        assertThat(response).isEqualTo("unknown");
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Get User")
    @Severity(SeverityLevel.CRITICAL)
    void getUserTest() {
        given(Specs.request)
                .when()
                .get("v2/user/user564564654")
                .then()
                .spec(Specs.responseSpec)
                .body("id", is(4984564564654L));
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Get empty User")
    @Severity(SeverityLevel.TRIVIAL)
    void getEmptyUserTest() {
        given(Specs.request)
                .when()
                .get("v2/user/user55")
                .then()
                .statusCode(404)
                .body("message", is("User not found"));
    }

    @Test
    @Feature("User")
    @Story("User")
    @DisplayName("Get null User")
    @Severity(SeverityLevel.TRIVIAL)
    void getNullUserTest() {
        given(Specs.request)
                .when()
                .get("v2/user/")
                .then()
                .statusCode(405);
    }

    @Test
    @Feature("Order")
    @Story("Order")
    @DisplayName("Create Order")
    @Severity(SeverityLevel.NORMAL)
    void createOrderTest() {
        Order newOrder = DataGenerator.getOrder(8, 16, true, true, true);

        Integer response = given(Specs.request)
                .body(newOrder)
                .when()
                .post("/v2/store/order")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("id");

        assertThat(response).isEqualTo(newOrder.getId());
    }

    @Test
    @Feature("Store")
    @Story("Store")
    @DisplayName("Check Inventory")
    @Severity(SeverityLevel.NORMAL)
    void inventoryTest() {
        given(Specs.request)
                .when()
                .get("/v2/store/inventory")
                .then()
                .spec(Specs.responseSpec)
                .body("status", is(122));
    }

    @Test
    @Feature("Order")
    @Story("Order")
    @DisplayName("Find order")
    @Severity(SeverityLevel.CRITICAL)
    void findOrderTest() {
        given(Specs.request)
                .when()
                .get("/v2/store/order/2")
                .then()
                .statusCode(404)
                .body("message", is("Order not found"));
    }

    @Test
    @Feature("Pet")
    @Story("Pet")
    @DisplayName("Create pet")
    @Severity(SeverityLevel.BLOCKER)
    void createPetTest() {
        Pet newPet = DataGenerator.getPet(8, 16, true, true, true);

        Integer response = given(Specs.request)
                .body(newPet)
                .when()
                .post("/v2/pet")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("id");

        assertThat(response).isEqualTo(newPet.getId());
    }

}
