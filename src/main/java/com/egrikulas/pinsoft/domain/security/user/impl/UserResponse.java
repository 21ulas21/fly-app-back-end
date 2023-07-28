package com.egrikulas.pinsoft.domain.security.user.impl;

import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;
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

    public static UserResponse toResponse(UserDto dto){
        return UserResponse.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .gender(dto.getGender())
                .dateOfBirth(dto.getDateOfBirth())
                .citizen(dto.getCitizen())
                .indentificationNumber(dto.getIndentificationNumber())
                .country(dto.getCountry())
                .city(dto.getCity())
                .build();
    }
}
