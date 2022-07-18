package ru.level.at.taf.skeleton.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:env/${env}/ui-application.properties"})
public interface UiApplicationConfig extends Config {

    @Key("trello.url")
    String url();

    @Key("trello.wait.duration.seconds")
    Long waitDurationSeconds();

    @Key("trello.user.username")
    String username();

    @Key("trello.user.password")
    String password();

    @Key("trello.user.title")
    String title();
}
