package ru.levelp.at.lesson1011.cicd.api.service;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Map;
import ru.levelp.at.lesson1011.cicd.api.model.CreatePersonRequestData;
import ru.levelp.at.lesson1011.cicd.api.model.PersonMessengerListResponse;

public class PeopleClient {

    private static final String SERVICE_BASE_PATH = "/srv-person-profile";
    private static final String PEOPLE = SERVICE_BASE_PATH + "/people";
    private static final String PERSON = PEOPLE + "/{personId}";
    private static final String PERSON_MESSENGERS = PERSON + "/messengers";

    public Response getPeople(Map<String, Object> queryParams) {
        return given()
            .queryParams(queryParams)
            .when()
            .get(PEOPLE)
            .thenReturn();
    }

    public Response createPerson(CreatePersonRequestData requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(PEOPLE)
            .thenReturn();
    }

    public Response getPersonMessengers(String personId, Map<String, Object> queryParams) {
        return given()
            .pathParams("personId", personId)
            .queryParams(queryParams)
            .when()
            .get(PERSON_MESSENGERS)
            .thenReturn();
    }

    public PersonMessengerListResponse getPersonMessengersResponse(String personId, Map<String, Object> queryParams) {
        return given()
            .pathParams("personId", personId)
            .queryParams(queryParams)
            .when()
            .get(PERSON_MESSENGERS)
            .then()
            .statusCode(200)
            .extract()
            .as(PersonMessengerListResponse.class);
    }
}
