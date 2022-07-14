package ru.levelp.at.lesson13.bdd.userbugred.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {

    private final String username;
    private final String email;
    private final String password;
}
