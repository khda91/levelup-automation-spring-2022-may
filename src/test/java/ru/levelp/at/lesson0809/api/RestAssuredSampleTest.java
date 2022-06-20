package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import java.util.Map;
import org.testng.annotations.Test;

public class RestAssuredSampleTest {

    @Test
    void getPeopleTest() {
        given()
            // .contentType("application/json")
            .contentType(ContentType.JSON)
            .when()
            .get("http://localhost:8080/srv-person-profile/people")
            .then()
            .statusCode(200)
            .body("data[0].id", equalTo("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9"))
            .body("data[0].identity.passport.series", equalTo(1234))
            .body("meta.pagination.limit", equalTo(10))
            .body("meta.pagination.offset", equalTo(0))
            .body("meta.pagination.totalCount", equalTo(1));
    }

    @Test
    void addSocialMediaToPerson() {
        given()
            .log().all()
            .pathParam("personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9")
            .body("{\n"
                + "  \"socialNetworkId\": \"VK\",\n"
                + "  \"link\": \"https://vk.com/id123456\"\n"
                + "}")
            .contentType(ContentType.JSON)
            .when()
            // .post("http://localhost:8080/srv-person-profile/people/ec9655d2-e35d-4f45-be81-7ed4abc7cdc9/social-network")
            .post("http://localhost:8080/srv-person-profile/people/{personId}/social-network")
            .then()
            .log().all()
            .statusCode(201);
    }

    @Test
    void deleteSocialMediaFromPerson() {
        given()
            .log().all()
            //            .pathParam("personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9")
            //            .pathParam("socialNetworkId", "VK")
            .pathParams(Map.of(
                "personId", "ec9655d2-e35d-4f45-be81-7ed4abc7cdc9",
                "socialNetworkId", "VK"))
            .body("{\n"
                + "  \"socialNetworkId\": \"VK\",\n"
                + "  \"link\": \"https://vk.com/id123456\"\n"
                + "}")
            .contentType(ContentType.JSON)
            .when()
            // .post("http://localhost:8080/srv-person-profile/people/ec9655d2-e35d-4f45-be81-7ed4abc7cdc9/social-network")
            .delete("http://localhost:8080/srv-person-profile/people/{personId}/social-network/{socialNetworkId}")
            .then()
            .log().all()
            .statusCode(204);
    }

    @Test
    void getPeopleWithQueryParamTest() {
        given()
            .log().all()
            .queryParams(Map.of(
                "limit", 1,
                "offset", 0
            ))
            // .contentType("application/json")
            .contentType(ContentType.JSON)
            .when()
            .get("http://localhost:8080/srv-person-profile/people")
            .then()
            .log().all()
            .statusCode(200)
            .body("data[0].id", equalTo("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9"))
            .body("data[0].identity.passport.series", equalTo(1234))
            .body("meta.pagination.limit", equalTo(1))
            .body("meta.pagination.offset", equalTo(0))
            .body("meta.pagination.totalCount", equalTo(1));
    }
}
