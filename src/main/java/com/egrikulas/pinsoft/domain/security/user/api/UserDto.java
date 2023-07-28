package com.egrikulas.pinsoft.domain.security.user.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
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

}
