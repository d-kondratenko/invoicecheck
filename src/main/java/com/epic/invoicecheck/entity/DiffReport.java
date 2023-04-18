package com.epic.invoicecheck.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lcv_order_differents")
public class DiffReport {
    @Id
    private Long rowNum;
    private String ttn;
    private String deliveryId;
    @Column(name = "info_2")
    private String info2;
    private String fName;
    private String dateStarted;
    private String productNr;
    private String abbrev;
    private String name;
    private String invoiceNr;
    private String invoiceDate;
    private String zakaz;
    private String invoiceqty;
    private String prin;
    private String fakt;
    private String nedost;
    private String izlish;
    private String notinorder;
    private String brak;
    private String orderDate;
    private String posComment;

}
