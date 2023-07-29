package com.egrikulas.pinsoft.domain.travel.impl;

import com.egrikulas.pinsoft.domain.destination.impl.AirPortServiceImpl;
import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelService;
import com.egrikulas.pinsoft.domain.travel.price.passengerprices.PassengerPriceService;
import com.egrikulas.pinsoft.domain.travel.price.pricedetail.PriceDetailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final TravelRepository repository;

    private final AirPortServiceImpl airPortService;
    private final PassengerPriceService passengerPriceService;
    private final PriceDetailService priceDetailService;

    public List<TravelDto> create(List<TravelDto> request){
      return request.stream()
                .map(req -> toEntity(new Travel(), req))
                .map(repository::save)
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<TravelDto> getAll() {
       return repository.findAll().stream().map(this::toDto).toList();
    }

    public List<TravelDto> getTravelDeparture(){
       return repository
               .findAll()
               .stream()
               .filter(p -> p.getArrPort().getCode().equals("AYT"))
               .map(this::toDto).toList();
    }
    public List<TravelDto> getTravelReturn(){
        return repository
                .findAll()
                .stream()
                .filter(p -> p.getArrPort().getCode().equals("DUS"))
                .map(this::toDto).toList();
    }


    public Travel getTravelEntityById(String id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public Travel toEntity(Travel travel, TravelDto dto){
        travel.setLeqId(dto.getLeqId());
        travel.setFlightNo(dto.getFlightNo());
        travel.setAirline(dto.getAirline());
        travel.setAirlineCode(dto.getAirlineCode());
        travel.setDepTime(dto.getDepTime());
        travel.setArrTime(dto.getArrTime());
        travel.setFlightId(dto.getFlightId());
        travel.setFlightDate(dto.getFlightDate());
        travel.setVia(dto.getVia());
        travel.setDepPort(airPortService.getAirportByCode(dto.getDepPort().getCode()));
        travel.setArrPort(airPortService.getAirportByCode(dto.getArrPort().getCode()));
        travel.setPassengerPrices(passengerPriceService.createPassengers(dto.getPassengerPricesDto()));
        travel.setPriceDetail(priceDetailService.create(dto.getPriceDetailDto()));
        return travel;
    }
    public TravelDto toDto(Travel travel){
        return TravelDto.builder()
                .id(travel.getId())
                .leqId(travel.getLeqId())
                .flightNo(travel.getFlightNo())
                .airlineCode(travel.getAirlineCode())
                .airline(travel.getAirline())
                .depTime(travel.getDepTime())
                .arrTime(travel.getArrTime())
                .flightId(travel.getFlightId())
                .depPort(airPortService.toDto(travel.getDepPort()))
                .arrPort(airPortService.toDto(travel.getArrPort()))
                .flightDate(travel.getFlightDate())
                .via(travel.getVia())
                .priceDetailDto(priceDetailService.toDto(travel.getPriceDetail()))
                .passengerPricesDto(travel.getPassengerPrices().stream().map(passengerPriceService::toDto).toList())
                .build();
    }



}
