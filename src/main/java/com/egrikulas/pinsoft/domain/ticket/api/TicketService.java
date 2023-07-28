package com.egrikulas.pinsoft.domain.ticket.api;

import java.util.List;

public interface TicketService {


    TicketDto createTicket(TicketDto dto);

    void deleteTicket(String ticketId);

    List<TicketDto> getAllTicketByUser();

    TicketDto getTicketById(String ticketId);






}
