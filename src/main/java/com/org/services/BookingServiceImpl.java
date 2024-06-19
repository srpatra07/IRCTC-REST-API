package com.org.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.org.request.Passenger;
import com.org.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService {

	private Map<Integer, Ticket> tickets = new HashMap<>();
	private Integer ticketNum = 101;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(899.00);
		t.setTicketNum(ticketNum);
		t.setStatus("Confirmed");
		tickets.put(ticketNum, t);
		ticketNum++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {

		if (tickets.containsKey(ticketNum)) {
			return tickets.get(ticketNum);
		}

		return null;
	}

}
