package ru.levelp.at.lesson0809.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PersonData {

    private String id;
    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;

    @JsonProperty("identity")
    private IdentityData identityData;

    @JsonProperty("address")
    private AddressData addressData;
}
