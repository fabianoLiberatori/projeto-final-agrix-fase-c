package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository by Farm.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
