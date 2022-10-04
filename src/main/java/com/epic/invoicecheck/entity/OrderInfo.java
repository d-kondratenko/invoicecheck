package com.epic.invoicecheck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
