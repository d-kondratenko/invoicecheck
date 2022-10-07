package com.epic.invoicecheck.repository;

import com.epic.invoicecheck.entity.Differents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DifferentsRepository extends JpaRepository<Differents, Long> {
    @Transactional
    @Modifying
    @Query("delete from Differents d where d.deliveryId = ?1")
    void deleteByDeliveryId(Long deliveryId);
}