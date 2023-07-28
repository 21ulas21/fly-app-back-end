package com.egrikulas.pinsoft.domain.destination.impl;

import com.egrikulas.pinsoft.domain.destination.api.AirPortDto;
import com.egrikulas.pinsoft.domain.destination.api.AirPortService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air-ports")
@AllArgsConstructor
public class AirPortController {

    private final AirPortService service;
    @PostMapping
    public List<AirPortDto> createAll(@RequestBody AirPortMain request){
        var list = request.getRequests().stream().map(AirPortRequest::toDto).toList();
        return service.saveAll(list);
    }

    public AirPortDto create(AirPortDto airPortDto){
        return service.create(airPortDto);
    }
    @GetMapping
    public List<AirPortDto> getAllAirPort(){
       return service.getAllAirPort();
    }


}
