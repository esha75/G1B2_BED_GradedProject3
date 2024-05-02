package com.assignment.TicketTrackerApplication.TicketTrackerApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.TicketTrackerApplication.TicketTrackerApplication.entity.Ticket;
import com.assignment.TicketTrackerApplication.TicketTrackerApplication.service.TicketServiceImpl;

@Controller
public class TicketController {
	
	@Autowired
	TicketServiceImpl ticketService;
	
	@GetMapping("/tickets")
	public String tickets(Model model) {
		List<Ticket> tickets = ticketService.findAllTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}
	
	@GetMapping("/tickets/newTicket")
	public String newTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	
	@PostMapping("/tickets")
	public String saveEmployee(@ModelAttribute("tickets") Ticket t1) {
		ticketService.createTicket(t1);
		return "redirect:/tickets";
		
	}
	
	@GetMapping("/tickets/{ticketId}/edit")
	public String editEmployeeForm(@PathVariable long ticketId , Model model)
	{	
		Ticket ticketdb= ticketService.findTickerById(ticketId);
		model.addAttribute("ticket",ticketdb);
		return "edit_ticket";
		
	}
	
	@PostMapping("/tickets/{ticketId}")
	public String updateEmployee(@PathVariable long ticketId, @ModelAttribute("ticket") Ticket newvalue) 
	{	
		Ticket ticketdb =ticketService.findTickerById(ticketId);
		ticketdb.setTicketTitle(newvalue.getTicketTitle());
		ticketdb.setShortdescription(newvalue.getShortdescription());
		ticketdb.setTicketContent(newvalue.getTicketContent());
		ticketService.updateTicket(ticketdb);
		return "redirect:/tickets";
			
	}
	
	@GetMapping("/tickets/{ticketId}/delete")

	public String deleteTicket(@PathVariable("ticketId") Long ticketId) {
		ticketService.deleteTicket(ticketId);
		return "redirect:/tickets";
	}
	
	@GetMapping("/ticket/{ticketId}/view")
	public String viewPost(@PathVariable("ticketId") long ticketId, Model model) {
		Ticket ticket = ticketService.findTickerById(ticketId);
		model.addAttribute("ticket",ticket);
		return "/view_ticket";
	}
	
	@GetMapping("/tickets/search")
	public String searchTickets(@RequestParam(value="query") String query, Model model) {
		
		List<Ticket> tickets = ticketService.searchTickets(query);
		model.addAttribute("tickets", tickets);
		return "/tickets";
		
	}

}
