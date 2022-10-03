package com.epic.invoicecheck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
