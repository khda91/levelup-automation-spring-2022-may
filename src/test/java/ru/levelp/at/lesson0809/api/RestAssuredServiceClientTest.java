package ru.levelp.at.lesson0809.api;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Collections;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.lesson0809.api.model.CreatePersonRequestData;
import ru.levelp.at.lesson0809.api.model.PersonMessengerListResponse;
import ru.levelp.at.lesson0809.api.model.PersonResponseData;
import ru.levelp.at.lesson0809.api.service.PeopleClient;

public class RestAssuredServiceClientTest {

    private static final String BASE_URL = "http://localhost";
    private static final Integer PORT = 8080;

    private PeopleClient peopleClient;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

        peopleClient = new PeopleClient();
    }

    @Test
    public void createPersonSerializationTest() {
        var faker = new Faker();
        var personRequest = CreatePersonRequestData.builder()
                                                   .email(faker.internet().emailAddress())
                                                   .role("STUDENT")
                                                   .phoneNumber(faker.phoneNumber().phoneNumber())
                                                   .build();

        peopleClient.createPerson(personRequest)
                    .then()
                    // .spec(responseSpecification)
                    .statusCode(201)
                    //.body("data.id", Matchers.not(Matchers.emptyOrNullString()));
                    .body("data.id", not(emptyOrNullString()));
    }

    @Test
    public void createPersonDeserializationTest() {
        var faker = new Faker();
        var personRequest = CreatePersonRequestData.builder()
                                                   .email(faker.internet().emailAddress())
                                                   .role("STUDENT")
                                                   .phoneNumber(faker.phoneNumber().phoneNumber())
                                                   .build();

        PersonResponseData personResponse = peopleClient
            .createPerson(personRequest)
            .then()
            // .spec(responseSpecification)
            .statusCode(201)
            .extract()
            .as(PersonResponseData.class);

        assertNotNull(personResponse.getPersonData());

        var personData = personResponse.getPersonData();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(personData.getId());
        softAssert.assertEquals(personData.getEmail(), personRequest.getEmail());
        softAssert.assertEquals(personData.getPhoneNumber(), personRequest.getPhoneNumber());
        softAssert.assertEquals(personData.getRole(), personRequest.getRole());
        softAssert.assertAll();
    }

    @Test
    public void createPersonDeserializationSoftAssertFailTest() {
        var faker = new Faker();
        var personRequest = CreatePersonRequestData.builder()
                                                   .email(faker.internet().emailAddress())
                                                   .role("STUDENT")
                                                   .phoneNumber(faker.phoneNumber().phoneNumber())
                                                   .build();

        PersonResponseData personResponse = peopleClient
            .createPerson(personRequest)
            .then()
            // .spec(responseSpecification)
            .statusCode(201)
            .extract()
            .as(PersonResponseData.class);

        assertNotNull(personResponse.getPersonData());

        var personData = personResponse.getPersonData();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(personData.getId());
        softAssert.assertEquals(personData.getEmail() + "asas", personRequest.getEmail());
        softAssert.assertEquals(personData.getPhoneNumber() + "0099", personRequest.getPhoneNumber());
        softAssert.assertEquals(personData.getRole(), personRequest.getRole());
        softAssert.assertAll();
    }

    @Test
    public void createPersonDeserializationHardAssertFailTest() {
        var faker = new Faker();
        var personRequest = CreatePersonRequestData.builder()
                                                   .email(faker.internet().emailAddress())
                                                   .role("STUDENT")
                                                   .phoneNumber(faker.phoneNumber().phoneNumber())
                                                   .build();

        PersonResponseData personResponse = peopleClient
            .createPerson(personRequest)
            .then()
            // .spec(responseSpecification)
            .statusCode(201)
            .extract()
            .as(PersonResponseData.class);

        assertNotNull(personResponse.getPersonData());

        var personData = personResponse.getPersonData();

        assertNotNull(personData.getId());
        assertEquals(personData.getEmail() + "asas", personRequest.getEmail());
        assertEquals(personData.getPhoneNumber() + "0099", personRequest.getPhoneNumber());
        assertEquals(personData.getRole(), personRequest.getRole());
    }

    @Test
    public void getPersonMessengersTest() {
        PersonMessengerListResponse response = peopleClient
            .getPersonMessengers("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9", Collections.emptyMap())
            .then()
            .statusCode(200)
            .extract()
            .as(PersonMessengerListResponse.class);

        System.out.println("====");
        System.out.println(response);

        assertEquals(response.getData().size(), 2);
    }

    @Test
    public void getPersonMessengersResponseTest() {
        PersonMessengerListResponse response = peopleClient
            .getPersonMessengersResponse("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9", Collections.emptyMap());

        System.out.println("====");
        System.out.println(response);

        assertEquals(response.getData().size(), 2);
    }

    @Test
    public void getPersonMessengersResponseNegativeTest() {
        PersonMessengerListResponse response = peopleClient
            .getPersonMessengersResponse("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9",
                Map.of("limit", -1));

        System.out.println("====");
        System.out.println(response);

        assertEquals(response.getData().size(), 2);
    }

    @Test
    public void getPersonMessengersNegativeTest() {
        peopleClient
            .getPersonMessengers("ec9655d2-e35d-4f45-be81-7ed4abc7cdc9",
                Map.of("limit", -1))
            .then()
            .statusCode(400);
        //            .extract()
        //            .as(ProblemResponse.class);
    }
}
