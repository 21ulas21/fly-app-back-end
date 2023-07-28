package com.egrikulas.pinsoft.domain.travel.price.passengerprices;

import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerPricesRequest {

    @JsonProperty("type")
    private String type;
    @JsonProperty("priceDetail")
    private PriceDetailRequest priceDetailRequest;
    @JsonProperty("totalPriceDetail")
    private PriceDetailRequest totalPriceDetailRequest;

    public PassengerPriceDto toDto(){

      return PassengerPriceDto.builder()
              .type(type)
              .priceDetailDto(priceDetailRequest.toDto())
              .totalPriceDetailDto(totalPriceDetailRequest.toDto())
              .build();


    }



}
