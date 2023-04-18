package com.epic.invoicecheck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "lct_invoice_differents")
@Builder
public class Differents {
    @SequenceGenerator(sequenceName = "lcs_invoice_differents",name = "lcs_invoice_differents",allocationSize = 1)
    @GeneratedValue(generator = "lcs_invoice_differents")
    @Id
    private Long recId;
    private Long deliveryId;
    private String productNr;
    private double quantityInvoice;
    private double quantityOrder;
    private double brack;
    private String invoiceNr;
    private String invoiceDate;
    private double quantityFakt;
    private String posComment;
}
