package com.epic.invoicecheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
