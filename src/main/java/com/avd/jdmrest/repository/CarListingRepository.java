package com.avd.jdmrest.repository;

import com.avd.jdmrest.domain.CarListing;
import com.avd.jdmrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarListingRepository extends JpaRepository<CarListing, Long>
{
	Iterable<CarListing> getCarListingByOwner( Customer customer );

}