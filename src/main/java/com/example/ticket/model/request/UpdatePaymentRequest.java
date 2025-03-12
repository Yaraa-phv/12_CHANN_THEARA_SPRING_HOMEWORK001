package com.example.ticket.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private List<Integer> ticketIds;
    private boolean newPaymentStatus;
}
