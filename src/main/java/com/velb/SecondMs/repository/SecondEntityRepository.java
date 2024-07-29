package com.velb.SecondMs.repository;

import com.velb.SecondMs.model.entity.SecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondEntityRepository extends JpaRepository<SecondEntity, Long> {
}
