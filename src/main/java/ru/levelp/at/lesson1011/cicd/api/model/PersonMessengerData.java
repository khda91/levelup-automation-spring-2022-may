package ru.levelp.at.lesson1011.cicd.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonMessengerData {

    private String id;
    private String personId;
    private String messengerId;
    private String nickname;
}
