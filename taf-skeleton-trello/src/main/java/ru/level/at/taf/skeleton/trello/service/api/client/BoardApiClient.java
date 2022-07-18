package ru.level.at.taf.skeleton.trello.service.api.client;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import ru.level.at.taf.skeleton.trello.service.api.specification.RequestSpecificationProvider;

public class BoardApiClient {

    private static final String VERSION_ENDPOINT = "/1";
    private static final String BOARDS_ENDPOINT = VERSION_ENDPOINT + "/boards";
    private static final String BOARD_ENDPOINT = VERSION_ENDPOINT + "/boards/{id}";

    public String create(final String boardName) {
        return given()
            .spec(RequestSpecificationProvider.defaultSpecification())
            .queryParam("name", boardName)
            .when()
            .post(BOARDS_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .jsonPath()
            .getString("id");
    }

    public void delete(final String id) {
        given()
            .spec(RequestSpecificationProvider.defaultSpecification())
            .pathParams("id", id)
            .when()
            .delete(BOARD_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
