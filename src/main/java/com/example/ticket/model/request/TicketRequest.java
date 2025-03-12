package com.example.ticket.model.request;

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
    private String paymentStatus;
    private String ticketStatus;
    private int seatNumber;
}
