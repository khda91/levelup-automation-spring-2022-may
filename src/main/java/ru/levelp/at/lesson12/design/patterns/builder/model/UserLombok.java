package ru.levelp.at.lesson12.design.patterns.builder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class UserLombok {

    private final String username;
    private final String email;
    private final String password;
}
