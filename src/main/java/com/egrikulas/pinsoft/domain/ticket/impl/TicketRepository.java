package com.egrikulas.pinsoft.domain.ticket.impl;

import com.egrikulas.pinsoft.domain.security.user.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, String> {

    List<Ticket> findByUser(User user);

}
