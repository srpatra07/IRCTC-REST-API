package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.request.Passenger;
import com.org.response.Ticket;
import com.org.services.BookingServiceImpl;

@RestController
public class BookingRestController {
	
	@Autowired
	BookingServiceImpl service;

	@PostMapping(value="/ticket", consumes = {"application/json"}, produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger)
	{
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/ticket/{ticketNum}", produces = "application/json")
	public Ticket getTicket(@PathVariable Integer ticketNum)
	{
		Ticket ticket = service.getTicket(ticketNum);
		return ticket;
	}
	
}
