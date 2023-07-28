package com.egrikulas.pinsoft.domain.travel.price.pricedetail;

import com.egrikulas.pinsoft.domain.travel.price.baseprice.BasePriceRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDetailRequest {
    @JsonProperty("basePrice")
    private final BasePriceRequest basePriceRequest;
    @JsonProperty("totalTax")
    private final BasePriceRequest totalTaxRequest;
    @JsonProperty("surcharge")
    private final BasePriceRequest surchargeRequest;
    @JsonProperty("salesPrice")
    private final BasePriceRequest salesPriceRequest;


    public PriceDetailDto toDto(){
        return PriceDetailDto.builder()
                .basePriceDto(basePriceRequest.toDto())
                .salesPriceDto(salesPriceRequest.toDto())
                .surchargeDto(surchargeRequest.toDto())
                .totalTaxDto(totalTaxRequest.toDto())
                .build();
    }


}
