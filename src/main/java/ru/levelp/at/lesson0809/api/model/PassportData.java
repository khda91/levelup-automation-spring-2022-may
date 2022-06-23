package ru.levelp.at.lesson0809.api.model;

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
public class PassportData {

    private String series;
    private String number;
    private String placeOfIssue;
    private String dateOfIssue;
    private String departmentCode;
}
