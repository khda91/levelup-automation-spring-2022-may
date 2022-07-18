package ru.level.at.taf.skeleton.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:env/${env}/api-application.properties")
public interface ApiApplicationConfig extends Config {

    @Key("trello.api.url")
    String url();

    @Key("trello.api.key")
    String key();

    @Key("trello.api.token")
    String token();
}
