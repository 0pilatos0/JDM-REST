package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.CarCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarConditionRepository extends JpaRepository<CarCondition, Long> {
}
