package com.egrikulas.pinsoft.domain.travel.price.baseprice;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasePriceDto {

    private final String id;
    private final double amount;
    private final String currency;
}
