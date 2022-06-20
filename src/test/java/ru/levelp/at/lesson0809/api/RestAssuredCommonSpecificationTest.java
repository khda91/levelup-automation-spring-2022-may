package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RestAssuredCommonSpecificationTest {

    private static final String BASE_URL = "http://localhost:8080/srv-person-profile";

    private RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = BASE_URL;
    }

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            // .setAuth(new BasicAuthScheme().)
            .setContentType(ContentType.JSON)
            .build();
    }

    @Test
    void addMessengerTest() {
        given()
            .pathParams("messengerId", "TELEGRAM")
            .spec(requestSpecification)
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .spec(duplicationErrorResponseSpecification());
        //            .body("type", equalTo("validation"))
        //            .body("title", equalTo("Bad Request"))
        //            .body("status", equalTo("400"));
    }

    @Test
    void addSocialNetworkTest() {
        given()
            .pathParams("socialNetworkId", "LINKED_IN")
            .spec(requestSpecification)
            .when()
            .put("/social-networks/{socialNetworkId}")
            .then()
            .spec(duplicationErrorResponseSpecification());
    }

    private ResponseSpecification duplicationErrorResponseSpecification() {
        return new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(400)
            .expectBody("type", equalTo("validation"))
            .expectBody("title", equalTo("Bad Request"))
            .expectBody("status", equalTo("400"))
            .build();
    }
}
