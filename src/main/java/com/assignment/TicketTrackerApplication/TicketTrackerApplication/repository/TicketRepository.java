package com.assignment.TicketTrackerApplication.TicketTrackerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.TicketTrackerApplication.TicketTrackerApplication.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
	
	@Query("SELECT p from Ticket p WHERE " +
            " p.ticketTitle LIKE CONCAT('%', :query, '%') OR " +
            " p.shortdescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);
	
}
