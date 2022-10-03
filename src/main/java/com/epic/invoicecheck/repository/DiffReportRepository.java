package com.epic.invoicecheck.repository;

import com.epic.invoicecheck.entity.DiffReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiffReportRepository extends JpaRepository<DiffReport, Long> {
    @Query("select d from DiffReport d where d.deliveryId = ?1")
    List<DiffReport> findByDeliveryId(String deliveryId);

}