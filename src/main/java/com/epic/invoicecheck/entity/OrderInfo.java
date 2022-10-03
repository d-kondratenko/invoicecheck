package com.epic.invoicecheck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lcv_jv_order_info")
public class OrderInfo {
    @Id
    private Long orderItemId;
    private String cOrderNr;
    private String firmNr;
    private String productNr;
    private double quantity;
}
