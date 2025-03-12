package com.example.ticket.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTicket {
    private String passengerName;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private String paymetStatus;
    private String ticketStatus;
    private int seatNumber;

}
