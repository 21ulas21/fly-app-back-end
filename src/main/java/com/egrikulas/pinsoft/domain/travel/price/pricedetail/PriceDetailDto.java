package com.egrikulas.pinsoft.domain.travel.price.pricedetail;

import com.egrikulas.pinsoft.domain.travel.price.baseprice.BasePriceDto;
import com.egrikulas.pinsoft.domain.travel.price.baseprice.BasePriceRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDetailDto {


    private BasePriceDto basePriceDto;

    private BasePriceDto totalTaxDto;

    private BasePriceDto surchargeDto;

    private BasePriceDto salesPriceDto;
}
