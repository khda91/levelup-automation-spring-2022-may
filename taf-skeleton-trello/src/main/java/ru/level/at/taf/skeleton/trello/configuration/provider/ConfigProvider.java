package ru.level.at.taf.skeleton.trello.configuration.provider;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;
import ru.level.at.taf.skeleton.trello.configuration.ApiApplicationConfig;
import ru.level.at.taf.skeleton.trello.configuration.UiApplicationConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigProvider {

    private static UiApplicationConfig uiApplicationConfig;
    private static ApiApplicationConfig apiApplicationConfig;

    static {
        final var envPropertyValue = System.getProperty("env");
        if (envPropertyValue == null) {
            System.setProperty("env", "prod");
        }
    }

    public static UiApplicationConfig getUiApplicationConfig() {
        if (uiApplicationConfig == null) {
            uiApplicationConfig = ConfigCache.getOrCreate(UiApplicationConfig.class);
        }
        return uiApplicationConfig;
    }

    public static ApiApplicationConfig getApiApplicationConfig() {
        if (apiApplicationConfig == null) {
            apiApplicationConfig = ConfigCache.getOrCreate(ApiApplicationConfig.class);
        }
        return apiApplicationConfig;
    }
}
