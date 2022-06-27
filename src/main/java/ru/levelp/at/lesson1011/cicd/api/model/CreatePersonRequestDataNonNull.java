package ru.levelp.at.lesson1011.cicd.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
public class CreatePersonRequestDataNonNull {

    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;
    private IdentityData identity;
    private AddressData address;
}
