package ru.levelp.at.lesson1011.cicd.api.model;

import java.util.List;
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
public class PersonMessengerListResponse {

    private List<PersonMessengerData> data;
    private ListResponseMetaData meta;
}