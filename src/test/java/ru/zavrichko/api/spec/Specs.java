package ru.zavrichko.api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static ru.zavrichko.api.helpers.CustomAllureListener.withCustomTemplates;


public class Specs {
    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri("https://petstore.swagger.io")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
