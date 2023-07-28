package com.egrikulas.pinsoft.domain.security.user.impl;

import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private String citizen;
    private String indentificationNumber;
    private String country;
    private String city;

    public UserDto toDto(){
        return UserDto.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .phone(phone)
                .gender(gender)
                .dateOfBirth(dateOfBirth)
                .citizen(citizen)
                .indentificationNumber(indentificationNumber)
                .country(country)
                .city(city)
                .build();

    }

}
