package com.egrikulas.pinsoft.domain.travel.price.pricedetail;

import com.egrikulas.pinsoft.domain.travel.price.baseprice.BasePriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceDetailService {

    private final PriceDetailRepository repository;
    private final BasePriceService basePriceService;


    public PriceDetail create(PriceDetailDto dto){
        return repository.save(toEntity(new PriceDetail(), dto));
    }



    public PriceDetail toEntity(PriceDetail priceDetail, PriceDetailDto dto){
        priceDetail.setBasePrice(basePriceService.create(dto.getBasePriceDto()));
        priceDetail.setSalesPrice(basePriceService.create(dto.getSalesPriceDto()));
        priceDetail.setSurcharge(basePriceService.create(dto.getSurchargeDto()));
        priceDetail.setTotalTax(basePriceService.create(dto.getTotalTaxDto()));
        return priceDetail;
    }
    public PriceDetailDto toDto(PriceDetail priceDetail) {
        return PriceDetailDto.builder()
                .totalTaxDto(basePriceService.toDto(priceDetail.getTotalTax()))
                .surchargeDto(basePriceService.toDto(priceDetail.getSurcharge()))
                .salesPriceDto(basePriceService.toDto(priceDetail.getSalesPrice()))
                .basePriceDto(basePriceService.toDto(priceDetail.getBasePrice()))
                .build();
    }


}
