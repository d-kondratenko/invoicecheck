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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
