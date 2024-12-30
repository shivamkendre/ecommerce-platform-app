package com.project.ecommerceplatform.repos;

import com.project.ecommerceplatform.models.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditDataRepo extends JpaRepository<AuditData, Long> {
}
