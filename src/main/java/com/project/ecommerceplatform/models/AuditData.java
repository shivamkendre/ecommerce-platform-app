package com.project.ecommerceplatform.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AuditData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime createDateTime;
    private String createdBy;
    private LocalDateTime lastUpdateDate;
    private String lastUpdatedBy;
}
