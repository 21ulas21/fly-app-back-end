package com.egrikulas.pinsoft.domain.travel.impl;

import com.egrikulas.pinsoft.domain.destination.api.AirPortDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import com.egrikulas.pinsoft.domain.travel.price.passengerprices.PassengerPricesRequest;
import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelRequest {
    @JsonProperty("legId")
    private long leqId;
    @JsonProperty("flightNo")
    private String flightNo;
    @JsonProperty("airlineCode")
    private String airlineCode;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("depTime")
    private String depTime;
    @JsonProperty("arrTime")
    private String arrTime;
    @JsonProperty("flightId")
    private String flightId;
    @JsonProperty("depPort")
    private String depPort;
    @JsonProperty("arrPort")
    private String arrPort;
    @JsonProperty("flightDate")
    private String flightDate;
    @JsonProperty("via")
    private String via;
   @JsonProperty("priceDetail")
    private PriceDetailRequest priceDetailRequest;

    @JsonProperty("passengerPrices")
   private List<PassengerPricesRequest> passengerPricesRequests;

    public TravelDto toDto(){
        var passengerPriceDto = passengerPricesRequests.stream().map(PassengerPricesRequest::toDto).toList();

       return TravelDto.builder()
                .leqId(leqId)
                .flightNo(flightNo)
                .airlineCode(airlineCode)
                .airline(airline)
                .depTime(depTime)
                .arrTime(arrTime)
                .flightId(flightId)
                .depPort(AirPortDto.builder().code(depPort).build())
                .arrPort(AirPortDto.builder().code(arrPort).build())
                .flightDate(flightDate)
                .via(via)
                .priceDetailDto(priceDetailRequest.toDto())
                .passengerPricesDto(passengerPriceDto)
                .build();


    }




}
