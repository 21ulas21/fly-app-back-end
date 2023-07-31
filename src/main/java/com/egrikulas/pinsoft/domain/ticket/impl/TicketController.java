package com.egrikulas.pinsoft.domain.ticket.impl;

import com.egrikulas.pinsoft.domain.ticket.api.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {

    private final TicketService service;

    @PostMapping("/create")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketRequest request){
        var ticket = service.createTicket(request.toDto());
        return ResponseEntity.ok(TicketResponse.fromDto(ticket));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<TicketResponse>> getAllTicketByUserId(){
        var tickets = service.getAllTicketByUser().stream().map(TicketResponse::fromDto).toList();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable(value = "id") String userId){
        service.deleteTicket(userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-ticket/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable(value = "id")String id){
        var ticket = service.getTicketById(id);
        return ResponseEntity.ok(TicketResponse.fromDto(ticket));
    }








}
