package com.egrikulas.pinsoft.domain.destination.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirPortMain {
    @JsonProperty("ports")
    public List<AirPortRequest> requests;

}
