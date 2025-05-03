package com.epic.invoicecheck.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "qcm_sysusers")
public class LoginEntity {

    @Id
    @Column(name = "user_id")
    Long userId;
    @Column(name = "user_nr")
    String userNr;
    @Column(name = "tel1")
    String tel1;
}
