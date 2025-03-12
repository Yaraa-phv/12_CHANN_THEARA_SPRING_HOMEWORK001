package com.example.ticket.model.entity;

import java.util.Date;

public class PostTicket {
    private String passengerName;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private String paymetStatus;
    private String ticketStatus;
    private int seatNumber;

    public PostTicket(String passengerName, String sourceStation, String destinationStation, double price, String paymetStatus, String ticketStatus, int seatNumber){
        this.passengerName = passengerName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.price = price;
        this.paymetStatus = paymetStatus;
        this.ticketStatus = ticketStatus;
        this.seatNumber = seatNumber;
    }
}
