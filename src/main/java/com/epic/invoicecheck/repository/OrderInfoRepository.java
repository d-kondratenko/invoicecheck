package com.epic.invoicecheck.repository;

import com.epic.invoicecheck.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
    @Query("select u from OrderInfo u where u.cOrderNr = ?1 and u.firmNr = ?2")
    List<OrderInfo> findByCOrderNrAndFirmNr(String cOrderNr, String firmNr);

}