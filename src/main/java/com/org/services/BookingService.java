package com.org.services;

import com.org.request.Passenger;
import com.org.response.Ticket;

public interface BookingService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNum);
	
}
