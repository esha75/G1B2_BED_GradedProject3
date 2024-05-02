package com.assignment.TicketTrackerApplication.TicketTrackerApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.TicketTrackerApplication.TicketTrackerApplication.entity.Ticket;
import com.assignment.TicketTrackerApplication.TicketTrackerApplication.repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository ticketRepository ;

	
	public List<Ticket> findAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
		
	}

	@Override
	public Ticket findTickerById(Long ticketId) {
		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return  ticketRepository.save(ticket) ;
	}

	@Override
	public void deleteTicket(Long ticketId) {
		ticketRepository.deleteById(ticketId);
		
	}


	
	@Override
	public List<Ticket> searchTickets(String query) {
		List<Ticket> tickets = ticketRepository.searchTickets(query);
		return tickets.stream()
				.collect(Collectors.toList());
	}
}
