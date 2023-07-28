package com.egrikulas.pinsoft.domain.destination.api;

import java.util.List;

public interface AirPortService {

    List<AirPortDto> saveAll(List<AirPortDto> airPortDtoList);
    List<AirPortDto> getAllAirPort();
    AirPortDto create(AirPortDto airPortDto);
    AirPortDto getAirPortById(String id);


}
