package com.egrikulas.pinsoft.domain.travel.price.baseprice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasePriceService {


    private final BasePriceRepository repository;


    public BasePrice create(BasePriceDto dto){

        var baseprice = toEntity(new BasePrice(), dto);
       return repository.save(baseprice);

    }

    private BasePrice toEntity(BasePrice basePrice, BasePriceDto dto){
            basePrice.setAmount(dto.getAmount());
            basePrice.setCurrency(dto.getCurrency());
        return basePrice;
    }
    public BasePriceDto toDto(BasePrice basePrice){
        return BasePriceDto.builder()
                .id(basePrice.getId())
                .amount(basePrice.getAmount())
                .currency(basePrice.getCurrency())
                .build();
    }



}
