package com.epic.invoicecheck.repository;

import com.epic.invoicecheck.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginEntityRepository extends JpaRepository<LoginEntity, Long> {

    LoginEntity findByUserNr(String toUpperCase);

    boolean existsByUserNr(String toUpperCase);
}