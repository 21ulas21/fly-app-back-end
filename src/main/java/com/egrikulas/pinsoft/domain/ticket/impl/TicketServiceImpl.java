package com.egrikulas.pinsoft.domain.ticket.impl;

import com.egrikulas.pinsoft.domain.security.user.impl.UserServiceImpl;
import com.egrikulas.pinsoft.domain.ticket.api.TicketDto;
import com.egrikulas.pinsoft.domain.ticket.api.TicketService;
import com.egrikulas.pinsoft.domain.travel.impl.TravelServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TravelServiceImpl travelService;
    private final TicketRepository repository;
    private final UserServiceImpl userService;
    @Override
    public TicketDto createTicket(TicketDto dto) {
        var ticket = repository.save(toEntity(new Ticket(), dto));
        return toDto(ticket);

    }

    @Override
    public void deleteTicket(String ticketId) {
       Ticket ticket = repository.findById(ticketId).orElseThrow(EntityNotFoundException::new);
        repository.delete(ticket);
    }

    @Override
    public List<TicketDto> getAllTicketByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user  = userService.getUserEntityByEmail(authentication.getName());
        return repository.findByUser(user).stream().map(this::toDto).toList();
    }

    @Override
    public TicketDto getTicketById(String ticketId) {
        return repository.findById(ticketId).map(this::toDto).orElseThrow(EntityNotFoundException::new);
    }

    public Ticket toEntity(Ticket ticket, TicketDto dto){
        ticket.setInsurance(dto.getInsurance());
        ticket.setLuggage(dto.getLuggage());
        ticket.setTravel(travelService.getTravelEntityById(dto.getTravelDto().getId()));
        ticket.setUser(userService.getUserEntityById(dto.getUserDto().getId()));
        return ticket;
    }

    public TicketDto toDto(Ticket ticket){
        return TicketDto.builder()
                .travelDto(travelService.toDto(ticket.getTravel()))
                .userDto(userService.toDto(ticket.getUser()))
                .luggage(ticket.getLuggage())
                .insurance(ticket.getInsurance())
                .build();
    }


}
