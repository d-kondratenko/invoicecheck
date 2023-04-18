package com.epic.invoicecheck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceData {
    String productNr;
    double quantity;
    double brack;
    double quantityFakt;
    String posComment;
}
