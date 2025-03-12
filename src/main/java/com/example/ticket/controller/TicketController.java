package com.example.ticket.controller;

import com.example.ticket.model.entity.PostTicket;
import com.example.ticket.model.entity.Ticket;
import com.example.ticket.model.request.TicketRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    Date currentDate = new Date();
    List<Ticket> ticketList = new ArrayList<>();
//    int id = ticketList.size()+1;

//    private Ticket ticket;
//    public int idIncreasement(int i){
//        return i+1;
//    }

    public TicketController() {
        ticketList.add(new Ticket( 1,"Srey Sitharo", currentDate , "PP", "KPS", 90.5, "PAID", "AVALIABLE", 9));
        ticketList.add(new Ticket( 2,"Kheng Sovannak",currentDate, "PP", "KPS", 90.5, "PAID", "AVALIABLE", 10));
        ticketList.add(new Ticket(3, "Leng Hongmeng",currentDate, "PP", "KPS", 90.5, "PAID", "AVALIABLE", 11));
//        id++;
    }


    //DISPLAY ALL TICKET AS STRING

    @Operation(summary = "Get all tickets")
    @GetMapping
    public String displayTicketList() {
        return ticketList.toString();
    }

    @Operation(summary = "Create a new ticket")
    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket){
        if (ticketList.size() == 1 || ticketList.size() == 2 || ticketList.size() == 3){
            System.out.println("Invalid ID!!!");
            ticketList.size();
            ticketList.add(ticket);
        } else {
            ticketList.size();
            ticketList.add(ticket);
        }
        return ticket;
    }


    @Operation(summary = "Search ticket by ID")
    @GetMapping("/{ticket_id}")
    public List<Ticket> searchTicketId(@PathVariable Integer ticket_id){
        List<Ticket> searchTicket = new ArrayList<>();
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                searchTicket.add(ticket);
            } else {
//                return "ID NOT FOUND!!!";
                ticket.IdNotFound();
            }
        }
        return searchTicket;
    }

    @Operation(summary = "Search tickets by passenger name")
    @GetMapping("/search")
    public List<Ticket> searchTicketName(@RequestParam String name) {
        List<Ticket> searchTicketbyName = new ArrayList<>();
        for (Ticket ticket : ticketList){
            if (ticket.getPassengerName().toLowerCase().contains(name.toLowerCase())){
                searchTicketbyName.add(ticket);
            } else {
                ticket.NameNotFound();
            }
        }
        return searchTicketbyName;
    }


    //NEED TO MODIFY
    @Operation(summary = "Filter ticket by status and travel date")
    @GetMapping("/filter")
    public List<Ticket> filterTicket(@RequestParam String status, @RequestParam Date searchDate) {
        List<Ticket> filterTickets = new ArrayList<>();
        for (Ticket ticket : ticketList){
            if (ticket.getTicketStatus().toLowerCase().contains(status.toLowerCase()) && ticket.getTravelDate().after(searchDate)){
                filterTickets.add(ticket);
            } else {
                System.out.println("TICKET NOT FOUND!!!");
            }
        }
        return filterTickets;
    }


    @Operation(summary = "Update an existing ticket by ID")
    @PutMapping("/{ticket_id}")
    public Ticket updateTicket(@PathVariable Integer ticket_id, @RequestBody TicketRequest ticketRequest){
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                ticket.setPassengerName(ticketRequest.getPassengerName());
                ticket.setSourceStation(ticketRequest.getSourceStation());
                ticket.setDestinationStation(ticketRequest.getDestinationStation());
                ticket.setPrice(ticketRequest.getPrice());
                ticket.setPaymentStatus(ticketRequest.getPaymentStatus());
                ticket.setTicketStatus(ticketRequest.getTicketStatus());
                ticket.setSeatNumber(ticketRequest.getSeatNumber());
                return ticket;
            }
        }
        return null;
    }

    @Operation(summary = "Delete a ticket by ID")
    @DeleteMapping("/{ticket_id}")
    public String deleteTicket(@PathVariable Integer ticket_id){
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                ticketList.remove(ticket);
                return ticket.toString();
            }
        }

        return "ID NOT FOUND!!!";
    }

    //
//    public List<Ticket> addTicket(@RequestBody Ticket tickets){
//        List<Ticket> addTicketToList = new ArrayList<>();
//        for(Ticket ticket : ticketList){
//            addTicketToList.add(ticket);
//        }
//        return addTicketToList;
//    }

    //POST DATA FALSE
//    @PostMapping
//    public List<Ticket> addTicket(@RequestBody PostTicket postTicket) {
//        List<Ticket> addTicketList = new ArrayList<>();
//
//        for (Ticket ticket : ticketList){
//            addTicketList.add(ticket);
//            return ticketList;
//        }
//
////        addTicketList.add(postTicket);
//        return null;
//    }
//    private String toString(List<Ticket> ticketList) {
//
//    }

//    private List<Ticket> toString(List<Ticket> ticketList) {
//        return ticketList;
//    }


}
