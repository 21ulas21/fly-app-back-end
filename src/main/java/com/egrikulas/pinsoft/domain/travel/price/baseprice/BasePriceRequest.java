package com.egrikulas.pinsoft.domain.travel.price.baseprice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasePriceRequest {

    @JsonProperty("amount")
    private final double amount;
    @JsonProperty("currency")
    private final String currency;

    public BasePriceDto toDto(){
        return BasePriceDto.builder()
                .amount(amount)
                .currency(currency)
                .build();
    }
}
