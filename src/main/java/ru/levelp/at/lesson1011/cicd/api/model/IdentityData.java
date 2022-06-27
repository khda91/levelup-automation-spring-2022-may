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
public class IdentityData {

    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String dateOfBirth;
    private String placeOfBirth;
    private PassportData passport;
}
