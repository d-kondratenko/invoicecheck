package com.epic.invoicecheck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
