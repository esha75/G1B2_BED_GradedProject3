package com.assignment.TicketTrackerApplication.TicketTrackerApplication.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment.TicketTrackerApplication.TicketTrackerApplication.entity.Ticket;


@Repository
public interface TicketService {
	List<Ticket> findAllTickets();
	
	Ticket createTicket(Ticket ticket);
	
	Ticket findTickerById(Long ticketId);
	
	Ticket updateTicket(Ticket ticket);
	
	void deleteTicket(Long ticketId);
	
	List<Ticket> searchTickets(String query);
}
