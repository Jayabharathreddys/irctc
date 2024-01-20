package com.jb.irctc.irctc.rest;

import com.jb.irctc.irctc.bindings.PassengerInfo;
import com.jb.irctc.irctc.bindings.TicketInfo;
import com.jb.irctc.irctc.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TicketRestController {

    private final TicketService ticketService;

    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo p){
        TicketInfo t = ticketService.bookTicket(p);
        return  new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @GetMapping("/tickets")
    ResponseEntity<Collection<TicketInfo>> getTickets(){
        Collection<TicketInfo> t = ticketService.getTickets();
        return  new ResponseEntity<>(t, HttpStatus.OK);
    }
}
