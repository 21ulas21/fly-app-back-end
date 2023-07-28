package com.egrikulas.pinsoft.domain.security.user.impl;

import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = User.TABLE)
public class User extends AbstractEntity {
    public static final String TABLE="t_user";
    private static final String COL_FULL_NAME ="full-name";
    private static final String COL_EMAIL="email";
    private static final String COL_PASSWORD="password";
    private static final String COL_PHONE="phone";
    private static final String COL_GENDER="gender";
    private static final String COL_DATE_OF_BIRTH="date-of-birth";
    private static final String COL_CITIZEN="citizen";
    private static final String COL_INDENTIFICATION_NUMBER="indentification-number";
    private static final String COL_COUNTRY="country";
    private static final String COL_CITY="city";

    @Column(name = COL_FULL_NAME)
    private String fullName;
    @Column(name = COL_EMAIL,nullable = false,unique = true)
    private String email;
    @Column(name = COL_PASSWORD,nullable = false)
    private String password;
    @Column(name = COL_PHONE)
    private String phone;
    @Column(name = COL_GENDER)
    private String gender;
    @Column(name = COL_DATE_OF_BIRTH)
    private String dateOfBirth;
    @Column(name = COL_CITIZEN)
    private String citizen;
    @Column(name = COL_INDENTIFICATION_NUMBER)
    private String indentificationNumber;
    @Column(name = COL_COUNTRY)
    private String country;
    @Column(name = COL_CITY)
    private String city;





}
