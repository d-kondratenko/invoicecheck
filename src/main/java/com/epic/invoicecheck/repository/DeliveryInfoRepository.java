package com.epic.invoicecheck.repository;

import com.epic.invoicecheck.entity.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long> {
    @Query("select u from DeliveryInfo u where u.orderNr = ?1 and u.supplireNr = ?2")
    DeliveryInfo findByOrderNrAndSupplireNr(String orderNr, String supplireNr);
}