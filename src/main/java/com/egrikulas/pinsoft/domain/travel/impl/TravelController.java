package com.egrikulas.pinsoft.domain.travel.impl;

import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travels")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService service;

    @PostMapping("/save-all")
    public void saveAll(@RequestBody TravelData requests){
       service.create(requests.getDepartureLegs().stream().map(TravelRequest::toDto).toList());
        service.create(requests.getReturnLegs().stream().map(TravelRequest::toDto).toList());
    }

    @GetMapping("/get-all")
    public List<TravelDto> getAll(){
    return service.getAll();
    }
    @GetMapping("/departure")
    public List<TravelDto> getTravelDeparture(){
        return service.getTravelDeparture();
    }
    @GetMapping("/return")
    public List<TravelDto> getTravelReturn(){
        return service.getTravelReturn();
    }

}
