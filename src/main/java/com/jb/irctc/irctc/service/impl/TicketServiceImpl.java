package com.jb.irctc.irctc.service.impl;

import com.jb.irctc.irctc.bindings.PassengerInfo;
import com.jb.irctc.irctc.bindings.TicketInfo;
import com.jb.irctc.irctc.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {
    Map<Integer, TicketInfo> map = new HashMap<>();
    @Override
    public TicketInfo bookTicket(PassengerInfo passengerInfo) {
        TicketInfo t = new TicketInfo();
        BeanUtils.copyProperties(passengerInfo, t);
        Random rand = new Random();
        int id = rand.nextInt(10) + 1;
        t.setTicketNum(id);
        t.setStatus("CONFIRMED");
        map.put(id, t);
        return t;
    }

    @Override
    public Collection<TicketInfo> getTickets() {
        return map.values();
    }
}
