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

public class RestAssuredConfigurationTest {

    private static final String BASE_URL = "http://localhost:8080/srv-person-profile";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    private ResponseSpecification deleteResponseSpecification;

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = BASE_URL;
    }

    @BeforeMethod
    public void setUp() {
        // OAuth2Scheme auth = new OAuth2Scheme();
        // auth.setAccessToken("jsdhvjkadsv");
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            // .setAuth(new BasicAuthScheme().)
            // .setAuth(auth)
            .setContentType(ContentType.JSON)
            .build();
        // .header(new Header("Authorization", "Bearer sdajvldsvadsvds"));

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

        this.deleteResponseSpecification = new ResponseSpecBuilder()
            .addResponseSpecification(responseSpecification)
            .expectStatusCode(204)
            .build();
    }

    @Test
    void getPeopleTest() {
        given() // Дано
                .spec(requestSpecification)
                .when() // Когда
                .get("/people")
                .then() // Тогда
                .spec(responseSpecification)
                .statusCode(200)
                .body("data[0].id", equalTo("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9"))
                .body("data[0].identity.passport.series", equalTo(1234))
                .body("meta.pagination.limit", equalTo(10))
                .body("meta.pagination.offset", equalTo(0))
                .body("meta.pagination.totalCount", equalTo(1));
    }

    @Test
    public void deleteMessengerTest() {
        given()
            .spec(requestSpecification)
            .pathParam("messengerId", "VIBER")
            .when()
            .delete("/messengers/{messengerId}")
            .then()
            .spec(deleteResponseSpecification);
    }
}
