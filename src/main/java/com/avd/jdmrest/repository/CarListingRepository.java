package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.CarListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarListingRepository extends JpaRepository<CarListing, Long>
{
	CarListing findCarListingById(Long id);
}