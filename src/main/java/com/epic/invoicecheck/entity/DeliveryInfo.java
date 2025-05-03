package com.epic.invoicecheck.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lcv_get_deliv_for_order_and_supplire")
@Data
public class DeliveryInfo {
    @Id
    Long deliveryId;
    String orderNr;
    String supplireNr;
}
