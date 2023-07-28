package com.egrikulas.pinsoft.domain.travel.price.passengerprices;


import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PassengerPriceService {

    private final PassengerPriceRepository repository;
    private final PriceDetailService priceDetailService;


    public List<PassengerPrice> createPassengers(List<PassengerPriceDto> dtos){
        return dtos.stream()
                .map(dto -> toEntity(new PassengerPrice(),dto))
                .map(repository::save).toList();

    }

    private PassengerPrice toEntity(PassengerPrice passengerPrice, PassengerPriceDto dto){
        passengerPrice.setPriceDetail(priceDetailService.create(dto.getPriceDetailDto()));
        passengerPrice.setTotalPriceDetail(priceDetailService.create(dto.getTotalPriceDetailDto()));
        passengerPrice.setType(dto.getType());
        return passengerPrice;
    }
    public PassengerPriceDto toDto(PassengerPrice passengerPrice){
        return PassengerPriceDto.builder()
                .type(passengerPrice.getType())
                .totalPriceDetailDto(priceDetailService.toDto(passengerPrice.getTotalPriceDetail()))
                .priceDetailDto(priceDetailService.toDto(passengerPrice.getPriceDetail()))
                .build();
    }








}
