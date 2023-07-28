package com.egrikulas.pinsoft.domain.ticket.api;

import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    private Boolean insurance;
    private Double luggage;
    private UserDto userDto;
    private TravelDto travelDto;



}
