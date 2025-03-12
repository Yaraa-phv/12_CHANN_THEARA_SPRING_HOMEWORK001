package com.example.ticket.model.request;

import com.example.ticket.model.entity.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private String passengerName;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private boolean paymentStatus;
    private TicketStatus ticketStatus;
    private String seatNumber;
}
