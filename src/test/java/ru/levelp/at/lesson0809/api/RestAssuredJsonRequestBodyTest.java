package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestAssuredJsonRequestBodyTest {

    private static final String BASE_URL = "http://localhost";
    private static final Integer PORT = 8080;
    private static final String SERVICE_BASE_PATH = "/srv-person-profile";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;
        RestAssured.basePath = SERVICE_BASE_PATH;
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    public void createPersonTest() {
        List<String> jsonList = new ArrayList<>();
        try {
            jsonList = Files.readLines(new File(this
                .getClass()
                .getResource("/ru/levelp/at/lesson0809/api/CreatePersonRequestBody.json")
                .getPath()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String json = String.join("\n", jsonList);
        json = json.replace("{role}", "STUDENT")
                   .replace("{email}", new Faker().internet().emailAddress());

        given()
            // .spec(requestSpecification)
            .body(json)
            .when()
            .post(SERVICE_BASE_PATH + "/people")
            .then()
            // .spec(responseSpecification)
            .statusCode(201)
            //.body("data.id", Matchers.not(Matchers.emptyOrNullString()));
            .body("data.id", not(emptyOrNullString()));
    }
}
