package com.egrikulas.pinsoft.domain.destination.impl;

import com.egrikulas.pinsoft.domain.destination.api.AirPortDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirPortRequest {
    @JsonProperty("code")
    private final String code;
    @JsonProperty("explanation")
    private final String explanation;
    @JsonProperty("explanationOnly")
    private final String explanationOnly;
    @JsonProperty("codeOnly")
    private final String codeOnly;

    public AirPortDto toDto(){
        return AirPortDto.builder()
                .code(code)
                .explanation(explanation)
                .explanationOnly(explanationOnly)
                .codeOnly(codeOnly)
                .build();
    }
}
