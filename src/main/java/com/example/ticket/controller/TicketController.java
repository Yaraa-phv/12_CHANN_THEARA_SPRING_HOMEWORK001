package com.example.ticket.controller;

import com.example.ticket.model.entity.ApiResponse;
import com.example.ticket.model.entity.Ticket;
import com.example.ticket.model.entity.TicketStatus;
import com.example.ticket.model.request.TicketRequest;
import com.example.ticket.model.request.UpdatePaymentRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    List<Ticket> ticketList = new ArrayList<>();
    public TicketController() {
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
        ticketList.add(new Ticket("Srey Sitharo", "2025-03-12" , "PP" , "KPS",90.5,true, TicketStatus.BOOKED, "9"));
        ticketList.add(new Ticket("Kheng Sovannak","2025-03-09", "PP" , "KPS",90.5,true, TicketStatus.CANCELED, "10"));
        ticketList.add(new Ticket("Leng Hongmeng","2025-03-10", "PP" , "KPS",90.5,false, TicketStatus.COMPLETED,  "11"));
//        id++;
    }


    //DISPLAY ALL TICKET AS STRING

    @Operation(summary = "Get all tickets")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Ticket>>> displayTicketList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
//        page = 0; pageSize = 10;
        if (page < 0 || pageSize <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(
                            false,
                            "INVALID INPUT OF PAGE AND SIZE",
                            HttpStatus.BAD_REQUEST,
                            null,
                            LocalDateTime.now()
                    ));
        }

        int startPage = page*pageSize;
        int endPage = Math.min(startPage+pageSize, ticketList.size());

        if (startPage > ticketList.size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(
                            false,
                            "PAGE SIZE OUT OF RANGE",
                            HttpStatus.BAD_REQUEST,
                            null,
                            LocalDateTime.now()
                    ));
        }

        List<Ticket> ticketListnPagination = ticketList.subList(startPage, endPage);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "TICKETS RETRIEVED SUCCESSFULLY",
                        HttpStatus.OK,
                        ticketListnPagination,
                        LocalDateTime.now()
                )
        );
    }

    @Operation(summary = "Create a new ticket")
    @PostMapping
    public ResponseEntity<ApiResponse<Ticket>> addTicket(@RequestBody Ticket ticket){
        if (ticket.getTicketId()==0 || ticket.getTicketId() <= ticketList.size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(
                            false,
                            "CANNOT ADD TO TICKET LIST",
                            HttpStatus.BAD_REQUEST,
                            null,
                            LocalDateTime.now()
                    ));
        }

        ticket.setTicketId(ticketList.size()+1);
        ticketList.add(ticket);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "ADD TICKET SUCCESSFULLY",
                        HttpStatus.OK,
                        ticket,
                        LocalDateTime.now()
                )

        );
//        if (ticketList.size() == 1 || ticketList.size() == 2 || ticketList.size() == 3){
//            ticket.IdNotFound();
//            ticket.setTicketId(ticketList.size()+1);
//            ticketList.add(ticket);
//        } else {
//            ticket.setTicketId(ticketList.size()+1);
//            ticketList.add(ticket);
//        }
//        return ticket;
    }


    @Operation(summary = "Search ticket by ID")
    @GetMapping("/{ticket_id}")
    public ResponseEntity<ApiResponse<List<Ticket>>> searchTicketId(@PathVariable Integer ticket_id){
        List<Ticket> searchTicket = new ArrayList<>();
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                searchTicket.add(ticket);
            } else if (ticket_id == 0 || ticket_id > ticketList.size()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(
                                false,
                                "ID NOT FOUND",
                                HttpStatus.NOT_FOUND,
                                null,
                                LocalDateTime.now()
                        ));
            }
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "ID FOUND",
                        HttpStatus.OK,
                        searchTicket,
                        LocalDateTime.now()
                )
        );
//        return searchTicket;
    }

    @Operation(summary = "Search tickets by passenger name")
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Ticket>>> searchTicketName(@RequestParam String name) {
        List<Ticket> searchTicketbyName = new ArrayList<>();
        for (Ticket ticket : ticketList){
            if (ticket.getPassengerName().toLowerCase().contains(name.toLowerCase())){
                searchTicketbyName.add(ticket);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(
                                false,
                                "NAME NOT FOUND",
                                HttpStatus.NOT_FOUND,
                                null,
                                LocalDateTime.now()
                        ));
            }
        }
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "NAME FOUND",
                        HttpStatus.OK,
                        searchTicketbyName,
                        LocalDateTime.now()
                )
        );
    }


    //NEED TO MODIFY
    @Operation(summary = "Filter ticket by status and travel date")
    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<List<Ticket>>> filterTicket(@RequestParam TicketStatus status, @RequestParam String travelDate) {
//        LocalDate date = LocalDate.parse(travelDate, DateTimeFormatter.ISO_DATE);

//        List<Ticket> filterTicket = new ArrayList<>();
        List<Ticket> filterTicket =  ticketList.stream()
                .filter(ticket -> ticket.getTicketStatus() == status && ticket.getTravelDate().equalsIgnoreCase(travelDate))
                .collect(Collectors.toList());

        if (filterTicket.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponse<>(
                            false,
                            "TICKETS NOT FOUND",
                            HttpStatus.NO_CONTENT,
                            null,
                            LocalDateTime.now()
                    ));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "TICKETS FOUND",
                        HttpStatus.OK,
                        filterTicket,
                        LocalDateTime.now()
                )
        );
//
        //        Optional<TicketStatus> filter = Arrays.stream(TicketStatus.values())
//                .filter(s -> s.name().equalsIgnoreCase(status))
//                .findFirst();


//        if (filter.isPresent()) {
//            return ticketList.stream()
//                    .filter(ticket -> ticket.getTicketStatus().name().equalsIgnoreCase(status) && ticket.getTravelDate().isEmpty())
//                    .collect(Collectors.toList());
//        } else {
//            System.out.println("STATUS NOT FOUND!!!");
//            return new ArrayList<>();
//        }
    }





    @Operation(summary = "Update an existing ticket by ID")
    @PutMapping("/{ticket_id}")
    public ResponseEntity<ApiResponse<Ticket>> updateTicket(@PathVariable Integer ticket_id, @RequestBody TicketRequest ticketRequest){
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                ticket.setPassengerName(ticketRequest.getPassengerName());
                ticket.setSourceStation(ticketRequest.getSourceStation());
                ticket.setDestinationStation(ticketRequest.getDestinationStation());
                ticket.setPrice(ticketRequest.getPrice());
                ticket.setPaymentStatus(ticketRequest.isPaymentStatus());
                ticket.setTicketStatus(ticketRequest.getTicketStatus());
                ticket.setSeatNumber(ticketRequest.getSeatNumber());
                return ResponseEntity.ok(
                        new ApiResponse<>(
                                true,
                                "TICKETS UPDATED SUCCESSFULLY",
                                HttpStatus.OK,
                                ticket,
                                LocalDateTime.now()
                        )
                );

            } else if (ticket_id == 0 || ticket_id > ticketList.size()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(
                                false,
                                "NO TICKETS UPDATED",
                                HttpStatus.NOT_FOUND,
                                null,
                                LocalDateTime.now()
                        ));
            }
        }
        return null;
    }

    @Operation(summary = "Delete a ticket by ID")
    @DeleteMapping("/{ticket_id}")
    public ResponseEntity<ApiResponse<Ticket>> deleteTicket(@PathVariable Integer ticket_id){
        for (Ticket ticket : ticketList){
            if (ticket.getTicketId() == ticket_id){
                ticketList.remove(ticket);
                return ResponseEntity.ok(
                        new ApiResponse<>(
                                true,
                                "TICKETS DELETED SUCCESSFULLY",
                                HttpStatus.OK,
                                ticket,
                                LocalDateTime.now()
                        )
                );
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(
                        false,
                        "NO TICKETS DELETED",
                        HttpStatus.NOT_FOUND,
                        null,
                        LocalDateTime.now()
                ));
    }


    //RequestBody doesn't work
    @Operation(summary = "Bulk Update payment status for multiple tickets")
    @PutMapping
    public ResponseEntity<ApiResponse<List<Ticket>>> updatePaymentStatus(
            @RequestBody UpdatePaymentRequest request) {

        List<Ticket> updatedTickets = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            if (request.getTicketIds().contains(ticket.getTicketId())) {
                ticket.setPaymentStatus(request.isNewPaymentStatus());
                updatedTickets.add(ticket);
            }
        }

        if (updatedTickets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(
                            false,
                            "NO TICKETS UPDATED",
                            HttpStatus.NOT_FOUND,
                            null,
                            LocalDateTime.now()
                    ));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Payment status updated successfully",
                        HttpStatus.OK,
                        updatedTickets,
                        LocalDateTime.now()
                )
        );
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
//        addTicketList.add(postTicket);
//        return null;
//    }
//    private String toString(List<Ticket> ticketList) {
//
//    }

//    private List<Ticket> toString(List<Ticket> ticketList) {
//        return ticketList;
//    }


}
