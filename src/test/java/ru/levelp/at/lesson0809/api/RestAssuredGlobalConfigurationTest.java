package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.security.SecureRandom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestAssuredGlobalConfigurationTest {

    private static final String BASE_URL = "http://localhost";
    private static final Integer PORT = 8080;
    private static final String SERVICE_BASE_PATH = "/srv-person-profile";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    //    @BeforeSuite
    //    public void beforeSuite() {
    //        RestAssured.baseURI = BASE_URL;
    //    }

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
        given()
            // .spec(requestSpecification)
            .body(getPersonBodyRequest())
            .when()
            .post(SERVICE_BASE_PATH + "/people")
            .then()
            // .spec(responseSpecification)
            .statusCode(201)
            //.body("data.id", Matchers.not(Matchers.emptyOrNullString()));
            .body("data.id", not(emptyOrNullString()));
    }

    private String getPersonBodyRequest() {
        return "{\n"
            + "  \"role\": \"LECTOR\",\n"
            + "  \"email\": \"person" + new SecureRandom().nextInt() + "@mail.ru\",\n"
            + "  \"phoneNumber\": \"+79211234567\",\n"
            + "  \"placeOfWork\": \"Engineer\",\n"
            + "  \"identity\": {\n"
            + "    \"firstName\": \"Vasily\",\n"
            + "    \"lastName\": \"Pupkin\",\n"
            + "    \"middleName\": \"Ivanovich\",\n"
            + "    \"gender\": \"MALE\",\n"
            + "    \"dateOfBirth\": \"1980-02-07\",\n"
            + "    \"placeOfBirth\": \"Moscow\",\n"
            + "    \"passport\": {\n"
            + "      \"series\": \"1234\",\n"
            + "      \"number\": \"123456\",\n"
            + "      \"placeOfIssue\": \"\",\n"
            + "      \"dateOfIssue\": \"1980-02-07\",\n"
            + "      \"departmentCode\": \"123-456\"\n"
            + "    }\n"
            + "  },\n"
            + "  \"address\": {\n"
            + "    \"street\": \"Beethovenstrasse\",\n"
            + "    \"houseNumber\": 12,\n"
            + "    \"houseBuilding\": 1,\n"
            + "    \"houseLetter\": \"A\",\n"
            + "    \"flat\": 123,\n"
            + "    \"city\": \"Moscow\",\n"
            + "    \"postalCode\": \"123456\"\n"
            + "  }\n"
            + "}";
    }
}
