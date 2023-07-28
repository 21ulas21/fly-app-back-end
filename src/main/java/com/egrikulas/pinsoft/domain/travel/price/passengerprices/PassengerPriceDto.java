package com.egrikulas.pinsoft.domain.travel.price.passengerprices;


import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerPriceDto {

    private String type;
    private PriceDetailDto priceDetailDto;
    private PriceDetailDto totalPriceDetailDto;


}
