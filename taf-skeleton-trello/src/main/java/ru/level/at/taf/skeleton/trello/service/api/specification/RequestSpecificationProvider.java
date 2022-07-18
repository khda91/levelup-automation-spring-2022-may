package ru.level.at.taf.skeleton.trello.service.api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.level.at.taf.skeleton.trello.configuration.ApiApplicationConfig;
import ru.level.at.taf.skeleton.trello.configuration.provider.ConfigProvider;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestSpecificationProvider {

    private static final ApiApplicationConfig API_APPLICATION_CONFIG = ConfigProvider.getApiApplicationConfig();

    public static RequestSpecification defaultSpecification() {
        return new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .setBaseUri(API_APPLICATION_CONFIG.url())
            .addQueryParams(Map.of("key", API_APPLICATION_CONFIG.key(),
                "token", API_APPLICATION_CONFIG.token()))
            .build();
    }
}
