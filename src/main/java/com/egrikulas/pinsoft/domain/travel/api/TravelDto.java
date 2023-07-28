package com.egrikulas.pinsoft.domain.travel.api;

import com.egrikulas.pinsoft.domain.destination.api.AirPortDto;
import com.egrikulas.pinsoft.domain.travel.price.passengerprices.PassengerPriceDto;
import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class TravelDto {

    private String id;
    private long leqId;
    private String flightNo;
    private String airlineCode;
    private String airline;
    private String depTime;
    private String arrTime;
    private String flightId;
    private AirPortDto depPort;
    private AirPortDto arrPort;
    private String flightDate;
    private String via;
    private PriceDetailDto priceDetailDto;
    private List<PassengerPriceDto> passengerPricesDto;



}
