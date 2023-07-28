package com.egrikulas.pinsoft.domain.destination.api;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirPortDto {

    private final String code;
    private final String explanation;
    private final String explanationOnly;
    private final String codeOnly;
}
