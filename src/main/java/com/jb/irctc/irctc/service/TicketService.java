package com.jb.irctc.irctc.service;

import com.jb.irctc.irctc.bindings.PassengerInfo;
import com.jb.irctc.irctc.bindings.TicketInfo;

import java.util.Collection;
import java.util.List;

public interface TicketService {
    public TicketInfo bookTicket(PassengerInfo passengerInfo);
    public Collection<TicketInfo> getTickets();
}
