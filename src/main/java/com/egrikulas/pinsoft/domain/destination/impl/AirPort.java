package com.egrikulas.pinsoft.domain.destination.impl;

import com.egrikulas.pinsoft.library.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = AirPort.TABLE)
public class AirPort extends AbstractEntity {

    public static final String TABLE = "air-port";
    public static final String COL_CODE="code";
    public static final String COL_EXPLANATION="explanation";
    public static final String COL_EXPLANATION_ONLY="explanation-only";
    public static final String COL_CODE_ONLY="code-only";

    @Column(name = COL_CODE)
    private String code;
    @Column(name = COL_EXPLANATION)
    private String explanation;
    @Column(name = COL_EXPLANATION_ONLY)
    private String explanationOnly;
    @Column(name = COL_CODE_ONLY)
    private String codeOnly;


}
