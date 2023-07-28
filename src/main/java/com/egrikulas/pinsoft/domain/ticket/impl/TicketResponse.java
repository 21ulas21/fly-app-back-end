package com.egrikulas.pinsoft.domain.ticket.impl;

import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.ticket.api.TicketDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {

    private Boolean insurance;
    private Double luggage;
    private UserDto userDto;
    private TravelDto travelDto;

    public static TicketResponse fromDto(TicketDto dto){
        return TicketResponse.builder()
                .insurance(dto.getInsurance())
                .luggage(dto.getLuggage())
                .userDto(dto.getUserDto())
                .travelDto(dto.getTravelDto())
                .build();

    }


}
