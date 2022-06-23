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
public class AddressData {

    private String street;
    private Integer houseNumber;
    private Integer houseBuilding;
    private String houseLetter;
    private Integer flat;
    private String city;
    private String postalCode;
}
