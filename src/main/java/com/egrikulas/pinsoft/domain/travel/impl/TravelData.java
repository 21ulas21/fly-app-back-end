package com.egrikulas.pinsoft.domain.travel.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelData {

    @JsonProperty("departureLegs")
    List<TravelRequest> departureLegs;

    @JsonProperty("returnLegs")
    List<TravelRequest> returnLegs;


}
