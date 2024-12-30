package com.project.ecommerceplatform.repos;

import com.project.ecommerceplatform.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepo extends JpaRepository<Rating,Long> {
}
