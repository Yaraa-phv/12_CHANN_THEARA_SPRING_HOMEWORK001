package com.example.ticket.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private int ticketId;
    private String passengerName;
    private Date travelDate;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private String paymentStatus;
    private String ticketStatus;
    private int seatNumber;
//    private int count = ticketId + 1;

//    public Ticket(int ticketId, String passengerName, String sourceStation, String destinationStation, double price, String paymetStatus, String ticketStatus, int seatNumber) {
//        this.ticketId = ticketId;
//        this.passengerName = passengerName;
//        this.travelDate = new Date();
//        this.sourceStation = sourceStation;
//        this.destinationStation = destinationStation;
//        this.price = price;
//        this.paymetStatus = paymetStatus;
//        this.ticketStatus = ticketStatus;
//        this.seatNumber = seatNumber;
//    }

//
//    public void setTicketId(int ticketId) {
//        this.ticketId = count;
//        count++;
//    }

    @Override
    public String toString() {
        return "\n========) TICKET INFORMATION (========"+
                "\nID:\t" +ticketId +
                "\nNAME:\t" +passengerName +
                "\nDATE:\t" +travelDate +
                "\nSOURCE STATION:\t" +sourceStation +
                "\nDESTINATION STATION:\t" +destinationStation +
                "\nPRICE:\t" +price +
                "\nPAYMENT STATUS:\t" +paymentStatus +
                "\nTICKET STATUS:\t" +ticketStatus +
                "\nSEAT NUMBER:\t" +seatNumber +
                "\n------------------------------------\n";
    }

    public String IdNotFound(){
        return "ID NOT FOUND!!!";
    }

    public String NameNotFound(){
        return "NAME NOT FOUND!!!";
    }
}
