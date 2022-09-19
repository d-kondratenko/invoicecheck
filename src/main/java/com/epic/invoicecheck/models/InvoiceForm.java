package com.epic.invoicecheck.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceForm {
    private String orderNr;
    private String supplireNr;
    private byte[] file;
}
