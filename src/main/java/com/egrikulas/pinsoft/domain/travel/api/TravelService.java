package com.egrikulas.pinsoft.domain.travel.api;

import java.util.List;

public interface TravelService {

    List<TravelDto> create(List<TravelDto> request);
    List<TravelDto> getAll();
    List<TravelDto> getTravelReturn();

    List<TravelDto> getTravelDeparture();
}
