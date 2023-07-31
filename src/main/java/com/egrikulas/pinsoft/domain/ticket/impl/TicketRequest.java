package com.egrikulas.pinsoft.domain.ticket.impl;


import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.ticket.api.TicketDto;
import com.egrikulas.pinsoft.domain.travel.api.TravelDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequest {


    private Boolean insurance;
    private Double luggage;
    private String userId;
    private String travelId;


    public TicketDto toDto(){
        return TicketDto.builder()
                .insurance(true)
                .luggage(1.0)
                .userDto(UserDto.builder().id("1").build())
                .travelDto(TravelDto.builder().id(travelId).build())
                .build();
    }





}
